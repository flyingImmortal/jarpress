package cn.seifly.module.wp.web.config;

import cn.seifly.common.exception.ServiceException;
import cn.seifly.module.wp.web.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器，用于拦截HTTP请求并处理登录验证。
 * 实现HandlerInterceptor接口，提供请求预处理、后处理及异常处理功能。
 *
 * @author www.seifly.cn
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 存储当前线程的用户身份信息，供请求处理过程中各层访问
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getLoginUserId() {
        String userId = threadLocal.get();
        if (userId == null) {
            try {
                String token = JwtUtil.getToken();
                if (StringUtils.isNotBlank(token)) {
                    userId = JwtUtil.getUsernameFromToken(token);
                }
            } catch (Exception e) {

            }
        }
        return userId;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token
        String token = JwtUtil.getToken();
        //判断token是否存在
        if (StringUtils.isBlank(token) || "false".equals(token)) {
            //不存在返回401
            log.info("token不能为空");
            response.setStatus(200);
            throw new ServiceException("还没有登陆", -1);
            //return false;
        }
        if (!JwtUtil.validateToken(token)) {
            log.info("token过期");
            response.setStatus(200);
            throw new ServiceException("登录已过期，请重新登录", -1);
        }
        //存在就进行解析jwt
        try {
            String userId = JwtUtil.getUsernameFromToken(token);
            threadLocal.set(userId);
        } catch (Exception e) {
            log.info("token解析异常", e);
            response.setStatus(200);
            throw new ServiceException("请重新登录", -1);
        }
        return true;
    }


}
