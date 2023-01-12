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
 * 用户表
 * </p>
 *
 * @author anuu
 * @since 2022-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    @TableField("login_code")
    private String loginCode;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户状态：1启用，0禁用
     */
    @TableField("user_status")
    private Boolean userStatus;

    /**
     * 用户头像
     */
    @TableField("head_img")
    private String headImg;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户最后一次登录时的ip
     */
    @TableField("last_login_ip")
    private String lastLoginIp;

    /**
     * 最后一次登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     * 注册时间
     */
    @TableField("add_time")
    private Date addTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 删除标志，0有效，删除时值设置为userid
     */
    @TableField("is_delete")
    private Boolean isDelete;


    public static final String ID = "id";

    public static final String LOGIN_CODE = "login_code";

    public static final String PASSWORD = "password";

    public static final String USER_STATUS = "user_status";

    public static final String HEAD_IMG = "head_img";

    public static final String NICKNAME = "nickname";

    public static final String LAST_LOGIN_IP = "last_login_ip";

    public static final String LAST_LOGIN_TIME = "last_login_time";

    public static final String ADD_TIME = "add_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String IS_DELETE = "is_delete";

}
