package cn.seifly.module.wp.api.dao.comments;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import cn.seifly.framework.manager.BaseDAO;

/**
 * 文章评论 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface ICommentsDAO extends BaseDAO {
    PageResult<CommentsDTO> selectPage(CommentsPageReqVO reqVO);

    CommentsDTO selectById(Long commentPostId);

    Integer insert(CommentsDTO commentsDTO);

    Integer updateById(CommentsDTO commentsDTO);
}