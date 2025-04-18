package cn.seifly.module.wp.dao.dataobject.usermeta;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;


/**
 * 用户元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_usermeta")
@KeySequence("wp_usermeta_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsermetaDO extends BaseDO {

    /**
     * 用户元数据
     */
    @TableId
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