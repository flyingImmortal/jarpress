package cn.seifly.module.wp.service;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dao.options.IOptionsDAO;
import cn.seifly.module.wp.api.dao.terms.ITermsDAO;
import cn.seifly.module.wp.api.dao.termtaxonomy.ITermTaxonomyDAO;
import cn.seifly.module.wp.api.dao.users.IUsersDAO;
import cn.seifly.module.wp.api.dataobject.options.OptionsDTO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.module.wp.api.dataobject.users.UsersDTO;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import cn.seifly.module.wp.dto.options.OptionsPageReqVO;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import cn.seifly.module.wp.dto.termtaxonomy.TermTaxonomyPageReqVO;
import cn.seifly.module.wp.dto.users.UsersPageReqVO;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类信息初始化
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@Service
public class PressInitService {
    //分类名为key
    public static Map<String, Object> propertiesMap = new HashMap<>();
    public static Map<Long, TermTaxonomyDTO> termsIdMap = Maps.newLinkedHashMap();
    //分类ID为key
    public static Map<Long, TermTaxonomyDTO> termTaxonomyTerms = Maps.newHashMap();
    public static Map<Long, TermTaxonomyDTO> termTaxonomyIdTerms = Maps.newHashMap();
    //分类ID为key
    public static Map<Long, TermTaxonomyDTO> tagsIdMap = Maps.newLinkedHashMap();
    public static Map<String, UsersDTO> userMap = Maps.newHashMap();
    public static Map<Long, UsersDTO> userIdMap = Maps.newHashMap();
    @Resource
    private ITermsDAO termsDAO;
    @Resource
    private ITermTaxonomyDAO termTaxonomyDAO;
    @Resource
    private IUsersDAO usersDAO;
    @Autowired
    private IOptionsDAO optionsDAO;

    @PostConstruct
    public void init() {
        //缓存帖子类型
        TermsPageReqVO reqVO = new TermsPageReqVO();
        reqVO.setPageSize(CommentsPageReqVO.PAGE_SIZE_NONE);
        PageResult<TermsDTO> pageResult = termsDAO.selectPage(reqVO);

        TermTaxonomyPageReqVO reqVO1 = new TermTaxonomyPageReqVO();
        reqVO1.setPageSize(CommentsPageReqVO.PAGE_SIZE_NONE);
        PageResult<TermTaxonomyDTO> pageResult1 = termTaxonomyDAO.selectPage(reqVO1);
        for (TermTaxonomyDTO po : pageResult1.getList()) {
            termTaxonomyTerms.put(po.getTermId(), po);
            termTaxonomyIdTerms.put(po.getTermTaxonomyId(), po);
        }
        for (TermsDTO po : pageResult.getList()) {
            TermTaxonomyDTO termTaxonomyDTO = termTaxonomyTerms.get(po.getTermId());
            if (null == termTaxonomyDTO) {
                continue;
            }
            if ("category".equals(termTaxonomyDTO.getTaxonomy())) {
                termTaxonomyDTO.setName(po.getName());
                termTaxonomyDTO.setSlug(po.getSlug());
                termTaxonomyDTO.setTermGroup(po.getTermGroup());
                termsIdMap.put(po.getTermId(), termTaxonomyDTO);
            } else if ("post_tag".equals(termTaxonomyDTO.getTaxonomy())) {
                termTaxonomyDTO.setName(po.getName());
                termTaxonomyDTO.setSlug(po.getSlug());
                termTaxonomyDTO.setTermGroup(po.getTermGroup());
                tagsIdMap.put(po.getTermId(), termTaxonomyDTO);
            }
        }
        termTaxonomyTerms.clear();
        UsersPageReqVO reqVO2 = new UsersPageReqVO();
        List<UsersDTO> list = usersDAO.selectPage(reqVO2).getList();
        for (UsersDTO user : list) {
            UsersDTO userDto = new UsersDTO();
            //PropertiesHelper.setProperty(Constants.USER_KEY + user.getId(), user.getUserNicename());
            //PropertiesHelper.setProperty(Constants.USER_OBJECT + user.getId(), userDto);
            userMap.put(user.getId().toString(), user);
            userIdMap.put(user.getId(), user);
        }
        //缓存tags
        OptionsPageReqVO dto = new OptionsPageReqVO();
        List<OptionsDTO> list1 = optionsDAO.selectPage(dto).getList();
        for (OptionsDTO opt : list1) {
            propertiesMap.put(opt.getOptionName(), opt.getOptionValue());
        }
    }

    public static void reInit() {
        termTaxonomyTerms.clear();
        tagsIdMap.clear();
        termsIdMap.clear();
        new PressInitService().init();
    }
}