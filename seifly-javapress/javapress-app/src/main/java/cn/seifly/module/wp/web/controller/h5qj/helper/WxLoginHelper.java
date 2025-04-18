package cn.seifly.module.wp.web.controller.h5qj.helper;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.seifly.common.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@RequiredArgsConstructor
public class WxLoginHelper {
    private final WxMaService wxMaService;

    public String xcxLogin(String code) {
        WxMaJscode2SessionResult sessionInfo = null;
        log.info("准备认证-====>");
        if (StringUtils.isEmpty(code)) {
            log.info("微信小程序授权失败：原因code：{}", code);
            throw new ServiceException("微信小程序授权失败");
        }
        //开始授权 获取openId 和 sessionKey
        try {
            sessionInfo = wxMaService.getUserService().getSessionInfo(code);
        } catch (Exception e) {
            log.info("微信小程序授权失败：原因：{}", e);
            throw new ServiceException("微信小程序授权失败");
        }
        log.info("获取openId-====>");
        if (sessionInfo == null || StringUtils.isEmpty(sessionInfo.getOpenid()) || StringUtils.isEmpty(sessionInfo.getSessionKey())) {
            throw new ServiceException("系统繁忙，请稍后重试!");
        }
        log.info("准备认证结束-====>");
        return sessionInfo.getOpenid();
    }

}
