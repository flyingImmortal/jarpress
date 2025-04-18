package cn.seifly.module.wp.dao.dataobject.commentmeta;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;

/**
 * 评论元数据 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_commentmeta")
@KeySequence("wp_commentmeta_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentmetaDO extends BaseDO {

    /**
     * 元数据id
     */
    @TableId
    private Long metaId;
    /**
     * 评论id
     */
    private Long commentId;
    /**
     * 评论元数据键
     */
    private String metaKey;
    /**
     * 评论元数据值
     */
    private String metaValue;

}