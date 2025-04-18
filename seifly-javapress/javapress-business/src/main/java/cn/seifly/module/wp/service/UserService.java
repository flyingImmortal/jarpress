package cn.seifly.module.wp.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.seifly.module.wp.api.dao.users.IUsersDAO;
import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.module.wp.comm.Constants;
import cn.seifly.module.wp.dto.users.UsersPageReqVO;
import cn.seifly.module.wp.dto.users.UsersSaveReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息初始化信息
 *
 * @author sxfei 2016-07-10
 */
@Service
public class UserService {
    @Resource
    private IUsersDAO usersDAO;

    public UsersDTO getUserById(String userId) {
        UsersDTO usersDTO = PressInitService.userMap.get(userId);
        if (usersDTO != null) {
            return usersDTO;
        }
        usersDTO = usersDAO.selectById(Long.valueOf(userId));
        PressInitService.userMap.put(userId, usersDTO);
        return usersDTO;
    }

    public UsersDTO registByOpenId(String openId, String avatar) {
        UsersPageReqVO reqVO = new UsersPageReqVO();
        reqVO.setUserLogin(openId);
        List<UsersDTO> list = usersDAO.selectPage(reqVO).getList();
        UsersDTO usersDTO = null;
        if (CollectionUtil.isEmpty(list)) {
            UsersSaveReqVO user = new UsersSaveReqVO();
            user.setUserLogin(openId);
            user.setUserUrl(avatar);
            usersDAO.insert(user);
            user.setUserNicename("微信用户00" + user.getId());
            usersDAO.updateById(user);
            usersDTO = BeanUtil.toBean(user, UsersDTO.class);
            usersDTO.setUserLogin(openId);
            PressInitService.userMap.put(user.getId() + "", usersDTO);
        } else {
            usersDTO = list.get(0);
        }
        return usersDTO;
    }
}
