package cn.seifly.module.wp.dao.dataobject.comments;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 文章评论 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_comments")
@KeySequence("wp_comments_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDO extends BaseDO {

    /**
     * 评论id
     */
    @TableId
    private Long commentId;
    /**
     * 文章id
     */
    private Long commentPostId;
    /**
     * 评论者名
     */
    private String commentAuthor;
    /**
     * 评论者email
     */
    private String commentAuthorEmail;
    /**
     * 评论者头像url
     */
    private String commentAuthorUrl;
    /**
     * 评论者IP
     */
    private String commentAuthorIp;
    /**
     * 评论日期
     */
    private LocalDateTime commentDate;
    /**
     * 评论时间格林尼治时间
     */
    private LocalDateTime commentDateGmt;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论点赞数
     */
    private Integer commentKarma;
    /**
     * 审核状态（0待审/1通过）
     */
    private String commentApproved;
    /**
     * 评论者的客户端信息
     */
    private String commentAgent;
    /**
     * 评论类型
     */
    private String commentType;
    /**
     * 父评论id
     */
    private Long commentParent;
    /**
     * 评论者用户id
     */
    private Long userId;

}