package cn.seifly.module.wp.dao.mysql.postmeta;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.postmeta.PostmetaDO;
import cn.seifly.module.wp.dto.postmeta.PostmetaPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 文章元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface PostmetaMapper extends BaseMapperX<PostmetaDO> {

    default PageResult<PostmetaDO> selectPage(PostmetaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PostmetaDO>()
                .eqIfPresent(PostmetaDO::getPostId, reqVO.getPostId())
                .eqIfPresent(PostmetaDO::getMetaKey, reqVO.getMetaKey())
                .eqIfPresent(PostmetaDO::getMetaValue, reqVO.getMetaValue())
                .inIfPresent(PostmetaDO::getMetaKey, reqVO.getMetaKeys())
                .inIfPresent(PostmetaDO::getPostId, reqVO.getPostIdList())
                .orderByDesc(PostmetaDO::getMetaId));
    }

}