package cn.seifly.module.wp.web.controller.h5qj;

import cn.seifly.common.core.pojo.CommonResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dataobject.posts.PostsDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.module.wp.service.PostsService;
import cn.seifly.module.wp.service.PressInitService;
import cn.seifly.module.wp.web.config.PressBaseConfig;
import cn.seifly.module.wp.web.config.PressIndexConfig;
import cn.seifly.module.wp.web.config.PressMyConfig;
import cn.seifly.module.wp.web.controller.h5qj.vo.req.BaseVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.setting.HomeVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.setting.HotVO;
import cn.seifly.module.wp.web.controller.h5qj.vo.resp.setting.TopNavVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.seifly.common.core.pojo.CommonResult.success;

/**
 * 设置控制器，用于处理与设置相关的HTTP请求
 * 该控制器是RESTful风格的一部分，所有请求都返回JSON格式的数据
 * 主要涉及软件的设置相关功能，比如用户偏好设置、系统配置等
 * 该控制器提供了一些用于获取配置信息的方法，如查询首页配置、查询热门配置、查询登录配置等
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@RestController
@RequestMapping("/wp-json/jarpress/v1/")
@Tag(name = "设置相关接口") // 接口分组
public class SettingController {
    @Resource
    private PressBaseConfig pressBaseConfig;
    @Resource
    private PressIndexConfig pressIndexConfig;
    @Resource
    private PressMyConfig pressMyConfig;
    @Resource
    private PostsService postsService;


    //https://xcx.seifly.cn/wp-json/jarpress/v1/setting/home?token=false&t=1742657838214&r=3475&os=wx
    @GetMapping("/setting/home")
    @Operation(summary = "查询配置")
    public CommonResult<HomeVO> getSetting(@ParameterObject BaseVO baseVO) {
        HomeVO homeVO = BeanUtil.toBean(pressBaseConfig, HomeVO.class);
        homeVO.setActives(pressIndexConfig.getActives());
        homeVO.setHome_slide(pressIndexConfig.getHome_slide());
        List<HotVO> hotList = new ArrayList<>();
        List<TopNavVO> topNavList = new ArrayList<>();
        homeVO.setHot(hotList);
        homeVO.setIcon_nav(pressIndexConfig.getIcon_nav());
        homeVO.setTop_nav(topNavList);
        List<PostsDTO> hotPosts = postsService.getByIds(pressIndexConfig.getHot());
        for (PostsDTO dto : hotPosts) {
            HotVO hotVO = new HotVO();
            hotVO.setId(dto.getId());
            if (dto.getThumbnail() == null) {
                hotVO.setThumbnail(pressIndexConfig.getHot_default_img());
            } else {
                hotVO.setThumbnail(dto.getThumbnail());
            }
            hotVO.setTitle(dto.getPostTitle());
            hotList.add(hotVO);
        }
        for (Long id : pressIndexConfig.getTop_nav()) {
            TopNavVO topNavVO = new TopNavVO();
            TermTaxonomyDTO termTaxonomyDTO = PressInitService.termsIdMap.get(id);
            if (termTaxonomyDTO != null) {
                topNavVO.setId(termTaxonomyDTO.getTermId());
                topNavVO.setName(termTaxonomyDTO.getName());
                topNavList.add(topNavVO);
            }
        }
        return success(homeVO);
    }

    //http://xcx.seifly.cn/wp-json/jarpress/v1/setting/category?token=false&t=1742739842852&r=8931
    @GetMapping("/setting/category")
    @Operation(summary = "查询配置")
    public CommonResult<PressMyConfig.Category> getSettingCategory(@ParameterObject BaseVO baseVO) {
        return success(pressMyConfig.getCategory());
    }

    //http://xcx.seifly.cn/wp-json/jarpress/v1/setting/hot?token=false&t=1742818985950&r=678
    @GetMapping("/setting/hot")
    @Operation(summary = "查询配置")
    public CommonResult<PressMyConfig.Hot> getSettingHot(BaseVO baseVO) {
        return success(pressMyConfig.getHot());
    }

    //https://xcx.seifly.cn/wp-json/jarpress/v1/setting/login?token=false&t=1742723648719&r=9087&os=wx
    @GetMapping("/setting/login")
    @Operation(summary = "获取登录配置")
    public CommonResult<PressMyConfig.Login> getSettingLogin(BaseVO baseVO) {
        return success(pressMyConfig.getLogin());
    }

    //http://xcx.seifly.cn/wp-json/jarpress/v1/setting/ucenter?token=false&t=1742820263466&r=2177
    @GetMapping("/setting/ucenter")
    @Operation(summary = "查询我的界面菜单")
    public CommonResult<Map<String, Object>> getSettingUcenter(@ParameterObject BaseVO baseVO) {
        Map<String, Object> map = new HashMap<>();
        map.put("background", pressMyConfig.getUcenter().getBackground());
        map.put("beian_icp", pressMyConfig.getUcenter().getBeian_icp());
        map.put("menu", pressMyConfig.getMenu());
        return success(map);
    }

    //http://xcx.seifly.cn/wp-json/jarpress/v1/category/cover?cat_id=undefined&token=false&t=1742740882422&r=5537
    @GetMapping("/category/cover")
    @Operation(summary = "查询类型配置")
    public CommonResult<Map<String, Object>> getCategoryCover(@ParameterObject BaseVO baseVO) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cover", pressMyConfig.getCategory().getCover());
        return success(resultMap);
    }
}
