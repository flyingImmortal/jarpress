package cn.seifly.module.wp.dao.dataobject.links;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 链接 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_links")
@KeySequence("wp_links_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinksDO extends BaseDO {

    /**
     * 链接id
     */
    @TableId
    private Long linkId;
    /**
     * 链接地址
     */
    private String linkUrl;
    /**
     * 链接名称
     */
    private String linkName;
    /**
     * 图片url
     */
    private String linkImage;
    /**
     * 打开方式
     */
    private String linkTarget;
    /**
     * 描述
     */
    private String linkDescription;
    /**
     * 可见性开关
     */
    private String linkVisible;
    /**
     * 链接的创建人
     */
    private Long linkOwner;
    /**
     * 链接等级
     */
    private Integer linkRating;
    /**
     * 更新时间
     */
    private LocalDateTime linkUpdated;
    /**
     * 链接与定义者的关系
     */
    private String linkRel;
    /**
     * 链接的详细说明
     */
    private String linkNotes;
    /**
     * 链接的RSS地址
     */
    private String linkRss;

}