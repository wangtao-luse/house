package com.csesteel;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource(locations = {"dubbo-customer.xml"})
@EnableDubbo
//https://blog.csdn.net/qq_27046951/article/details/82850394
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class App {
public static void main(String[] args) {
	SpringApplication.run(App.class, args);
}
}
