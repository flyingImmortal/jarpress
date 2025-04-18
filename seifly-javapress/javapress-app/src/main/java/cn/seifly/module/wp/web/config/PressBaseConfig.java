package cn.seifly.module.wp.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "press.base")
@Data
public class PressBaseConfig {
    private String logo;
    private String title;
    private String description;
    private String keywords;
    private Integer list_mode;
    private String background;
    private Boolean wx_ad;
    private String share_title;
    private String share_thumb;
    private String avatar_url;
    private String wordpress_url;
    private String post_default_url;
}