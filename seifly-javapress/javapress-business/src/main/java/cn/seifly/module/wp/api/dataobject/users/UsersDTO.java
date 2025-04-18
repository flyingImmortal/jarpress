package cn.seifly.module.wp.api.dataobject.users;

import cn.seifly.common.core.domain.BaseDO;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * 用户 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 @Data
public class UsersDTO extends BaseDO {

    /**
     * 用户id
     */
    
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