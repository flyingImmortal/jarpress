package cn.seifly.module.wp.dao;

import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.postmeta.IPostmetaDAO;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.dao.dataobject.comments.CommentsDO;
import cn.seifly.module.wp.dao.dataobject.postmeta.PostmetaDO;
import cn.seifly.module.wp.dao.mysql.postmeta.PostmetaMapper;
import cn.seifly.module.wp.dto.postmeta.PostmetaPageReqVO;
import cn.seifly.common.core.page.PageResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 文章元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class PostmetaDAOImpl implements IPostmetaDAO {

    @Resource
    private PostmetaMapper postmetaMapper;

    @Override
    public PageResult<PostmetaDTO> selectPage(PostmetaPageReqVO reqVO) {
        PageResult<PostmetaDO> result = postmetaMapper.selectPage(reqVO);
        PageResult<PostmetaDTO> pageResult = BeanUtil.toBean(result, PostmetaDTO.class);
        return pageResult;

    }

    @Override
    public int insert(PostmetaDTO postmetaDTO) {
        PostmetaDO entity = BeanUtil.toBean(postmetaDTO, PostmetaDO.class);
        return postmetaMapper.insert(entity);
    }
    @Override
    public int updateById(PostmetaDTO postmetaDTO) {
        PostmetaDO entity = BeanUtil.toBean(postmetaDTO, PostmetaDO.class);
        return postmetaMapper.updateById(entity);
    }
}