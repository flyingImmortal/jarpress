package cn.seifly.module.wp.dao.mysql.posts;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dto.posts.PostsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.dao.dataobject.posts.PostsDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 文章 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface PostsMapper extends BaseMapperX<PostsDO> {

    default PageResult<PostsDO> selectPage(PostsPageReqVO reqVO) {
        reqVO.setPostType("post");
        reqVO.setPostStatus("publish");
        LambdaQueryWrapperX<PostsDO> wrapperX =  new LambdaQueryWrapperX<PostsDO>()
                .eqIfPresent(PostsDO::getPostAuthor, reqVO.getPostAuthor())
                .betweenIfPresent(PostsDO::getPostDate, reqVO.getPostDate())
                .eqIfPresent(PostsDO::getPostDateGmt, reqVO.getPostDateGmt())
                .eqIfPresent(PostsDO::getPostContent, reqVO.getPostContent())
                .eqIfPresent(PostsDO::getPostTitle, reqVO.getPostTitle())
                .eqIfPresent(PostsDO::getPostExcerpt, reqVO.getPostExcerpt())
                .eqIfPresent(PostsDO::getPostStatus, reqVO.getPostStatus())
                .eqIfPresent(PostsDO::getCommentStatus, reqVO.getCommentStatus())
                .eqIfPresent(PostsDO::getPingStatus, reqVO.getPingStatus())
                .eqIfPresent(PostsDO::getPostPassword, reqVO.getPostPassword())
                .likeIfPresent(PostsDO::getPostName, reqVO.getPostName())
                .eqIfPresent(PostsDO::getToPing, reqVO.getToPing())
                .eqIfPresent(PostsDO::getPinged, reqVO.getPinged())
                .eqIfPresent(PostsDO::getPostModified, reqVO.getPostModified())
                .eqIfPresent(PostsDO::getPostModifiedGmt, reqVO.getPostModifiedGmt())
                .eqIfPresent(PostsDO::getPostContentFiltered, reqVO.getPostContentFiltered())
                .eqIfPresent(PostsDO::getPostParent, reqVO.getPostParent())
                .eqIfPresent(PostsDO::getGuid, reqVO.getGuid())
                .eqIfPresent(PostsDO::getMenuOrder, reqVO.getMenuOrder())
                .eqIfPresent(PostsDO::getPostType, reqVO.getPostType())
                .eqIfPresent(PostsDO::getPostMimeType, reqVO.getPostMimeType())
                .eqIfPresent(PostsDO::getCommentCount, reqVO.getCommentCount())
                .ltIfPresent(PostsDO::getId, reqVO.getPrePostId())
                .gtIfPresent(PostsDO::getId, reqVO.getNextPostId())
                .inIfPresent(PostsDO::getId, reqVO.getIdList());
        if("likes".equals(reqVO.getSort())){
            wrapperX.orderByDesc(PostsDO::getId);
        }else if("views".equals(reqVO.getSort())){
            wrapperX.orderByDesc(PostsDO::getId);
        }else if("favorites".equals(reqVO.getSort())){
            wrapperX.orderByDesc(PostsDO::getId);
        }else if("comments".equals(reqVO.getSort())){
            wrapperX.orderByDesc(PostsDO::getCommentCount);
        }else{
            wrapperX.orderByDesc(PostsDO::getId);
        }
        return selectPage(reqVO,wrapperX);
    }

}