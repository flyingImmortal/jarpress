package cn.seifly.module.wp.api.dataobject.terms;

import cn.seifly.common.core.domain.BaseDO;
import lombok.Data;


/**
 * 分类 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

@Data
public class TermsDTO extends BaseDO {

    /**
     * 分类id
     */
    
    private Long termId;
    /**
     * 名称
     */
    private String name;
    /**
     * URL别名
     */
    private String slug;
    /**
     * 分类组id
     */
    private Long termGroup;
    /**
     * 分类id
     */
    private Long id;
    /**
     * 描述
     */
    private String description;

    /**
     * 描述
     */
    private String cover;
}