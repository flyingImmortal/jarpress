package cn.seifly.module.wp.api.dataobject.termrelationships;

import cn.seifly.common.core.domain.BaseDO;
import lombok.Data;


/**
 * 团队分类关系 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 @Data
public class TermRelationshipsDTO extends BaseDO {

    /**
     * 团队id
     */
    
    private Long objectId;
    /**
     * 分类id
     */
    
    private Long termTaxonomyId;
    /**
     * 排序
     */
    private Integer termOrder;

}