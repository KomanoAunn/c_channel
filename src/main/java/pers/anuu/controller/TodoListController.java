package pers.anuu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import pers.anuu.base.model.AUser;
import pers.anuu.base.model.BNoteBook;
import pers.anuu.base.service.IAUserService;
import pers.anuu.base.service.IBNoteBookService;
import pers.anuu.basic.common.RequestContextHolder;
import pers.anuu.basic.model.BaseResp;
import pers.anuu.basic.protocol.annotations.TokenValidate;
import pers.anuu.biz.todolist.model.params.QueryTodolistParams;
import pers.anuu.biz.todolist.model.vo.NoteBookVo;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pangxiong
 * @title: TodoListController
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/511:30
 */
@Controller
public class TodoListController extends BaseController {

    @Resource
    private IBNoteBookService noteBookService;
    @Resource
    private IAUserService userService;

    /**
     * <span th:text="${userName}"></span>
     * <span th:text="${userAge}"></span>
     *
     * @param model
     * @return
     */
    @TokenValidate
    @RequestMapping("/todolist")
    public String list(Model model, QueryTodolistParams params) {
        List<BNoteBook> noteBookList = noteBookService.list(
                new QueryWrapper<BNoteBook>()
                        .like(!StringUtils.isEmpty(params.getKeywords()), BNoteBook.TITILE, params.getKeywords()));
        List<NoteBookVo> list = noteBookList.stream().map(NoteBookVo::new).collect(Collectors.toList());
        AUser user = userService.getById(RequestContextHolder.getUserId());
        HashMap<String, Object> reMap = new HashMap<>();
        reMap.put("list", list);
        reMap.put("userName", user.getNickname());
        model.addAllAttributes(reMap);
        return "todolist";
    }

    @ResponseBody
    @TokenValidate
    @RequestMapping("/insert")
    public String insert(ModelMap model, String content, String title) {
        System.out.println(content);
        BNoteBook noteBook = new BNoteBook();
        noteBook.setTitile(title);
        noteBook.setContent(content);
        noteBook.setUserId(RequestContextHolder.getUserId());
        noteBook.setAddTime(new Date());
        noteBookService.save(noteBook);
        return "";
    }

    @ResponseBody
    @TokenValidate
    @RequestMapping("/remove")
    public String remove(ModelMap model, Long id) {
        System.out.println(id);
        noteBookService.removeById(id);
        return "";
    }

    @ResponseBody
    //@TokenValidate
    @RequestMapping("/content")
    public BaseResp getTxt(ModelMap model, Long id) {
        BNoteBook bNoteBook = noteBookService.getById(id);
        model.addAttribute("content", bNoteBook.getContent());
        BaseResp baseResp=new BaseResp();
        baseResp.getData().put("content",bNoteBook.getContent());
        return baseResp;
    }
}
