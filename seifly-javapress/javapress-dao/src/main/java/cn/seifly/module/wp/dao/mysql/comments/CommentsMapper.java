package cn.seifly.module.wp.dao.mysql.comments;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.comments.CommentsDO;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 文章评论 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface CommentsMapper extends BaseMapperX<CommentsDO> {

    default PageResult<CommentsDO> selectPage(CommentsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommentsDO>()
                .eqIfPresent(CommentsDO::getCommentPostId, reqVO.getCommentPostId())
                .eqIfPresent(CommentsDO::getCommentAuthor, reqVO.getCommentAuthor())
                .eqIfPresent(CommentsDO::getCommentAuthorEmail, reqVO.getCommentAuthorEmail())
                .eqIfPresent(CommentsDO::getCommentAuthorUrl, reqVO.getCommentAuthorUrl())
                .eqIfPresent(CommentsDO::getCommentAuthorIp, reqVO.getCommentAuthorIp())
                .betweenIfPresent(CommentsDO::getCommentDate, reqVO.getCommentDate())
                .eqIfPresent(CommentsDO::getCommentDateGmt, reqVO.getCommentDateGmt())
                .eqIfPresent(CommentsDO::getCommentContent, reqVO.getCommentContent())
                .eqIfPresent(CommentsDO::getCommentKarma, reqVO.getCommentKarma())
                .eqIfPresent(CommentsDO::getCommentApproved, reqVO.getCommentApproved())
                .eqIfPresent(CommentsDO::getCommentAgent, reqVO.getCommentAgent())
                .eqIfPresent(CommentsDO::getCommentType, reqVO.getCommentType())
                .eqIfPresent(CommentsDO::getCommentParent, reqVO.getCommentParent())
                .eqIfPresent(CommentsDO::getUserId, reqVO.getUserId())
                .orderByDesc(CommentsDO::getCommentPostId));
    }

}