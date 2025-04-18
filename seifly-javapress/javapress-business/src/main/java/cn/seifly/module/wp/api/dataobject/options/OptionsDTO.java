package cn.seifly.module.wp.api.dataobject.options;

import cn.seifly.common.core.domain.BaseDO;
import lombok.Data;

/**
 * 设置参数 DO
 *
 * @author www.seifly.cn 2025-04-18
 */

@Data
public class OptionsDTO extends BaseDO {

    /**
     * 参数id
     */
    
    private Long optionId;
    /**
     * 参数名
     */
    private String optionName;
    /**
     * 参数值
     */
    private String optionValue;
    /**
     * 是否自动加载
     */
    private String autoload;

}