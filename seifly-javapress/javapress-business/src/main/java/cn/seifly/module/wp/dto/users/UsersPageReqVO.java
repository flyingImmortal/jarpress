package cn.seifly.module.wp.dto.users;


import cn.seifly.common.core.page.PageParam;
import cn.seifly.common.core.page.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)

public class UsersPageReqVO extends PageParam {

    @Schema(description = "登录账号")
    private String userLogin;

    @Schema(description = "登录密码")
    private String userPass;

    @Schema(description = "用户名", example = "王五")
    private String userNicename;

    @Schema(description = "用户email")
    private String userEmail;

    @Schema(description = "用户网址", example = "https://www.iocoder.cn")
    private String userUrl;

    @Schema(description = "注册时间")
    private LocalDateTime userRegistered;

    @Schema(description = "激活key")
    private String userActivationKey;

    @Schema(description = "用户状态", example = "1")
    private Integer userStatus;

    @Schema(description = "前台显示姓名", example = "赵六")
    private String displayName;

}