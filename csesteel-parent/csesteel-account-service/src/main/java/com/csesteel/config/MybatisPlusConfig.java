package com.csesteel.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInterceptor;

@Configuration
public class MybatisPlusConfig {

	
	  @Bean 
	  public PageInterceptor pageInterceptor(){ 
		  PageInterceptor  pageInterceptor = new PageInterceptor(); 
		  Properties properties = new   Properties(); 
		  properties.setProperty("reasonable","true");
	    pageInterceptor.setProperties(properties); 
	    return pageInterceptor; 
	  }
	  
	 

}
