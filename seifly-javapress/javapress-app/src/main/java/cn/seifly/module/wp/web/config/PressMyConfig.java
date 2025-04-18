package cn.seifly.module.wp.web.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "press.my")
public class PressMyConfig {
    private Login login;
    private Category category;
    private Hot hot;
    private Ucenter ucenter;
    private List<MenuVO> menu;

    @Data
    public static class MenuVO {
        private String icon;
        private String line;
        private String link;
        private String page_id;
        @JsonProperty("switch")
        private String switchStr;
        private String title;
        private String tp;
    }
    @Data
    public static class Login {
        private String background;
        private String yhxy;
        private String ystk;
    }

    // #首页横广告位
    @Data
    public static class Category {
        private String background;
        private String description;
        private String title;
        private String wx_ad;
        private String cover;
    }

    @Data
    public static class Hot {
        private String background;
        private String description;
        private String title;
        private String tl_background;
    }

    @Data
    public static class Ucenter {
        private String background;
        private BeianIcp beian_icp;

    }

    @Data
    public static class BeianIcp {
        private String link;
        private String sn;

    }
}