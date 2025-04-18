package cn.seifly.module.wp.dao.mysql.usermeta;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.usermeta.UsermetaDO;
import cn.seifly.module.wp.dto.usermeta.UsermetaPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface UsermetaMapper extends BaseMapperX<UsermetaDO> {

    default PageResult<UsermetaDO> selectPage(UsermetaPageReqVO reqVO) {
        PageResult s=    selectPage(reqVO, new LambdaQueryWrapperX<UsermetaDO>()
                .eqIfPresent(UsermetaDO::getUserId, reqVO.getUserId())
                .eqIfPresent(UsermetaDO::getMetaKey, reqVO.getMetaKey())
                .eqIfPresent(UsermetaDO::getMetaValue, reqVO.getMetaValue())
                .orderByDesc(UsermetaDO::getUserId));
        return s;
    }

}