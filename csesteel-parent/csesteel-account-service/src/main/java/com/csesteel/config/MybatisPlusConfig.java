package com.csesteel.config;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
@EnableTransactionManagement
@Configuration
@MapperScan("com.csesteel.presist.mapper")
public class MybatisPlusConfig {
	 /**
     * 分页插件
     */
    @Bean
    public PageInterceptor pageInterceptor() {    	
        return new PageInterceptor();
    }
    
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable","true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
