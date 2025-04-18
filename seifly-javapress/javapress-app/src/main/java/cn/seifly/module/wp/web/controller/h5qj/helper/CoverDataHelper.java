package cn.seifly.module.wp.web.controller.h5qj.helper;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.DateUtils;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.module.wp.service.PressInitService;
import cn.seifly.module.wp.web.controller.h5qj.vo.PostListDTO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.PostDetailDTO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.Tags;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.post.CommentRespVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.post.UserVO;

import java.util.ArrayList;
import java.util.List;

public class CoverDataHelper {
    public static void setPostsData(PostListDTO postsDTO,PostsDTO postsDTO1,PostsDTO postsDTO2) {
        postsDTO.setViews(postsDTO1.getViews());
        postsDTO.setFavorites(Integer.valueOf(postsDTO1.getFavorite_count()));
        postsDTO.setLikes(postsDTO1.getLike_list().size());
        postsDTO.setThumbnail(postsDTO1.getThumbnail());
        List<Tags> listTags = new ArrayList<>();
        List<TermTaxonomyDTO> tags = postsDTO2.getTags();
        if (!CollectionUtil.isEmpty(tags)) {
            for (TermTaxonomyDTO termTaxonomyDTO : tags) {
                Tags tagsDTO = new Tags();
                tagsDTO.setId(termTaxonomyDTO.getTermId());
                tagsDTO.setName(termTaxonomyDTO.getName());
                listTags.add(tagsDTO);
            }
        }
        postsDTO.setTags(listTags);
    }
    public static PostListDTO getPostsData(PostsDTO postsDTO) {
        if (postsDTO == null) {
            return null;
        }
        PostListDTO postLastDTO = new PostListDTO();
        postLastDTO.setId(postsDTO.getId());
        postLastDTO.setComment_count(postsDTO.getCommentCount());
        postLastDTO.setTime(DateUtil.formatDate(DateUtils.of(postsDTO.getPostDate())));
        postLastDTO.setTitle(postsDTO.getPostTitle());
//            postLastDTO.setViews(postsDTO.getViews());
        postLastDTO.setThumbnail(postsDTO.getThumbnail());
//            postLastDTO.setStick(postsDTO.getStick());
//            postLastDTO.setTags(postsDTO.getTags());
        return postLastDTO;
    }

    public static PostDetailDTO getPostDetailDTO(PostsDTO postsDTO) {
        if (postsDTO == null) {
            return null;
        }
        PostDetailDTO postLastDTO = BeanUtil.toBean(postsDTO, PostDetailDTO.class);
        postLastDTO.setId(postsDTO.getId());
        postLastDTO.setComment_count(postsDTO.getCommentCount());
        postLastDTO.setTime(DateUtil.formatDate(DateUtils.of(postsDTO.getPostDate())));
        postLastDTO.setTitle(postsDTO.getPostTitle());
        postLastDTO.setContent(postsDTO.getPostContent());
        postLastDTO.setExcerpt(postsDTO.getPostExcerpt());
        if (postsDTO.getCommentStatus().equals("open")) {
            postLastDTO.setSwitch_comment(1);
        } else {
            postLastDTO.setSwitch_comment(0);
        }
        List<String> likes = new ArrayList<>();
        for (String userId : postsDTO.getLike_list()) {
            UsersDTO userDTO = PressInitService.userMap.get(userId);
            if (userDTO != null) {
                likes.add(userDTO.getUserUrl());
            }
        }
        postLastDTO.setFavorite_count(likes.size() + "");
        postLastDTO.setLike_list(likes);
        postLastDTO.setUser(new ArrayList<>());
//            postLastDTO.setViews(postsDTO.getViews());
//            postLastDTO.setThumbnail(postsDTO.getThumbnail());
//            postLastDTO.setStick(postsDTO.getStick());
        List<Tags> tags = new ArrayList<>();
        for (TermTaxonomyDTO postmetaDTO : postsDTO.getTags()) {
            Tags tagsDTO = new Tags();
            tagsDTO.setId(postmetaDTO.getTermId());
            tagsDTO.setName(postmetaDTO.getName());
            tags.add(tagsDTO);
        }
        postLastDTO.setTags(tags);
        return postLastDTO;
    }

    public static List<CommentRespVO> getCommentRespVO(List<CommentsDTO> commentsDTOList, String userId) {
        List<CommentRespVO> list = new ArrayList<>();
        for (CommentsDTO commentsDTO : commentsDTOList) {
            CommentRespVO commentRespVO = new CommentRespVO();
            commentRespVO.setId(commentsDTO.getCommentId() + "");
            commentRespVO.setContent(commentsDTO.getCommentContent());
            commentRespVO.setTime(DateUtil.formatDate(DateUtils.of(commentsDTO.getCommentDate())));
            UsersDTO usersVO = PressInitService.userIdMap.get(commentsDTO.getUserId());
            UserVO userVO = new UserVO();
            userVO.setId(usersVO.getId() + "");
            userVO.setName(usersVO.getUserNicename());
            userVO.setAvatar(usersVO.getUserUrl());
            if (userVO.getId().equals(userId)) {
                userVO.setIs_me(1);
            } else {
                userVO.setIs_me(0);
            }
            commentRespVO.setUser(userVO);
            list.add(commentRespVO);
        }
        return list;
    }
}
