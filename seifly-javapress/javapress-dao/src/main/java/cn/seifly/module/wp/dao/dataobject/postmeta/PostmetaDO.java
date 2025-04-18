package cn.seifly.module.wp.dao.dataobject.postmeta;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;


/**
 * 文章元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_postmeta")
@KeySequence("wp_postmeta_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostmetaDO extends BaseDO {

    /**
     * 文章元数据id
     */
    @TableId
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