package cn.seifly.module.wp.dao.dataobject.options;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.seifly.common.core.domain.BaseDO;
import lombok.*;

/**
 * 设置参数 DO
 *
 * @author www.seifly.cn 2025-04-18
 */
@TableName("wp_options")
@KeySequence("wp_options_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionsDO extends BaseDO {

    /**
     * 参数id
     */
    @TableId
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