package cn.seifly.module.wp.web.controller.h5qj.vo.resp.post;

import lombok.Data;

import java.util.List;

@Data
public class CommentRespVO {
    private String approved;// "1"
    private String content;// "这个感觉可以哦"
    private String id;//"941"
    private List<CommentRespVO> replys;// []
    private String time;//"2024-09-10"
    private UserVO user;
}
