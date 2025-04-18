package cn.seifly.module.wp.api.dao.posts;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.dto.posts.PostsPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;


/**
 * 文章 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface IPostsDAO   {

     PageResult<PostsDTO> selectPage(PostsPageReqVO reqVO) ;
     PostsDTO selectById(Long id);
     PostsDTO selectRandomPosts();
     int updateById(PostsDTO postsDTO);
}