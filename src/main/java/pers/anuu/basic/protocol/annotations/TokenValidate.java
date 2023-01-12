package pers.anuu.basic.protocol.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Token验证注解,会被TokenAspect切面拦截,然后在切面内做Token的验证
 *
 * @author apache.jing
 * @date 2022/03/22 17L34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenValidate {

}
