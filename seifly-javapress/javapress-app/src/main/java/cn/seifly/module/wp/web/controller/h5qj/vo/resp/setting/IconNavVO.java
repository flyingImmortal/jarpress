package cn.seifly.module.wp.web.controller.h5qj.vo.resp.setting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IconNavVO {
    private String title;
    private String icon;
    private String link;
    @JsonProperty("switch")
    private String switchStr;
}
