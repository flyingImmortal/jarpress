package cn.seifly.module.wp.dao.dataobject.posts;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;

import java.time.LocalDateTime;


/**
 * 文章 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_posts")
@KeySequence("wp_posts_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostsDO extends BaseDO {

    /**
     * 文章id
     */
    @TableId
    private Long id;
    /**
     * 文章作者id
     */
    private Long postAuthor;
    /**
     * 创建日期
     */
    private LocalDateTime postDate;
    /**
     * 创建时间
     */
    private LocalDateTime postDateGmt;
    /**
     * 内容
     */
    private String postContent;
    /**
     * 标题
     */
    private String postTitle;
    /**
     * 摘要
     */
    private String postExcerpt;
    /**
     * 状态
     */
    private String postStatus;
    /**
     * 评论开关状态
     */
    private String commentStatus;
    /**
     * ping状态
     */
    private String pingStatus;
    /**
     * 文章密码
     */
    private String postPassword;
    /**
     * 名称
     */
    private String postName;
    /**
     * ping的链接
     */
    private String toPing;
    /**
     * 已经PING过的链接
     */
    private String pinged;
    /**
     * 修改日期
     */
    private LocalDateTime postModified;
    /**
     * 修改时间
     */
    private LocalDateTime postModifiedGmt;
    /**
     * 过滤后内容
     */
    private String postContentFiltered;
    /**
     * 文章父id
     */
    private Long postParent;
    /**
     * 文章的url地址
     */
    private String guid;
    /**
     * 菜单排序
     */
    private Integer menuOrder;
    /**
     * 文章类型
     */
    private String postType;
    /**
     * 附件MIME类型
     */
    private String postMimeType;
    /**
     * 评论总数
     */
    private Long commentCount;

}