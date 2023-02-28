package pers.anuu.basic.protocol.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.anuu.basic.model.BaseReq;
import pers.anuu.basic.protocol.annotations.TokenValidate;
import pers.anuu.biz.user.service.UserLoginService;
import pers.anuu.util.HttpUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author pangxiong
 * @title: RequestAspect
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/517:31
 */
@Aspect
@Component
@Order(1)
public class RequestAspect {
    private static final Logger log = LoggerFactory.getLogger(RequestAspect.class);
    @Resource
    private UserLoginService userLoginService;

    /**
     * 定义切入点
     */
    @Pointcut("execution(* pers.anuu.controller.*.*(..)) && (@annotation(org.springframework.web.bind.annotation.RequestMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.PostMapping))")
    public void cutMethod() {

    }

    /**
     * 环绕切面
     *
     * @param joinPoint 切入点
     * @return 处理结果
     * @throws Throwable 异常
     */
    @Around("cutMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String uri = request.getRequestURI();
        String ip = HttpUtil.getRemoteIP(request);
        log.info("请求API: {} | {} 【{}.{}】", request.getMethod(), uri, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        //获取的接口的入参列表，不如传参列表
        Object[] paramValues = joinPoint.getArgs();

        BaseReq baseReq = null;
        for (Object paramValue : paramValues) {
            if (paramValue instanceof BaseReq) {
                baseReq = (BaseReq) paramValue;
                break;
            }
        }

        if (baseReq == null) {
            //TODO 赋值
        }

        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        Long userId = userLoginService.getUserIdByToken(token);

        log.info("请求参数: token:{},userId:{},ip:{},params:{}", token, userId, ip, baseReq);
        pers.anuu.basic.common.RequestContextHolder.setInfo(userId, ip);

        //校验请求token
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        TokenValidate annotation = method.getAnnotation(TokenValidate.class);
        boolean needTokenValidate = Objects.nonNull(annotation);

        if (needTokenValidate && userId == null) {
            //throw new BaseException("请重新登录");
            return "login";
        }

        Object responseResult = joinPoint.proceed();
        return responseResult;
    }

    /**
     *  MDC.put(ApiConstant.LOG_MDC_KEY, RandomUtil.getUuid());
     *
     *         HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
     *
     *         //2：记录请求开始日志
     *         long startTime = System.currentTimeMillis();
     *         log.info("=================== Request Process Start ===================");
     *         String uri = request.getRequestURI();
     *         String ip = HttpUtil.getRemoteIP(request);
     *         log.info("请求API: {} | {} 【{}.{}】", request.getMethod(), uri, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
     *
     *         //3：提取请求基础参数对象
     *         BaseRequest baseRequest = null;
     *         Object[] paramValues = joinPoint.getArgs();
     *         for (Object paramValue : paramValues) {
     *             if (paramValue instanceof BaseRequest) {
     *                 baseRequest = (BaseRequest) paramValue;
     *                 break;
     *             }
     *         }
     *
     *         Object responseResult = null;
     *         try {
     *             if (Objects.nonNull(baseRequest)) {
     *                 //4：解析并校验请求参数
     *                 parseRequestData(baseRequest, request);
     *
     *                 //5：校验请求token
     *                 Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
     *                 TokenValidate annotation = method.getAnnotation(TokenValidate.class);
     *                 boolean needTokenValidate = Objects.nonNull(annotation);
     *                 String token = baseRequest.getSystem().getLoginToken();
     *                 if (needTokenValidate && StringUtil.isEmpty(token)) {
     *                     throw new TokenInvalidException("Pls login.");
     *                 }
     *                 CheckTokenResult tcr = tokenService.checkToken(token, baseRequest.getSystem().getClientOsType(), cache);
     *                 if (tcr.isSuccess()) {
     *                     baseRequest.setUserId(tcr.getUserId());
     *                 }
     *                 log.info("请求参数: {}", JSONObject.toJSONString(baseRequest));
     *                 if (needTokenValidate && !tcr.isSuccess()) {
     *                     if (StringUtil.isNotEmpty(tcr.getErrorMsg())) {
     *                         throw new TokenInvalidException(tcr.getErrorMsg());
     *                     } else {
     *                         throw new TokenInvalidException();
     *                     }
     *                 }
     *
     *             }
     *
     *             //7：执行请求方法
     *             responseResult = joinPoint.proceed();
     *
     *         } catch (Exception e) {
     *             if (e instanceof BaseException) {
     *                 BaseException be = (BaseException) e;
     *                 if (be.getStatus() != null) {
     *                     responseResult = BaseResponse.parseResponse(be.getStatus().getCode(), be.getMessage());
     *                 } else {
     *                     responseResult = BaseResponse.parseResponse(StatusEnum.FAIL.getCode(), be.getMessage());
     *                 }
     *             } else {
     *                 log.error("异常信息：", e);
     *                 responseResult = BaseResponse.parseResponse(StatusEnum.ERROR.getCode(), StatusEnum.ERROR.getDesc());
     *             }
     *             // 报警
     *             String message = e.getMessage();
     *             if ((!(e instanceof BizException)) && (!(e instanceof TokenInvalidException))) {
     *                 // 如果不是业务类型 并且不是token 的异常，则报警
     *                 dingDingNotify.error(message);
     *             }
     *
     *         } finally {
     *             //处理时间
     *             long runTime = System.currentTimeMillis() - startTime;
     *             log.info("uri:{} 处理耗时: {}ms; 响应结果: {}", uri, runTime, JSONObject.toJSONString(responseResult));
     *             //提取响应结果码用于记录日志
     *             String resultCode = "";
     *             if (responseResult instanceof BaseResponse) {
     *                 resultCode = ((BaseResponse) responseResult).getCode();
     *             }
     *             //记录API处理信息
     *             if (runTime >= MAX_HANDLE_TIME) {
     *                 apiLogger.error("{}|{}|{}|{}", ip, uri, resultCode, runTime);
     *             } else {
     *                 apiLogger.info("{}|{}|{}|{}", ip, uri, resultCode, runTime);
     *             }
     *
     *             log.info("=================== Request Process End ===================");
     *
     *             MDC.remove(ApiConstant.LOG_MDC_KEY);
     *         }
     *
     *         return responseResult;
     */
}
