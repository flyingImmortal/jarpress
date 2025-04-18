package cn.seifly.module.wp.dao;

import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.terms.ITermsDAO;
import cn.seifly.module.wp.api.dataobject.comments.CommentsDTO;
import cn.seifly.module.wp.dao.dataobject.terms.TermsDO;
import cn.seifly.module.wp.dao.mysql.terms.TermsMapper;
import cn.seifly.module.wp.dao.mysql.termtaxonomy.TermTaxonomyMapper;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.framework.manager.BaseDAO;
import cn.seifly.module.wp.dto.termtaxonomy.TermTaxonomyPageReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 分类 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class TermsDAOImpl implements ITermsDAO {
    @Resource
    private TermsMapper termsMapper;
    @Override
    public PageResult<TermsDTO> selectPage(TermsPageReqVO reqVO) {
        PageResult<TermsDO> result = termsMapper.selectPage(reqVO);
        PageResult<TermsDTO> pageResult = BeanUtil.toBean(result, TermsDTO.class);
        return pageResult;
    }

    @Override
    public TermsDTO selectById(Long termId) {
        TermsDO result = termsMapper.selectById(termId);
        return BeanUtil.toBean(result, TermsDTO.class);
    }
}