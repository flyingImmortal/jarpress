package cn.seifly.module.wp.api.dao.terms;

import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.framework.manager.BaseDAO;


/**
 * 分类 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ITermsDAO extends BaseDAO {

     PageResult<TermsDTO> selectPage(TermsPageReqVO reqVO) ;
     TermsDTO selectById(Long termId);
}