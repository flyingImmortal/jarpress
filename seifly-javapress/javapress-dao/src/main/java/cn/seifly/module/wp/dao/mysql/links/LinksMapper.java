package cn.seifly.module.wp.dao.mysql.links;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.links.LinksDO;
import cn.seifly.module.wp.dto.links.LinksPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 链接 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface LinksMapper extends BaseMapperX<LinksDO> {

    default PageResult<LinksDO> selectPage(LinksPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<LinksDO>()
                .eqIfPresent(LinksDO::getLinkUrl, reqVO.getLinkUrl())
                .likeIfPresent(LinksDO::getLinkName, reqVO.getLinkName())
                .eqIfPresent(LinksDO::getLinkImage, reqVO.getLinkImage())
                .eqIfPresent(LinksDO::getLinkTarget, reqVO.getLinkTarget())
                .eqIfPresent(LinksDO::getLinkDescription, reqVO.getLinkDescription())
                .eqIfPresent(LinksDO::getLinkVisible, reqVO.getLinkVisible())
                .eqIfPresent(LinksDO::getLinkOwner, reqVO.getLinkOwner())
                .eqIfPresent(LinksDO::getLinkRating, reqVO.getLinkRating())
                .eqIfPresent(LinksDO::getLinkUpdated, reqVO.getLinkUpdated())
                .eqIfPresent(LinksDO::getLinkRel, reqVO.getLinkRel())
                .eqIfPresent(LinksDO::getLinkNotes, reqVO.getLinkNotes())
                .eqIfPresent(LinksDO::getLinkRss, reqVO.getLinkRss())
                .orderByDesc(LinksDO::getLinkId));
    }

}