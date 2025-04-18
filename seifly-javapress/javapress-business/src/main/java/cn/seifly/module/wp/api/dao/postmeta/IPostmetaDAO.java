package cn.seifly.module.wp.api.dao.postmeta;

import cn.seifly.module.wp.dto.postmeta.PostmetaPageReqVO;
import cn.seifly.common.core.page.PageResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;


/**
 * 文章元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */

public interface IPostmetaDAO {

    PageResult<PostmetaDTO> selectPage(PostmetaPageReqVO reqVO);
    int insert(PostmetaDTO entity);
    int updateById(PostmetaDTO postmetaDTO);
}