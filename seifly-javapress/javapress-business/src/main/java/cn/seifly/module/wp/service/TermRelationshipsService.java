package cn.seifly.module.wp.service;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dao.termrelationships.ITermRelationshipsDAO;
import cn.seifly.module.wp.api.dataobject.termrelationships.TermRelationshipsDTO;
import cn.seifly.module.wp.api.dataobject.terms.TermsDTO;
import cn.seifly.module.wp.dto.termrelationships.TermRelationshipsPageReqVO;
import cn.seifly.module.wp.dto.terms.TermsPageReqVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类与帖子关联表 服务实现类
 *
 * @author www.seifly.cn
 * @date 2025/04/16
 */
@Service
public class TermRelationshipsService {
    @Resource
    private ITermRelationshipsDAO termRelationshipsDAO;

    public PageResult<TermRelationshipsDTO> selectPage(TermRelationshipsPageReqVO reqVO) {
        PageResult<TermRelationshipsDTO> postsDTOList = termRelationshipsDAO.selectPage(reqVO);
        return postsDTOList;
    }

    public List<Long> selectPageIds(TermRelationshipsPageReqVO reqVO) {
        List<Long> resultList = new ArrayList<>();
        PageResult<TermRelationshipsDTO> postsDTOList = selectPage(reqVO);
        List<TermRelationshipsDTO> list = postsDTOList.getList();
        for (TermRelationshipsDTO dto : list) {
            resultList.add(dto.getObjectId());
        }
        return resultList;
    }
}
