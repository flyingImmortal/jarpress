package cn.seifly.module.wp.web.controller.h5qj.vo.resp.setting;

import cn.seifly.module.wp.web.config.PressIndexConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Schema(description = "index界面")
@Data
public class HomeVO {
    @Schema(description = "logo",  example = "")
    private String logo;
    private String title;
    private String description;
    private String keywords;
    private String list_mode;
    private String background;
    private String share_title;
    private String share_thumb;
    private List<TopNavVO> top_nav;
    private List<PressIndexConfig.IconNav> icon_nav;
    private List<HotVO> hot;
    private List<PressIndexConfig.HomeSlide> home_slide;
    private PressIndexConfig.Actives actives;

}
