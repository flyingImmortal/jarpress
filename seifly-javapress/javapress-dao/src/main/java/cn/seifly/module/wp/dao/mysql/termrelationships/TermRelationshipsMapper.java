package cn.seifly.module.wp.dao.mysql.termrelationships;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dto.termrelationships.TermRelationshipsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dao.dataobject.termrelationships.TermRelationshipsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 团队分类关系 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface TermRelationshipsMapper extends BaseMapperX<TermRelationshipsDO> {

    default PageResult<TermRelationshipsDO> selectPage(TermRelationshipsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TermRelationshipsDO>()
                .eqIfPresent(TermRelationshipsDO::getTermOrder, reqVO.getTermOrder())
                .eqIfPresent(TermRelationshipsDO::getTermTaxonomyId, reqVO.getTermTaxonomyId())
                .eqIfPresent(TermRelationshipsDO::getObjectId, reqVO.getObjectId())
                .orderByDesc(TermRelationshipsDO::getTermTaxonomyId));
    }

}