package cn.seifly.module.wp.api.dataobject.termmeta;

import cn.seifly.common.core.domain.BaseDO;


/**
 * 团队元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 
public class TermmetaDTO extends BaseDO {

    /**
     * 团队元数据id
     */
    
    private Long metaId;
    /**
     * 团队id
     */
    private Long termId;
    /**
     * 键
     */
    private String metaKey;
    /**
     * 值
     */
    private String metaValue;

}