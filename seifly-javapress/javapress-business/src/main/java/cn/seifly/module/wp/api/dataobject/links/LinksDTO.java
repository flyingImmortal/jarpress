package cn.seifly.module.wp.api.dataobject.links;

import cn.seifly.common.core.domain.BaseDO;

import java.time.LocalDateTime;

/**
 * 链接 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

 
public class LinksDTO extends BaseDO {

    /**
     * 链接id
     */
    
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