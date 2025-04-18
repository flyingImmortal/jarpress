package cn.seifly.module.wp.api.dataobject.usermeta;

import cn.seifly.common.core.domain.BaseDO;


/**
 * 用户元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 
public class UsermetaDTO extends BaseDO {

    /**
     * 用户元数据
     */
    
    private Long umetaId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 键
     */
    private String metaKey;
    /**
     * 值
     */
    private String metaValue;

}