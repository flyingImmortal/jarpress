package cn.seifly.module.wp.dao.dataobject.terms;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;


/**
 * 分类 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_terms")
@KeySequence("wp_terms_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TermsDO extends BaseDO {

    /**
     * 团队id
     */
    @TableId
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
     * 分类id
     */
    private Long termGroup;

}