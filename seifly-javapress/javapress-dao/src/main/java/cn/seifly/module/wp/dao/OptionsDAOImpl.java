package cn.seifly.module.wp.dao;

import cn.seifly.common.core.page.PageResult;
import cn.seifly.common.utils.bean.BeanUtil;
import cn.seifly.module.wp.api.dao.options.IOptionsDAO;
import cn.seifly.module.wp.api.dataobject.options.OptionsDTO;
import cn.seifly.module.wp.dao.dataobject.options.OptionsDO;
import cn.seifly.module.wp.dao.mysql.options.OptionsMapper;
import cn.seifly.module.wp.dto.options.OptionsPageReqVO;
import cn.seifly.framework.manager.BaseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 设置参数 Mapper
 *
 * @author www.seifly.cn 2025-04-18
 */
@Service
public class OptionsDAOImpl implements IOptionsDAO {
     @Resource
     private OptionsMapper optionsMapper;
     @Override
     public  PageResult<OptionsDTO> selectPage(OptionsPageReqVO reqVO)  {
          PageResult<OptionsDO> pageResult = optionsMapper.selectPage(reqVO);
          PageResult<OptionsDTO> result = BeanUtil.toBean(pageResult, OptionsDTO.class);
          return result;
     }


}