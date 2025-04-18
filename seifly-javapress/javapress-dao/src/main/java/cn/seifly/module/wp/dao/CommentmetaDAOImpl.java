package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dao.commentmeta.ICommentmetaDAO;
import cn.seifly.module.wp.api.dataobject.commentmeta.CommentmetaDTO;
import cn.seifly.module.wp.dao.mysql.commentmeta.CommentmetaMapper;
import cn.seifly.module.wp.dto.commentmeta.CommentmetaPageReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentmetaDAOImpl implements ICommentmetaDAO {
    @Resource
    private CommentmetaMapper commentmetaMapper;
    @Override
    public PageResult<CommentmetaDTO> selectPage(CommentmetaPageReqVO reqVO) {
        return null;
    }
}
