package cn.seifly.module.wp.dao.dataobject.users;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;

import java.time.LocalDateTime;


/**
 * 用户 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_users")
@KeySequence("wp_users_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDO extends BaseDO {

    /**
     * 用户id
     */
    @TableId
    private Long id;
    /**
     * 登录账号
     */
    private String userLogin;
    /**
     * 登录密码
     */
    private String userPass;
    /**
     * 用户名
     */
    private String userNicename;
    /**
     * 用户email
     */
    private String userEmail;
    /**
     * 用户网址
     */
    private String userUrl;
    /**
     * 注册时间
     */
    private LocalDateTime userRegistered;
    /**
     * 激活key
     */
    private String userActivationKey;
    /**
     * 用户状态
     */
    private Integer userStatus;
    /**
     * 前台显示姓名
     */
    private String displayName;

}