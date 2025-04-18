package cn.seifly.module.wp.web.controller.h5qj;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.hutool.core.collection.CollectionUtil;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.core.pojo.CommonResult;
import cn.seifly.common.utils.ip.IpUtils;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.module.wp.comm.Constants;
import cn.seifly.module.wp.dto.posts.PostsPageReqVO;
import cn.seifly.module.wp.service.PostsService;
import cn.seifly.module.wp.service.PressInitService;
import cn.seifly.module.wp.service.UserService;
import cn.seifly.module.wp.web.config.LoginInterceptor;
import cn.seifly.module.wp.web.config.PressBaseConfig;
import cn.seifly.module.wp.web.config.PressIndexConfig;
import cn.seifly.module.wp.web.controller.h5qj.helper.CoverDataHelper;
import cn.seifly.module.wp.web.controller.h5qj.helper.WxLoginHelper;
import cn.seifly.module.wp.web.controller.h5qj.vo.PostListDTO;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.CommentVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.LoginVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.PostVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.Tags;
import cn.seifly.module.wp.web.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.seifly.common.core.pojo.CommonResult.success;

/**
 * 定义一个控制器类，处理与用户相关的请求
 * 包括登录、注册、获取用户信息等功能
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@RestController
@RequestMapping("/wp-json/jarpress/v1/")
@Tag(name = "用户相关接口")
public class MyUserController {
    @Autowired
    private WxMaService wxMaService;
    @Resource
    private PostsService postsService;
    @Resource
    private UserService userService;
    @Resource
    private PressIndexConfig pressIndexConfig;
    @Resource
    private PressBaseConfig pressBaseConfig;

    /**
     * 刷新用户JWT令牌
     * 从当前请求的JWT令牌中解析出用户ID，生成新的令牌并返回
     *
     * @return CommonResult  包含新生成的JWT令牌，操作结果状态及消息
     */
    @GetMapping("/refresh")
    public CommonResult<String> refreshToken() {
        String userId = JwtUtil.getUsernameFromToken(JwtUtil.getToken());
        String token = JwtUtil.generateToken(userId);
        return success(token);
    }

    //http://zhkyg6.natappfree.cc/wp-json/jarpress/v1/user/logintest?token=false&t=1742832297702&r=1802
    @GetMapping("/user/logintest")
    @Operation(summary = "测试登录")
    public CommonResult<List<PostVO>> logintest(@ParameterObject LoginVO reqVO) {
        Map<String, String> result = new HashMap<>();
        result.put("yhxy", "2034");
        result.put("ystk", "2035");
        return success(null);
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/user/login3?code=0b1AxYll2BvDff4nvCml2QOvQt3AxYlv&nickname=%E5%BE%AE%E4%BF%A1%E7%94%A8%E6%88%B7&avatar=&channel=weixin&token=false&t=1742735341128&r=8594&os=wx
    @GetMapping("/user/login3")
    @Operation(summary = "使用微信code登录")
    public CommonResult<Map<String, Object>> login3(@ParameterObject LoginVO reqVO) {
        WxLoginHelper wxLoginHelper = new WxLoginHelper(wxMaService);
        String openId = wxLoginHelper.xcxLogin(reqVO.getCode());
        UsersDTO usersDTO = userService.registByOpenId(openId, pressBaseConfig.getAvatar_url());
        String token = JwtUtil.generateToken(String.valueOf(usersDTO.getId()));
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("avatar", usersDTO.getUserUrl());
        map.put("nickname", usersDTO.getUserNicename());
        return success(map);
    }

    //http://2fwyyf.natappfree.cc/wp-json/jarpress/v1/user/like?post_id=12&token=false&t=1742818741977&r=4052
    @GetMapping("/user/like")
    @Operation(summary = "给帖子点赞")
    public CommonResult<Integer> addUserLike(PostVO baseVO) {
        String userId = LoginInterceptor.getLoginUserId();
        PostmetaDTO dto = new PostmetaDTO();
        dto.setPostId(baseVO.getPost_id());
        dto.setMetaKey(Constants.LIKES);
        dto.setMetaValue(userId);
        int result = postsService.postMetaInsert(dto);
        return success(result);
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/comment/add?post_id=3504&parent_id=0&content=234234&token=false&t=1742723645104&r=1751&os=wx
    @GetMapping("/comment/add")
    @Operation(summary = "给帖子评论")
    public CommonResult<Integer> addComment(CommentVO reqVO,HttpServletRequest request) {
        String userId = LoginInterceptor.getLoginUserId();
        PostsDTO postsDTO = postsService.selectById(reqVO.getPost_id());
        if (postsDTO == null) {
            return success(0);
        }
        if (postsDTO.getCommentCount() != null) {
            postsDTO.setCommentCount(postsDTO.getCommentCount() + 1);
        } else {
            postsDTO.setCommentCount(1l);
        }
        postsService.updateById(postsDTO);
        CommentsDTO dto = new CommentsDTO();
        dto.setUserId(Long.valueOf(userId));
        dto.setCommentPostId(reqVO.getPost_id());
        dto.setCommentContent(reqVO.getContent());
        dto.setCommentParent(reqVO.getParent_id());
        UsersDTO usersDTO = userService.getUserById(userId);
        dto.setCommentAuthor(usersDTO.getUserNicename());

        dto.setCommentAuthorIp(IpUtils.getIpAddr(request));
        dto.setCommentAgent(request.getHeader("User-Agent"));
        dto.setCommentDateGmt(LocalDateTime.now());
        dto.setCommentDate(LocalDateTime.now());
        int result = postsService.postCommentsInsert(dto);
        return success(result);
    }

    //http://7pzszc.natappfree.cc/wp-json/jarpress/v1/posts/my?offset=0&track=views&token=undefined&t=1742909508752&r=7811&os=wx
    @GetMapping("/posts/my")
    @Operation(summary = "获取我的点赞帖子")
    public CommonResult<List<PostListDTO>> getPostsMy(PostVO reqVO) {
        String userId = LoginInterceptor.getLoginUserId();
        PostsPageReqVO dto = new PostsPageReqVO();
        if (reqVO.getOffset() == null) {
            dto.setPageNo(1);
        } else {
            dto.setPageNo(reqVO.getOffset() / 10 + 1);
        }
        dto.setPageSize(10);
        String key = "";
        if ("views".equals(reqVO.getTrack())) {
            key = Constants.VIEWS;
        } else if ("likes".equals(reqVO.getTrack())) {
            key = Constants.LIKES;
        } else if ("favorites".equals(reqVO.getTrack())) {
            key = Constants.FAVORITES;
        }
        PageResult<PostsDTO> result = null;
        if ("comments".equals(reqVO.getTrack())) {
            result = postsService.selectPageMyCommon(dto, userId);
        } else {
            result = postsService.selectPageMy(dto, userId, key);
        }
        List<PostListDTO> list = getPostsDataList(result);
        return success(list);
    }

    private List<PostListDTO> getPostsDataList(PageResult<PostsDTO> pageResult) {
        List<PostListDTO> resutList = new ArrayList<>();
        if (pageResult == null || pageResult.getList() == null) {
            return resutList;
        }
        for (PostsDTO postsDTO : pageResult.getList()) {
            resutList.add(CoverDataHelper.getPostsData(postsDTO));
        }
        for (PostListDTO postsDTO : resutList) {
            PostsDTO postsDTO1 = postsService.setPostsDTO(postsDTO.getId());
            PostsDTO postsDTO2 = postsService.setTags(postsDTO.getId());
            CoverDataHelper.setPostsData(postsDTO, postsDTO1, postsDTO2);
        }
        return resutList;
    }

    @GetMapping("/user/favorite")
    @Operation(summary = "保存收藏帖子")
    public CommonResult<Integer> saveFavorite(PostVO reqVO) {
        String userId = LoginInterceptor.getLoginUserId();
        PostmetaDTO dto = new PostmetaDTO();
        dto.setPostId(reqVO.getPost_id());
        dto.setMetaKey(Constants.FAVORITES);
        dto.setMetaValue(userId);
        int result = postsService.postMetaInsert(dto);
        return success(result);
    }

    @GetMapping("/common/initCache")
    @Operation(summary = "重新加载缓存")
    public CommonResult<Integer> reInitCache() {
        PressInitService.reInit();
        return success(1);
    }
}
