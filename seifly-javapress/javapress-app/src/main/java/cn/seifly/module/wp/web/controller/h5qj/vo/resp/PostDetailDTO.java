package cn.seifly.module.wp.web.controller.h5qj.vo.resp;

import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.post.CatsDTO;
import lombok.Data;

import java.util.List;

@Data
public class PostDetailDTO {
    private List<CatsDTO> cats;
    private Long comment_count;
    private String content;
    private String excerpt;
    private String favorite_count;
    private Long id;
    private List<String> like_list;
    private Long next;
    private Long pre;
    private Boolean pre_next;
    private Integer switch_comment;
    private List<Tags> tags;
    private String thumbnail;
    private String time;
    private String title;
    private List<UsersDTO> user;
    private Integer views;
    private String wx_ad_bottom;
    private String wx_ad_top;
}
