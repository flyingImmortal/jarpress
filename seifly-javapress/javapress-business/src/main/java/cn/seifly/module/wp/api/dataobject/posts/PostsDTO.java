package cn.seifly.module.wp.api.dataobject.posts;

import cn.seifly.common.core.domain.BaseDO;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 文章 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

@Data
public class PostsDTO extends BaseDO {

    /**
     * 文章id
     */

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

    private String thumbnail;
    /**
     * 点赞数
     */
    private List<String> like_list;
    /**
     * 标签数
     */
    private List<TermTaxonomyDTO> tags;
    /**
     * 下一条帖子的id
     */
    private Long next;
    /**
     * 上一条帖子的id
     */
    private Long pre;
    /**
     * 是否有下一条帖子
     */
    private Boolean pre_next;
    /**
     * 浏览数
     */
    private Integer views;
    /**
     * 评论数
     */
    private String comment_count;

    /**
     * 收藏数
     */
    private String favorite_count;
    /**
     * 是否可评论
     */
    private String switch_comment = "1";
}