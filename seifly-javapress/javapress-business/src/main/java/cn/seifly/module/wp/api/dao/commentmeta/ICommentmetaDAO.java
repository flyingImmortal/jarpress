package cn.seifly.module.wp.api.dao.commentmeta;

import cn.seifly.module.wp.api.dataobject.commentmeta.CommentmetaDTO;
import cn.seifly.module.wp.dto.commentmeta.CommentmetaPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.manager.BaseDAO;

/**
 * 评论元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ICommentmetaDAO extends BaseDAO {

    PageResult<CommentmetaDTO> selectPage(CommentmetaPageReqVO reqVO);

}