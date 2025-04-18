package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.posts.IPostsDAO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.dao.dataobject.posts.PostsDO;
import cn.seifly.module.wp.dao.mysql.posts.PostsMapper;
import cn.seifly.module.wp.dto.posts.PostsPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 文章 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class PostsDAOImpl implements IPostsDAO {
    @Resource
    private PostsMapper postsMapper;

    @Override
    public PageResult<PostsDTO> selectPage(PostsPageReqVO reqVO) {
        PageResult<PostsDO> pageResult = postsMapper.selectPage(reqVO);
        return BeanUtil.toBean(pageResult, PostsDTO.class);
    }

    @Override
    public PostsDTO selectById(Long id) {
        PostsDO postsDO = postsMapper.selectById(id);
        return BeanUtil.toBean(postsDO, PostsDTO.class);
    }

    @Override
    public PostsDTO selectRandomPosts() {
        return null;
    }
    @Override
    public int updateById(PostsDTO postsDTO){
        PostsDO entity = BeanUtil.toBean(postsDTO, PostsDO.class);
        return postsMapper.updateById(entity);
    }
}