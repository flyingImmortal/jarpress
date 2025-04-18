package cn.seifly.module.wp.web.controller.h5qj.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "Req请求公共参数" )
@Data
public class BaseVO {
    //home?token=false&t=1742657838214&r=3475&os=wx
    @Schema(description = "token",  example = "false")
    private String token;
    @Schema(description = "时间戳",  example = "1742657838214")
    private Long t;
    @Schema(description = "序列",  example = "3475")
    private Integer r;
    @Schema(description = "操作系统",  example = "wx")
    private String os;
}
