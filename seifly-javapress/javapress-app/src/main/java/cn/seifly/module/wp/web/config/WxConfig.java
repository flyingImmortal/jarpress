package cn.seifly.module.wp.web.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "wx.miniapp")
@Component
@Configuration
public class WxConfig {
    private String appId;//
    private String secret;//
    private String token;//: #微信小程序消息服务器配置的token
    private String aesKey;//: #微信小程序消息服务器配置的EncodingAESKey
    private String msgDataFormat;//: JSON
    @Bean
    public WxMaService wxMaService() {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid(appId);
        config.setSecret(secret);

        WxMaServiceImpl service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }
}
