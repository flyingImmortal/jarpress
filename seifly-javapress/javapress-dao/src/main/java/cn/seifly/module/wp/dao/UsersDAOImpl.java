package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.users.IUsersDAO;
import cn.seifly.module.wp.api.dataobject.termrelationships.TermRelationshipsDTO;
import cn.seifly.module.wp.dao.dataobject.termrelationships.TermRelationshipsDO;
import cn.seifly.module.wp.dao.dataobject.users.UsersDO;
import cn.seifly.module.wp.dao.mysql.users.UsersMapper;
import cn.seifly.module.wp.dto.users.UsersPageReqVO;
import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.framework.manager.BaseDAO;
import cn.seifly.module.wp.dto.users.UsersSaveReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class UsersDAOImpl implements IUsersDAO {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public PageResult<UsersDTO> selectPage(UsersPageReqVO reqVO) {
        PageResult<UsersDO> result = usersMapper.selectPage(reqVO);
        PageResult<UsersDTO> pageResult = BeanUtil.toBean(result, UsersDTO.class);

        return pageResult;
    }

    @Override
    public int insert(UsersSaveReqVO reqVO) {
        UsersDO usersDO = BeanUtil.toBean(reqVO, UsersDO.class);
        Integer result = usersMapper.insert(usersDO);
        reqVO.setId(usersDO.getId());
        return result;
    }
    @Override
    public int updateById(UsersSaveReqVO reqVO) {
        UsersDO usersDO = BeanUtil.toBean(reqVO, UsersDO.class);
        return usersMapper.updateById(usersDO);
    }

    @Override
    public UsersDTO selectById(Long id) {
        UsersDO usersDO = usersMapper.selectById(id);
        UsersDTO usersDTO = BeanUtil.toBean(usersDO, UsersDTO.class);
        return usersDTO;
    }
}