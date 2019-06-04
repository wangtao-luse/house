package com.csesteel;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
//@ImportResource(locations = { /* "dubbo-provider.xml", */"mybatis/mybatis-config.xml"})
@EnableDubbo
//利用反射将该包下的类放入spring容器
@MapperScan("com.csesteel.presist.mapper")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
