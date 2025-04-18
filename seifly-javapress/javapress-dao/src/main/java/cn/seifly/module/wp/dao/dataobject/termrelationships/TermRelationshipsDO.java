package cn.seifly.module.wp.dao.dataobject.termrelationships;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;


/**
 * 团队分类关系 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_term_relationships")
@KeySequence("wp_term_relationships_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TermRelationshipsDO extends BaseDO {

    /**
     * 团队id
     */
    @TableId(value = "object_id", type = IdType.INPUT)
    private Long objectId;
    /**
     * 分类id
     */
    //@TableId(value = "term_taxonomy_id", type = IdType.INPUT)
    private Long termTaxonomyId;
    /**
     * 排序
     */
    private Integer termOrder;

}