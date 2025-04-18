package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.termtaxonomy.ITermTaxonomyDAO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.dao.dataobject.terms.TermsDO;
import cn.seifly.module.wp.dao.dataobject.termtaxonomy.TermTaxonomyDO;
import cn.seifly.module.wp.dao.mysql.termtaxonomy.TermTaxonomyMapper;
import cn.seifly.module.wp.dto.comments.CommentsPageReqVO;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import cn.seifly.module.wp.dto.termtaxonomy.TermTaxonomyPageReqVO;
import cn.seifly.module.wp.api.dataobject.termtaxonomy.TermTaxonomyDTO;
import cn.seifly.framework.manager.BaseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 团队分类 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class TermTaxonomyDAOImpl implements ITermTaxonomyDAO {
    @Resource
    private TermTaxonomyMapper termTaxonomyMapper;
    @Override
    public  PageResult<TermTaxonomyDTO> selectPage(TermTaxonomyPageReqVO reqVO){
        PageResult<TermTaxonomyDO> result = termTaxonomyMapper.selectPage(reqVO);
        PageResult<TermTaxonomyDTO> pageResult = BeanUtil.toBean(result, TermTaxonomyDTO.class);
        return pageResult;
    }



}