package cn.seifly.common.core.controller;

import cn.seifly.common.constant.HttpStatus;
import cn.seifly.common.core.pojo.ResultDTO;
import cn.seifly.common.core.page.PageDomain;
import cn.seifly.common.core.page.TableDataInfo;
import cn.seifly.common.core.page.TableSupport;
import cn.seifly.common.utils.DateUtils;
import cn.seifly.common.utils.StringUtils;
import cn.seifly.common.utils.sql.SqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * web层通用数据处理
 * 
 * @author 
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }


    /**
     * 设置请求排序数据
     */
    protected void startOrderBy()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy()))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            //PageHelper.orderBy(orderBy);
        }
    }


    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        //rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 返回成功
     */
    public ResultDTO success()
    {
        return ResultDTO.success();
    }

    /**
     * 返回失败消息
     */
    public ResultDTO error()
    {
        return ResultDTO.error();
    }

    /**
     * 返回成功消息
     */
    public ResultDTO success(String message)
    {
        return ResultDTO.success(message);
    }
    
    /**
     * 返回成功消息
     */
    public ResultDTO success(Object data)
    {
        return ResultDTO.success(data);
    }

    /**
     * 返回失败消息
     */
    public ResultDTO error(String message)
    {
        return ResultDTO.error(message);
    }

    /**
     * 返回警告消息
     */
    public ResultDTO warn(String message)
    {
        return ResultDTO.warn(message);
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ResultDTO toAjax(int rows)
    {
        return rows > 0 ? ResultDTO.success() : ResultDTO.error();
    }

    /**
     * 响应返回结果
     * 
     * @param result 结果
     * @return 操作结果
     */
    protected ResultDTO toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

}
