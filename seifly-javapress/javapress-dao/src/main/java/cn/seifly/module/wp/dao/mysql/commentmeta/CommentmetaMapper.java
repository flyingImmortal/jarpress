package cn.seifly.module.wp.dao.mysql.commentmeta;

import cn.seifly.framework.mybaits.BaseMapperX;
import cn.seifly.module.wp.dao.dataobject.commentmeta.CommentmetaDO;
import cn.seifly.module.wp.dto.commentmeta.CommentmetaPageReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.framework.mybaits.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;


/**
 * 评论元数据 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Mapper
public interface CommentmetaMapper extends BaseMapperX<CommentmetaDO> {

    default PageResult<CommentmetaDO> selectPage(CommentmetaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommentmetaDO>()
                .eqIfPresent(CommentmetaDO::getCommentId, reqVO.getCommentId())
                .eqIfPresent(CommentmetaDO::getMetaKey, reqVO.getMetaKey())
                .eqIfPresent(CommentmetaDO::getMetaValue, reqVO.getMetaValue())
                .orderByDesc(CommentmetaDO::getCommentId));
    }

}