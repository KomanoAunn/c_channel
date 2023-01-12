package pers.anuu.base.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 记事本表
 * </p>
 *
 * @author anuu
 * @since 2022-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BNoteBook implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 标题
     */
    @TableField("titile")
    private String titile;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 标签ID
     */
    @TableField("tag_id")
    private Long tagId;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private Date addTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String TITILE = "titile";

    public static final String CONTENT = "content";

    public static final String TAG_ID = "tag_id";

    public static final String NICKNAME = "nickname";

    public static final String ADD_TIME = "add_time";

    public static final String UPDATE_TIME = "update_time";

}
