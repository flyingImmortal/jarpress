package cn.seifly.module.wp.web.controller.h5qj;

import cn.hutool.core.collection.CollectionUtil;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.core.pojo.CommonResult;
import cn.seifly.module.wp.api.dataobject.postmeta.PostmetaDTO;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.module.wp.comm.Constants;
import cn.seifly.module.wp.dto.posts.PostsPageReqVO;
import cn.seifly.module.wp.dto.termrelationships.TermRelationshipsPageReqVO;
import cn.seifly.module.wp.service.PostsService;
import cn.seifly.module.wp.service.TermRelationshipsService;
import cn.seifly.module.wp.service.PressInitService;
import cn.seifly.module.wp.web.config.LoginInterceptor;
import cn.seifly.module.wp.web.config.PressBaseConfig;
import cn.seifly.module.wp.web.config.PressIndexConfig;
import cn.seifly.module.wp.web.controller.h5qj.helper.CoverDataHelper;
import cn.seifly.module.wp.web.controller.h5qj.vo.PostListDTO;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.BaseVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.PostVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.SearchCategoryVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.PostDetailDTO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.Tags;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static cn.seifly.common.core.pojo.CommonResult.success;

/**
 * 定义一个控制器类，处理与小程序首页相关的请求
 * 提供了查询帖子类型列表、查询最新帖子、根据类型查询帖子、查询你的小程序图片地址和查询帖子详情等接口。
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@RestController
@RequestMapping("/wp-json/jarpress/v1/")
@Tag(name = "小程序首页") // 接口分组
public class PostController {

    @Resource
    private PostsService postsService;
    @Resource
    private TermRelationshipsService termRelationshipsService;
    @Resource
    private PressIndexConfig pressIndexConfig;
    @Autowired
    private PressBaseConfig pressBaseConfig;

    // https://xcx.seifly.cn/wp-json/jarpress/v1/category/index?token=false&t=1742740035371&r=8648&os=wx
    @GetMapping("/category/index")
    @Operation(summary = "查询帖子类型列表")
    public CommonResult<List<TermsDTO>> getCategoryIndex(@ParameterObject BaseVO baseVO) {
        List<TermsDTO> list = new ArrayList<>();
        int i = 0;
        List<String> category_default_img = pressIndexConfig.getCategory_default_img();
        for (Long id : pressIndexConfig.getTop_nav()) {
            TermTaxonomyDTO termTaxonomyDTO = PressInitService.termsIdMap.get(id);
            TermsDTO termsDTO = new TermsDTO();
            termsDTO.setId(termTaxonomyDTO.getTermId());
            termsDTO.setName(termTaxonomyDTO.getName());
            termsDTO.setCover(category_default_img.get(i));
            list.add(termsDTO);
            i++;
        }
//        for (Map.Entry<Long, TermTaxonomyDTO> entity : PressInitService.termsIdMap.entrySet()) {
//            TermTaxonomyDTO termTaxonomyDTO = entity.getValue();
//            TermsDTO termsDTO = new TermsDTO();
//            termsDTO.setId(termTaxonomyDTO.getTermId());
//            termsDTO.setName(termTaxonomyDTO.getName());
//            termsDTO.setCover(category_default_img.get(i));
//            list.add(termsDTO);
//            i++;
//        }
        return success(list);
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/posts/last?offset=0&token=false&t=1742657838302&r=431&os=wx
    //offset=11
    @GetMapping("/posts/last")
    @Operation(summary = "查询最新帖子")
    public CommonResult<List<PostListDTO>> getPostsLast(@ParameterObject PostVO baseVO) {
        PostsPageReqVO dto = new PostsPageReqVO();
        if (baseVO.getOffset() == null) {
            dto.setPageNo(1);
        } else {
            dto.setPageNo(baseVO.getOffset() / 10 + 1);
        }
        dto.setPageSize(10);
        PageResult<PostsDTO> result = postsService.selectPage(dto);
        List<PostListDTO> list = getPostsDataList(result);
        return success(list);
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/posts/category?offset=0&cat_id=23&token=false&t=1742657892918&r=261&os=wx
    @GetMapping("/posts/category")
    @Operation(summary = "根据类型查询帖子")
    public CommonResult<List<PostListDTO>> getPostsCategory(@ParameterObject SearchCategoryVO reqVO) {
        TermRelationshipsPageReqVO dto = new TermRelationshipsPageReqVO();
        if (reqVO.getOffset() == null) {
            dto.setPageNo(1);
        } else {
            dto.setPageNo(reqVO.getOffset() / 10 + 1);
        }
        dto.setPageSize(10);
        dto.setTermTaxonomyId(reqVO.getCat_id());
        List<Long> postIds = termRelationshipsService.selectPageIds(dto);
        if (postIds.isEmpty()) {
            return success(new ArrayList<>());
        }
        PostsPageReqVO dto1 = new PostsPageReqVO();
        dto1.setIdList(postIds);
        PageResult<PostsDTO> result = postsService.selectPage(dto1);
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
            if (StringUtils.hasText(postsDTO1.getThumbnail())) {
                String imgUrl = postsDTO1.getThumbnail();
                imgUrl = imgUrl.substring(imgUrl.indexOf("/wp-content/"), imgUrl.length());
                postsDTO.setThumbnail(pressBaseConfig.getWordpress_url() + imgUrl);
            } else {
                postsDTO.setThumbnail(pressBaseConfig.getPost_default_url());
            }
        }
        return resutList;
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/posts/wxacode?post_id=3504&token=false&t=1742660095904&r=6310&os=wx
    @GetMapping("/posts/wxacode")
    @Operation(summary = "查询你的小程序图片地址")
    public CommonResult<String> getPostsWxacode(@ParameterObject PostVO baseVO) {
        return success("www.seifly.cn/jarpress/img/8.jpg");
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/posts/detail?post_id=3504&token=false&t=1742660095909&r=1216&os=wx
    @GetMapping("/posts/detail")
    @Operation(summary = "查询帖子详情")
    public CommonResult<PostDetailDTO> getPostsDetail(@ParameterObject PostVO baseVO) {
        String userId = LoginInterceptor.getLoginUserId();
        PostsDTO result = postsService.selectById(baseVO.getPost_id());
        PostDetailDTO dto = CoverDataHelper.getPostDetailDTO(result);
        if (dto != null) {
            PostmetaDTO postmetaDTO = new PostmetaDTO();
            postmetaDTO.setPostId(dto.getId());
            postmetaDTO.setMetaKey(Constants.VIEWS);
            postmetaDTO.setMetaValue(userId);
            postsService.postMetaInsert(postmetaDTO);
        }
        return success(dto);
    }


    //https://xcx.seifly.cn/wp-json/jarpress/v1/posts/search/hot?token=false&t=1742722425717&r=3265&os=wx
    @GetMapping("/posts/search/hot")
    @Operation(summary = "查询关键字列表")
    public CommonResult<List<String>> getPostsSearchHot(@ParameterObject BaseVO reqVO) {
        List<String> list = new ArrayList<>();
        list.add("wordpress");
        list.add("好");
        return success(list);
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/posts/search?offset=0&search=%E5%A5%BD&token=false&t=1742722452080&r=7150&os=wx
    @GetMapping("/posts/search")
    @Operation(summary = "根据关键字查询帖子")
    public CommonResult<List<PostListDTO>> getPostsSearch(@ParameterObject SearchCategoryVO reqVO) {
        PostsPageReqVO dto = new PostsPageReqVO();
        if (reqVO.getOffset() == null) {
            dto.setPageNo(1);
        } else {
            dto.setPageNo(reqVO.getOffset() / 10 + 1);
        }
        dto.setPageSize(10);
        dto.setPostName(reqVO.getSearch());
        PageResult<PostsDTO> result = postsService.selectPage(dto);
        List<PostListDTO> list = getPostsDataList(result);
        return success(list);
    }

    //http://xcx.seifly.cn/wp-json/jarpress/v1/posts/bdacode?post_id=9&token=false&t=1742738879220&r=7964
    @GetMapping("/posts/bdacode")
    @Operation(summary = "查询帖子详情")
    public CommonResult<PostDetailDTO> getPostsBdacode(@ParameterObject PostVO baseVO) {
        PostsDTO result = postsService.selectById(baseVO.getPost_id());
        PostDetailDTO dto = CoverDataHelper.getPostDetailDTO(result);
        return success(dto);
    }

    // http://2fwyyf.natappfree.cc/wp-json/jarpress/v1/posts/hot?offset=0&sort=views&token=false&t=1742818985952&r=6186
    //sort=likes、views、favorites、comments
    @GetMapping("/posts/hot")
    @Operation(summary = "查询热门帖子")
    public CommonResult<List<PostListDTO>> getPostsHot(@ParameterObject PostVO reqVO) {
        PostsPageReqVO dto = new PostsPageReqVO();
        if (reqVO.getOffset() == null) {
            dto.setPageNo(1);
        } else {
            dto.setPageNo(reqVO.getOffset() / 10 + 1);
        }
        dto.setPageSize(10);
        dto.setSort(reqVO.getSort());
        PageResult<PostsDTO> result = postsService.selectPage(dto);
        List<PostListDTO> list = getPostsDataList(result);
        return success(list);
    }

    //http://zhkyg6.natappfree.cc/wp-json/jarpress/v1/posts/page?page_id=1192&token=false&t=1742828439621&r=6011
    @GetMapping("/posts/page")
    @Operation(summary = "查询帖子详情")
    public CommonResult<PostDetailDTO> getPostsPage(@ParameterObject PostVO reqVO) {
        PostsDTO result = postsService.selectById(reqVO.getPage_id());
        PostDetailDTO dto = CoverDataHelper.getPostDetailDTO(result);
        return success(dto);
    }
}
