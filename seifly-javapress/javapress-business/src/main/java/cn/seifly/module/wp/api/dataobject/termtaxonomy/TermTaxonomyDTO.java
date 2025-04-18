package cn.seifly.module.wp.api.dataobject.termtaxonomy;

import cn.seifly.common.core.domain.BaseDO;
import lombok.Data;


/**
 * 团队分类 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 @Data
public class TermTaxonomyDTO extends BaseDO {

    /**
     * 分类id
     */
    
    private Long termTaxonomyId;
    /**
     * 团队id
     */
    private Long termId;
    /**
     * 分类类型名
     */
    private String taxonomy;
    /**
     * 描述
     */
    private String description;
    /**
     * 分类父id
     */
    private Long parent;
    /**
     * 总数
     */
    private Long count;

    /**
     * ********************
     */


    /**
     * 名称
     */
    private String name;
    /**
     * URL别名
     */
    private String slug;
    /**
     * 分类组id,无用
     */
    private Long termGroup;

}