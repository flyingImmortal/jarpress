package cn.seifly.module.wp.api.dao.options;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.options.OptionsDTO;
import cn.seifly.module.wp.dto.options.OptionsPageReqVO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 设置参数 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface IOptionsDAO extends BaseDAO {

     PageResult<OptionsDTO> selectPage(OptionsPageReqVO reqVO) ;

}