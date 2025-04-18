package cn.seifly.module.wp.api.dataobject.commentmeta;

import cn.seifly.common.core.domain.BaseDO;

/**
 * 评论元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

public class CommentmetaDTO extends BaseDO {

    /**
     * 元数据id
     */

    private Long metaId;
    /**
     * 评论id
     */
    private Long commentId;
    /**
     * 评论元数据键
     */
    private String metaKey;
    /**
     * 评论元数据值
     */
    private String metaValue;

}