package cn.seifly.module.wp.api.dao.usermeta;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dto.usermeta.UsermetaPageReqVO;
import cn.seifly.module.wp.api.dataobject.usermeta.UsermetaDTO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 用户元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface IUsermetaDAO extends BaseDAO {

     PageResult<UsermetaDTO> selectPage(UsermetaPageReqVO reqVO) ;

}