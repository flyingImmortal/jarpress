package cn.seifly.module.wp.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户新增/修改 Request VO")
@Data
public class UsersSaveReqVO {

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16371")
    private Long id;

    @Schema(description = "登录账号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "登录账号不能为空")
    private String userLogin;

    @Schema(description = "登录密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "登录密码不能为空")
    private String userPass;

    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "用户名不能为空")
    private String userNicename;

    @Schema(description = "用户email", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "用户email不能为空")
    private String userEmail;

    @Schema(description = "用户网址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "用户网址不能为空")
    private String userUrl;

    @Schema(description = "注册时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "注册时间不能为空")
    private LocalDateTime userRegistered;

    @Schema(description = "激活key", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "激活key不能为空")
    private String userActivationKey;

    @Schema(description = "用户状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "用户状态不能为空")
    private Integer userStatus;

    @Schema(description = "前台显示姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "前台显示姓名不能为空")
    private String displayName;

}