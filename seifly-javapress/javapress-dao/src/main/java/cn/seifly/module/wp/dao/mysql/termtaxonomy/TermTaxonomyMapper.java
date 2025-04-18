package cn.seifly.module.wp.dao.mysql.termtaxonomy;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.terms.TermsDO;
import cn.seifly.module.wp.dao.dataobject.termtaxonomy.TermTaxonomyDO;
import cn.seifly.module.wp.dto.termtaxonomy.TermTaxonomyPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 团队分类 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface TermTaxonomyMapper extends BaseMapperX<TermTaxonomyDO> {

    default PageResult<TermTaxonomyDO> selectPage(TermTaxonomyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TermTaxonomyDO>()
                .eqIfPresent(TermTaxonomyDO::getTermId, reqVO.getTermId())
                .eqIfPresent(TermTaxonomyDO::getTaxonomy, reqVO.getTaxonomy())
                .eqIfPresent(TermTaxonomyDO::getDescription, reqVO.getDescription())
                .eqIfPresent(TermTaxonomyDO::getParent, reqVO.getParent())
                .eqIfPresent(TermTaxonomyDO::getCount, reqVO.getCount())
                .inIfPresent(TermTaxonomyDO::getTermId, reqVO.getIdList())
                .orderByDesc(TermTaxonomyDO::getTermTaxonomyId));
    }

}