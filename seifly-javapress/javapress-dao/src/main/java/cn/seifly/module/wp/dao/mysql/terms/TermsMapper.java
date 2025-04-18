package cn.seifly.module.wp.dao.mysql.terms;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.termtaxonomy.TermTaxonomyDO;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dao.dataobject.terms.TermsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * 分类 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface TermsMapper extends BaseMapperX<TermsDO> {

    default PageResult<TermsDO> selectPage(TermsPageReqVO reqVO) {
//        MPJLambdaWrapper<TermsDO> wrapperX = new MPJLambdaWrapper<TermsDO>();
//        wrapperX.selectAll(TermsDO.class);
//        wrapperX.innerJoin(TermTaxonomyDO.class, TermTaxonomyDO::getTermId, TermsDO::getTermId);
//        wrapperX.eq(StringUtils.hasText(reqVO.getTaxonomy()),TermTaxonomyDO::getTaxonomy, reqVO.getTaxonomy());
//        wrapperX.like(StringUtils.hasText(reqVO.getName()), TermsDO::getName, reqVO.getName())
//                .eq(StringUtils.hasText(reqVO.getSlug()), TermsDO::getSlug, reqVO.getSlug())
//                .eq(null != reqVO.getTermGroup(), TermsDO::getTermGroup, reqVO.getTermGroup())
//                .in(!CollectionUtils.isEmpty(reqVO.getIdList()), TermsDO::getTermId, reqVO.getIdList())
//                .orderByDesc(TermsDO::getTermId);
//        List<TermsDO> resultList = selectJoinList(TermsDO.class, wrapperX);
//        return resultList;

        LambdaQueryWrapperX<TermsDO> wrapperX = new LambdaQueryWrapperX<TermsDO>()
                .likeIfPresent(TermsDO::getName, reqVO.getName())
                .eqIfPresent(TermsDO::getSlug, reqVO.getSlug())
                .eqIfPresent(TermsDO::getTermGroup, reqVO.getTermGroup())
                .inIfPresent(TermsDO::getTermId, reqVO.getIdList());
        wrapperX.ne(TermsDO::getTermId,0);
        String sql = "";
        if (StringUtils.hasText(reqVO.getTaxonomy())) {
            sql += (" and term_id in(select t.term_id from  wp_terms AS t, " +
                    " wp_term_taxonomy AS tt where  tt.term_id =t.term_id and  tt.taxonomy IN ('category')) ");
        }
        sql += " order by term_id desc";
        //   .orderByDesc(TermsDO::getTermId));
        wrapperX.last(sql);
        return selectPage(reqVO, wrapperX);
    }

}