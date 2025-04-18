package cn.seifly.module.wp.web.controller.h5qj;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.core.pojo.CommonResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import cn.seifly.module.wp.service.CommentsService;
import cn.seifly.module.wp.service.PressInitService;
import cn.seifly.module.wp.web.config.LoginInterceptor;
import cn.seifly.module.wp.web.controller.h5qj.helper.CoverDataHelper;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.PostVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.post.CommentRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.seifly.common.core.pojo.CommonResult.success;

/**
 * 评论管理
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@RestController
@RequestMapping("/wp-json/jarpress/v1/")
@Tag(name = "评论管理")
public class CommentController {
    @Resource
    private CommentsService commentsService;

    //https://xcx.seifly.cn/wp-json/jarpress/v1/comment/index?post_id=3504&offset=0&token=false&t=1742660095916&r=5905&os=wx
    @GetMapping("/comment/index")
    @Operation(summary = "查询帖子评论分页")
    public CommonResult<List<CommentRespVO>> getCommentIndex(@ParameterObject PostVO baseVO) {
        String userId = LoginInterceptor.getLoginUserId();
        CommentsPageReqVO reqVO = new CommentsPageReqVO();
        if (baseVO.getOffset() == null) {
            reqVO.setPageNo(1);
        } else {
            reqVO.setPageNo(baseVO.getOffset() / 10 + 1);
        }
        reqVO.setCommentPostId(baseVO.getPost_id());
        PageResult<CommentsDTO> result = commentsService.selectPage(reqVO);
        List<CommentRespVO> list = CoverDataHelper.getCommentRespVO(result.getList(), userId);
        return success(list);
    }

}
