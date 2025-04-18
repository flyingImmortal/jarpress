package cn.seifly.module.wp.web.controller.h5qj.vo;

import cn.seifly.module.wp.web.controller.h5qj.vo.resp.Tags;
import lombok.Data;

import java.util.List;

@Data
public class PostListDTO {
    private Long comment_count;
    private Long id;
    private String stick;
    private List<Tags> tags;
    private String thumbnail;//
    private String time;//: "2024-05-09"
    private String title;//: "WordPress模块化DIY，重塑企业官网时代"
    private Integer views;//: 1407
    private Integer favorites;//收藏数
    private Integer likes;//点赞数


}
