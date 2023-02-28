package pers.anuu.biz.todolist.model.vo;

import lombok.Data;
import pers.anuu.base.model.BNoteBook;

/**
 * @author pangxiong
 * @title: NoteBookVo
 * @projectName c_channel
 * @description: TODO
 * @date 2022/12/1417:44
 */
@Data
public class NoteBookVo {
    private Long id;
    private String titile;
    private String content;
    private Long tagId;
    private Boolean display=Boolean.TRUE;

    public NoteBookVo(BNoteBook noteBook){
        this.id = noteBook.getId();
        this.titile=noteBook.getTitile();
        this.content=noteBook.getContent();
        this.tagId=noteBook.getTagId();
        this.display= noteBook.getDisplay();
    }

}
