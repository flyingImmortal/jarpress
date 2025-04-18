package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.comments.ICommentsDAO;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.dao.dataobject.comments.CommentsDO;
import cn.seifly.module.wp.dao.dataobject.terms.TermsDO;
import cn.seifly.module.wp.dao.mysql.comments.CommentsMapper;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import cn.seifly.framework.manager.BaseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文章评论 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class CommentsDAOImpl implements ICommentsDAO {
    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public PageResult<CommentsDTO> selectPage(CommentsPageReqVO reqVO) {
        PageResult<CommentsDO> result = commentsMapper.selectPage(reqVO);
        PageResult<CommentsDTO> pageResult = BeanUtil.toBean(result, CommentsDTO.class);
        return pageResult;
    }


    @Override
    public CommentsDTO selectById(Long commentPostId) {
        return BeanUtil.toBean( commentsMapper.selectById(commentPostId), CommentsDTO.class);
    }
    @Override
    public Integer updateById(CommentsDTO commentsDTO) {
        return commentsMapper.updateById(BeanUtil.toBean(commentsDTO, CommentsDO.class));
    }
    @Override
    public Integer insert(CommentsDTO commentsDTO) {
        return commentsMapper.insert(BeanUtil.toBean(commentsDTO, CommentsDO.class));
    }
}