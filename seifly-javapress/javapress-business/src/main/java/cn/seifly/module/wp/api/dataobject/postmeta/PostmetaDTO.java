package cn.seifly.module.wp.api.dataobject.postmeta;

import cn.seifly.common.core.domain.BaseDO;
import lombok.Data;


/**
 * 文章元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 @Data
public class PostmetaDTO extends BaseDO {

    /**
     * 文章元数据id
     */
    
    private Long metaId;
    /**
     * 文章id
     */
    private Long postId;
    /**
     * 键
     */
    private String metaKey;
    /**
     * 值
     */
    private String metaValue;

}