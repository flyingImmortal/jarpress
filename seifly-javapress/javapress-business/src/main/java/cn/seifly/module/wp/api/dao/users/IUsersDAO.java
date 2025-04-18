package cn.seifly.module.wp.api.dao.users;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dto.users.UsersPageReqVO;
import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.framework.manager.BaseDAO;
import cn.seifly.module.wp.dto.users.UsersSaveReqVO;


/**
 * 用户 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface IUsersDAO extends BaseDAO {

    PageResult<UsersDTO> selectPage(UsersPageReqVO reqVO);

    int insert(UsersSaveReqVO reqVO);
    int updateById(UsersSaveReqVO reqVO);

    UsersDTO selectById(Long id);
}