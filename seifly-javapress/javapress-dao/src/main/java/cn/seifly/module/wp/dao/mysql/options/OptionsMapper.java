package cn.seifly.module.wp.dao.mysql.options;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.options.OptionsDO;
import cn.seifly.module.wp.dto.options.OptionsPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 设置参数 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface OptionsMapper extends BaseMapperX<OptionsDO> {
    default PageResult<OptionsDO> selectPage(OptionsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<OptionsDO>()
                .likeIfPresent(OptionsDO::getOptionName, reqVO.getOptionName())
                .eqIfPresent(OptionsDO::getOptionValue, reqVO.getOptionValue())
                .eqIfPresent(OptionsDO::getAutoload, reqVO.getAutoload())
                .orderByDesc(OptionsDO::getOptionId));

    }

}