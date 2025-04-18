package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.module.wp.api.dao.links.ILinksDAO;
import cn.seifly.module.wp.api.dataobject.links.LinksDTO;
import cn.seifly.module.wp.dao.mysql.links.LinksMapper;
import cn.seifly.module.wp.dto.links.LinksPageReqVO;
import cn.seifly.framework.manager.BaseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 链接 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class LinksDAOImpl implements ILinksDAO {
    @Resource
    private LinksMapper linksMapper;
    @Override
    public  PageResult<LinksDTO> selectPage(LinksPageReqVO reqVO){
        return null;
    }

}