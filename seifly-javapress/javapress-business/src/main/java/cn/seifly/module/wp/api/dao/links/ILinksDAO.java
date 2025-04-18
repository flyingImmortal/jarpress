package cn.seifly.module.wp.api.dao.links;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.links.LinksDTO;
import cn.seifly.module.wp.dto.links.LinksPageReqVO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 链接 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ILinksDAO extends BaseDAO {

    PageResult<LinksDTO> selectPage(LinksPageReqVO reqVO);

}