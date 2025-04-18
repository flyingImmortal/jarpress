package cn.seifly.module.wp.dao.dataobject.termtaxonomy;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;


/**
 * 团队分类 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_term_taxonomy")
@KeySequence("wp_term_taxonomy_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TermTaxonomyDO extends BaseDO {

    /**
     * 分类id
     */
    @TableId
    private Long termTaxonomyId;
    /**
     * 团队id
     */
    private Long termId;
    /**
     * 分类名
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

}