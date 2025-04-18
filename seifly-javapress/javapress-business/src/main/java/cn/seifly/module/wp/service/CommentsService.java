package cn.seifly.module.wp.service;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.comments.ICommentsDAO;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论信息
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@Service
public class CommentsService {
    @Autowired
    private ICommentsDAO commentsDAO;


    public CommentsDTO selectById(Long id) {
        return commentsDAO.selectById(id);
    }

    public PageResult<CommentsDTO> selectPage(CommentsPageReqVO reqVO) {
        return commentsDAO.selectPage(reqVO);
    }

    public List<Long> getAllLastComments() {
        CommentsPageReqVO dto = new CommentsPageReqVO();
        dto.setPageSize(CommentsPageReqVO.PAGE_SIZE_NONE);
        List<CommentsDTO> pageResultList = commentsDAO.selectPage(dto).getList();
        List<Long> list = new ArrayList<>();
        for (CommentsDTO commentsDTO : pageResultList) {
            list.add(commentsDTO.getCommentId());
        }
        return list;
    }


    public List<Long> selectPageListId(CommentsPageReqVO dto) {
        List<CommentsDTO> pageResultList = commentsDAO.selectPage(dto).getList();
        List<Long> list = new ArrayList<>();
        for (CommentsDTO commentsDTO : pageResultList) {
            list.add(commentsDTO.getCommentId());
        }
        return list;
    }
}
