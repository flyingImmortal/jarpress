package cn.seifly.module.wp.api.dao.termrelationships;

import cn.seifly.module.wp.dto.termrelationships.TermRelationshipsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.termrelationships.TermRelationshipsDTO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 团队分类关系 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ITermRelationshipsDAO extends BaseDAO {

    PageResult<TermRelationshipsDTO> selectPage(TermRelationshipsPageReqVO reqVO);

}