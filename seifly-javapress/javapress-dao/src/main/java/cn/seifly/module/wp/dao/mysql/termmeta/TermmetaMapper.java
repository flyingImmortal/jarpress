package cn.seifly.module.wp.dao.mysql.termmeta;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dto.termmeta.TermmetaPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dao.dataobject.termmeta.TermmetaDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 团队元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface TermmetaMapper extends BaseMapperX<TermmetaDO> {

    default PageResult<TermmetaDO> selectPage(TermmetaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TermmetaDO>()
                .eqIfPresent(TermmetaDO::getTermId, reqVO.getTermId())
                .eqIfPresent(TermmetaDO::getMetaKey, reqVO.getMetaKey())
                .eqIfPresent(TermmetaDO::getMetaValue, reqVO.getMetaValue())
                .orderByDesc(TermmetaDO::getMetaId));
    }

}