package com.csesteel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@ImportResource(locations = {"dubbo-provider.xml","mybatis/mybatis-config.xml"})
@EnableDubbo
//@MapperScan("com.csesteel.presist.mapper")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
