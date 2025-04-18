package cn.seifly.module.wp.dto.users;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户 Response VO")
@Data
@ExcelIgnoreUnannotated
public class UsersRespVO {

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "16371")
    @ExcelProperty("用户id")
    private Long id;

    @Schema(description = "登录账号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("登录账号")
    private String userLogin;

    @Schema(description = "登录密码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("登录密码")
    private String userPass;

    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("用户名")
    private String userNicename;

    @Schema(description = "用户email", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("用户email")
    private String userEmail;

    @Schema(description = "用户网址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("用户网址")
    private String userUrl;

    @Schema(description = "注册时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("注册时间")
    private LocalDateTime userRegistered;

    @Schema(description = "激活key", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("激活key")
    private String userActivationKey;

    @Schema(description = "用户状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("用户状态")
    private Integer userStatus;

    @Schema(description = "前台显示姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("前台显示姓名")
    private String displayName;

}