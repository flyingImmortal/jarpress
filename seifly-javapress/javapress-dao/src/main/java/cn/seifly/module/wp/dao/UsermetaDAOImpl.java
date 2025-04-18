package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dao.usermeta.IUsermetaDAO;
import cn.seifly.module.wp.dao.mysql.usermeta.UsermetaMapper;
import cn.seifly.module.wp.dto.usermeta.UsermetaPageReqVO;
import cn.seifly.module.wp.api.dataobject.usermeta.UsermetaDTO;
import cn.seifly.framework.manager.BaseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class UsermetaDAOImpl implements IUsermetaDAO {
     @Resource
     private UsermetaMapper usermetaMapper;
     @Override
     public   PageResult<UsermetaDTO> selectPage(UsermetaPageReqVO reqVO) {
          return null;
     }

}