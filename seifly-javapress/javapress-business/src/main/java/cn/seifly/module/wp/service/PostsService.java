package cn.seifly.module.wp.service;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dao.comments.ICommentsDAO;
import cn.seifly.module.wp.api.dao.postmeta.IPostmetaDAO;
import cn.seifly.module.wp.api.dao.posts.IPostsDAO;
import cn.seifly.module.wp.api.dao.termrelationships.ITermRelationshipsDAO;
import cn.seifly.module.wp.api.dao.terms.ITermsDAO;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;
import cn.seifly.module.wp.api.dataobject.termrelationships.TermRelationshipsDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.module.wp.comm.Constants;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import cn.seifly.module.wp.dto.postmeta.PostmetaPageReqVO;
import cn.seifly.module.wp.dto.posts.PostsPageReqVO;
import cn.seifly.module.wp.dto.termrelationships.TermRelationshipsPageReqVO;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帖子信息管理
 *
 * @author sxfei 2016-07-10
 */
@Service
public class PostsService {
    private static Logger log = LoggerFactory.getLogger(PostsService.class);
    @Autowired
    private IPostsDAO postsDAO;
    @Autowired
    private IPostmetaDAO postmetaDAO;
    @Autowired
    private ITermsDAO termsDAO;
    @Autowired
    private ITermRelationshipsDAO termRelationshipsDAO;
    @Autowired
    private ICommentsDAO commentsDAO;

    public Integer postCommentsInsert(CommentsDTO dto) {
        return commentsDAO.insert(dto);
    }

    public Integer postMetaInsert(PostmetaDTO dto) {
        Integer result = 0;
        if (StringUtils.hasText(dto.getMetaValue())) {
            PostmetaPageReqVO reqVO = new PostmetaPageReqVO();
            reqVO.setMetaValue(dto.getMetaValue());
            reqVO.setMetaKey(dto.getMetaKey());
            List<PostmetaDTO> list = postmetaDAO.selectPage(reqVO).getList();
            if (CollectionUtils.isEmpty(list)) {
                postmetaDAO.insert(dto);
            }else{
                return 0;
            }
        }
        String key = "";
        if (Constants.VIEWS.equals(dto.getMetaKey())) {
            key = Constants.VIEWS_COUNT;
        } else if (Constants.FAVORITES.equals(dto.getMetaKey())) {
            key = Constants.FAVORITES_COUNT;
        } else if (Constants.LIKES.equals(dto.getMetaKey())) {
            key = Constants.LIKES_COUNT;
        }

        PostmetaPageReqVO reqVO = new PostmetaPageReqVO();
        reqVO.setPostId(dto.getPostId());
        reqVO.setMetaKey(key);
        reqVO.setPageSize(1);
        List<PostmetaDTO> lists = postmetaDAO.selectPage(reqVO).getList();
        if (!CollectionUtils.isEmpty(lists)) {
            PostmetaDTO temp = lists.get(0);
            temp.setMetaValue(String.valueOf(Integer.parseInt(temp.getMetaValue()) + 1));
            result = postmetaDAO.updateById(temp);
        } else {
            dto.setMetaKey(key);
            dto.setMetaValue("1");
            result = postmetaDAO.insert(dto);
        }
        return result;
    }

    public Integer updateById(PostsDTO dto) {
        return postsDAO.updateById(dto);
    }

    public PostsDTO selectById(Long id) {
        PostsDTO postsDTO = postsDAO.selectById(id);
        if (null == postsDTO) {
            return postsDTO;
        }
        PostsPageReqVO reqVO1 = new PostsPageReqVO();
        reqVO1.setNextPostId(id);
        reqVO1.setPageSize(1);
        List<PostsDTO> postsDTOList = postsDAO.selectPage(reqVO1).getList();
        for (PostsDTO postsDTO1 : postsDTOList) {
            postsDTO.setNext(postsDTO1.getId());
        }
        reqVO1 = new PostsPageReqVO();
        reqVO1.setPrePostId(id);
        reqVO1.setPageSize(1);
        List<PostsDTO> postsDTOList2 = postsDAO.selectPage(reqVO1).getList();
        postsDTO.setPre_next(false);
        for (PostsDTO postsDTO1 : postsDTOList2) {
            postsDTO.setPre(postsDTO1.getId());
            postsDTO.setPre_next(true);
        }
        //查询标签
        PostsDTO postsDTO1 = setTags(postsDTO.getId());
        postsDTO.setTags(postsDTO1.getTags());
        //设置评论数量
//        CommentsPageReqVO reqVO2 = new CommentsPageReqVO();
//        reqVO2.setCommentPostId(postsDTO.getId());
//        PageResult<CommentsDTO> commentsDTOPageResult = commentsDAO.selectPage(reqVO2);
        postsDTO.setComment_count(String.valueOf(postsDTO.getCommentCount()));
        postsDTO.setSwitch_comment(postsDTO.getCommentStatus().equals("open") ? "1" : "0");
        //设置点赞和浏览数
        setPostsDTO(postsDTO);
        return postsDTO;
    }

    public PostsDTO setTags(Long postsId) {
        PostsDTO postsDTO = new PostsDTO();
        //查询标签
        TermRelationshipsPageReqVO reqVO = new TermRelationshipsPageReqVO();
        reqVO.setObjectId(postsId);
        reqVO.setPageSize(PostsPageReqVO.PAGE_SIZE_NONE);
        List<TermRelationshipsDTO> relationshipsDTOList = termRelationshipsDAO.selectPage(reqVO).getList();
        List<TermTaxonomyDTO> tags = new ArrayList<>();
        for (TermRelationshipsDTO postmetaDTO : relationshipsDTOList) {
            TermTaxonomyDTO termTaxonomyDTO = PressInitService.termTaxonomyIdTerms.get(postmetaDTO.getTermTaxonomyId());
            if (null == termTaxonomyDTO) {
                continue;
            }
            if (Constants.POST_TAG.equals(termTaxonomyDTO.getTaxonomy())) {
                tags.add(termTaxonomyDTO);
            }
        }
        postsDTO.setTags(tags);
        return postsDTO;
    }

    public PostsDTO setPostsDTO(Long postId) {
        List<String> likes = new ArrayList<>();
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setFavorite_count("0");
        postsDTO.setLike_list(likes);
        postsDTO.setViews(0);
        List<String> keys = Lists.newArrayList(Constants._THUMBNAIL_ID, Constants.VIEWS_COUNT, Constants.FAVORITES_COUNT, Constants.LIKES);
        PostmetaPageReqVO reqV1 = new PostmetaPageReqVO();
        reqV1.setPostId(postId);
        reqV1.setMetaKeys(keys);
        PageResult<PostmetaDTO> postmetaDTOList = postmetaDAO.selectPage(reqV1);
        if (postmetaDTOList == null || CollectionUtils.isEmpty(postmetaDTOList.getList())) {
            return postsDTO;
        }
        Integer viewCount = 0;
        Integer favoriteCount = 0;
        for (PostmetaDTO postmetaDTO : postmetaDTOList.getList()) {
            if (Constants.LIKES.equals(postmetaDTO.getMetaKey())) {
                likes.add(postmetaDTO.getMetaValue());
            }
            if (Constants.VIEWS_COUNT.equals(postmetaDTO.getMetaKey())) {
                viewCount = Integer.valueOf(postmetaDTO.getMetaValue());
            }
            if (Constants.FAVORITES_COUNT.equals(postmetaDTO.getMetaKey())) {
                favoriteCount = Integer.valueOf(postmetaDTO.getMetaValue());
            }
            if (Constants._THUMBNAIL_ID.equals(postmetaDTO.getMetaKey())) {
                PostsDTO postsDTO1 = postsDAO.selectById(Long.valueOf(postmetaDTO.getMetaValue()));
                if (null != postsDTO1 && postsDTO1.getPostMimeType() != null &&
                        postsDTO1.getPostMimeType().startsWith("image")) {
                    postsDTO.setThumbnail(postsDTO1.getGuid());
                }

            }
        }
        postsDTO.setViews(viewCount);
        postsDTO.setLike_list(likes);
        postsDTO.setFavorite_count(favoriteCount + "");
        return postsDTO;
    }

    private void setPostsDTO(PostsDTO postsDTO) {
        PostsDTO postsDTO1 = setPostsDTO(postsDTO.getId());
        postsDTO.setThumbnail(postsDTO1.getGuid());
        postsDTO.setViews(postsDTO1.getViews());
        postsDTO.setLike_list(postsDTO1.getLike_list());
        postsDTO.setFavorite_count(postsDTO1.getFavorite_count());
    }

    public PageResult<PostsDTO> selectPageMyCommon(PostsPageReqVO dto, String userId) {
        PageResult<PostsDTO> pageResult = new PageResult<>();
        pageResult.setTotal(0l);
        pageResult.setList(new ArrayList<>());
        CommentsPageReqVO reqVO = new CommentsPageReqVO();
        reqVO.setUserId(Long.valueOf(userId));
        reqVO.setPageNo(dto.getPageNo());
        reqVO.setPageSize(dto.getPageSize());
        PageResult<CommentsDTO> postmetaDTOList = commentsDAO.selectPage(reqVO);
        pageResult.setTotal(postmetaDTOList.getTotal());
        if (postmetaDTOList == null || CollectionUtils.isEmpty(postmetaDTOList.getList())) {
            return pageResult;
        }
        List<Long> idList = new ArrayList<>();
        for (CommentsDTO postmetaDTO : postmetaDTOList.getList()) {
            idList.add(postmetaDTO.getCommentPostId());
        }
        List<PostsDTO> list = getByIds(idList);
        pageResult.setList(list);
        return pageResult;
    }

    public PageResult<PostsDTO> selectPageMy(PostsPageReqVO dto, String userId, String key) {
        PageResult<PostsDTO> pageResult = new PageResult<>();
        pageResult.setTotal(0l);
        pageResult.setList(new ArrayList<>());
        PostmetaPageReqVO reqVO = new PostmetaPageReqVO();
        reqVO.setMetaKey(key);
        reqVO.setMetaValue(userId);
        reqVO.setPageNo(dto.getPageNo());
        reqVO.setPageSize(dto.getPageSize());
        PageResult<PostmetaDTO> postmetaDTOList = postmetaDAO.selectPage(reqVO);
        pageResult.setTotal(postmetaDTOList.getTotal());
        if (postmetaDTOList == null || CollectionUtils.isEmpty(postmetaDTOList.getList())) {
            return pageResult;
        }
        List<Long> idList = new ArrayList<>();
        for (PostmetaDTO postmetaDTO : postmetaDTOList.getList()) {
            idList.add(postmetaDTO.getPostId());
        }
        List<PostsDTO> list = getByIds(idList);
        pageResult.setList(list);
        return pageResult;
    }

    public PageResult<PostsDTO> selectPage(PostsPageReqVO dto) {
        PageResult<PostsDTO> postsDTOList = postsDAO.selectPage(dto);
        List<Long> idList = getPostsIdList(postsDTOList.getList());
        if (CollectionUtils.isEmpty(idList)) {
            return postsDTOList;
        }
        PostmetaPageReqVO reqVO = new PostmetaPageReqVO();
        reqVO.setPostIdList(idList);
        List<PostmetaDTO> postmetaDTOList = postmetaDAO.selectPage(reqVO).getList();
        Map<Long, PostsDTO> map = new HashMap<>();
        for (PostmetaDTO postmetaDTO : postmetaDTOList) {
            PostsDTO postDTO = map.get(postmetaDTO.getPostId());
            if (null == postDTO) {
                postDTO = new PostsDTO();
            }
            if (Constants.POSTMETA_KEY_CATEGORY.equals(postmetaDTO.getMetaKey())) {
                //postDTO.setCategory(postmetaDTO.getMetaValue());
            } else if (Constants.POSTMETA_KEY_TAG.equals(postmetaDTO.getMetaKey())) {
                //postDTO.setTag(postmetaDTO.getMetaValue());
            } else if (Constants._WP_ATTACHED_FILE.equals(postmetaDTO.getMetaKey())) {
                postDTO.setThumbnail(postmetaDTO.getMetaValue());
            }
        }
        return postsDTOList;
    }


    public List<Long> getPostsIdList(List<PostsDTO> postsDTOList) {
        List<Long> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(postsDTOList)) {
            return result;
        }
        for (PostsDTO postsDTO : postsDTOList) {
            result.add(postsDTO.getId());
        }
        return result;

    }

    public List<PostsDTO> getByIds(List<Long> idList) {
        List<PostsDTO> result = Lists.newArrayList();
        if (CollectionUtils.isEmpty(idList)) {
            return result;
        }
        PostsPageReqVO dto = new PostsPageReqVO();
        dto.setIdList(idList);
        result = selectPage(dto).getList();
        for (PostsDTO postsDTO : result) {
            setPostsDTO(postsDTO);
        }
        return result;
    }


}
