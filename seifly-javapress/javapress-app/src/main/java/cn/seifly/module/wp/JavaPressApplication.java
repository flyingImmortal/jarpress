package cn.seifly.module.wp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 启动程序
 * 
 * @author www.seifly.cn
 */

@MapperScan({"cn.seifly.module.wp.dao.mysql.**"})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class },scanBasePackages = {"cn.seifly"})
@EnableWebMvc
public class JavaPressApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(JavaPressApplication.class, args);

    }
}
