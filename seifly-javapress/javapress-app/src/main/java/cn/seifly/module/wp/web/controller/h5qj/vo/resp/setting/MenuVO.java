package cn.seifly.module.wp.web.controller.h5qj.vo.resp.setting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MenuVO {
    private String icon;
    private String line;
    private String link;
    private String page_id;
    @JsonProperty("switch")
    private String switchStr;
    private String title;
    private String tp;
}
