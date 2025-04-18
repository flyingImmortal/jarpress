package cn.seifly.module.wp.dao.dataobject.termmeta;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;


/**
 * 团队元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_termmeta")
@KeySequence("wp_termmeta_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TermmetaDO extends BaseDO {

    /**
     * 团队元数据id
     */
    @TableId
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