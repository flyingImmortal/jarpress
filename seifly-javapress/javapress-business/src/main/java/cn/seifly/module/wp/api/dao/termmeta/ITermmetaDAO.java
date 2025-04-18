package cn.seifly.module.wp.api.dao.termmeta;

import cn.seifly.module.wp.dto.termmeta.TermmetaPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.termmeta.TermmetaDTO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 团队元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ITermmetaDAO extends BaseDAO {

     PageResult<TermmetaDTO> selectPage(TermmetaPageReqVO reqVO) ;

}