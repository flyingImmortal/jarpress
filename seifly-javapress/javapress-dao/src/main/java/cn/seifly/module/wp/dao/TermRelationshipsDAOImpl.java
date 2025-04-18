package cn.seifly.module.wp.dao;

import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.termrelationships.ITermRelationshipsDAO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.dao.dataobject.termrelationships.TermRelationshipsDO;
import cn.seifly.module.wp.dao.dataobject.terms.TermsDO;
import cn.seifly.module.wp.dao.mysql.termrelationships.TermRelationshipsMapper;
import cn.seifly.module.wp.dto.termrelationships.TermRelationshipsPageReqVO;
import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dataobject.termrelationships.TermRelationshipsDTO;
import cn.seifly.framework.manager.BaseDAO;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 团队分类关系 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class TermRelationshipsDAOImpl implements ITermRelationshipsDAO {
    @Resource
    private TermRelationshipsMapper termRelationshipsMapper;

    @Override
    public PageResult<TermRelationshipsDTO> selectPage(TermRelationshipsPageReqVO reqVO) {
        PageResult<TermRelationshipsDO> result = termRelationshipsMapper.selectPage(reqVO);
        PageResult<TermRelationshipsDTO> pageResult = BeanUtil.toBean(result, TermRelationshipsDTO.class);
        return pageResult;
    }

}