package cn.seifly.module.wp.web.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "press.index")
public class PressIndexConfig {
    private List<Long> top_nav;// 1 #顶部导航 分类id,逗号分隔
    private List<IconNav> icon_nav;//1 #幻灯片 文章id,逗号分隔
    private List<Long> hot;// 1 #首页热门 文章id,逗号分隔
    private List<HomeSlide> home_slide;
    private Actives actives;
    private List<String> category_default_img;
    private String hot_default_img;
    @Data
    public static class IconNav{
        private String title;
        private String icon;
        private String link;
        @JsonProperty("switch")
        private String switchStr;
    }
    // #首页横广告位
    @Data
    public static class HomeSlide {

        private String image;
        private String link;
        private String switchStr;//
    }

    @Data
    public static class Actives {//: #首页小广告位

        public ActivesSon left;
        public ActivesSon right_top;
        public ActivesSon right_down;
        @Data
        public static class ActivesSon {
            private String image;
            private String link;
            private String title;
        }
    }
}