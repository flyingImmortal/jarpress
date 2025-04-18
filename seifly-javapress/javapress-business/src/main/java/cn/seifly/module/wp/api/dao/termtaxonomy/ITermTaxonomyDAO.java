package cn.seifly.module.wp.api.dao.termtaxonomy;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dto.termtaxonomy.TermTaxonomyPageReqVO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 团队分类 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ITermTaxonomyDAO extends BaseDAO {

    PageResult<TermTaxonomyDTO> selectPage(TermTaxonomyPageReqVO reqVO);

}