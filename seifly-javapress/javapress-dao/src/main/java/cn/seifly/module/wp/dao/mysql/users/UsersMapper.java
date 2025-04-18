package cn.seifly.module.wp.dao.mysql.users;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.users.UsersDO;
import cn.seifly.module.wp.dto.users.UsersPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface UsersMapper extends BaseMapperX<UsersDO> {

    default PageResult<UsersDO> selectPage(UsersPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UsersDO>()
                .eqIfPresent(UsersDO::getUserLogin, reqVO.getUserLogin())
                .eqIfPresent(UsersDO::getUserPass, reqVO.getUserPass())
                .likeIfPresent(UsersDO::getUserNicename, reqVO.getUserNicename())
                .eqIfPresent(UsersDO::getUserEmail, reqVO.getUserEmail())
                .eqIfPresent(UsersDO::getUserUrl, reqVO.getUserUrl())
                .eqIfPresent(UsersDO::getUserRegistered, reqVO.getUserRegistered())
                .eqIfPresent(UsersDO::getUserActivationKey, reqVO.getUserActivationKey())
                .eqIfPresent(UsersDO::getUserStatus, reqVO.getUserStatus())
                .likeIfPresent(UsersDO::getDisplayName, reqVO.getDisplayName())
                .orderByDesc(UsersDO::getId));
    }

}