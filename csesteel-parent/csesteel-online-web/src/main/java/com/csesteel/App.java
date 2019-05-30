package com.csesteel;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"dubbo-customer.xml"})
@EnableDubbo
public class App {
public static void main(String[] args) {
	SpringApplication.run(App.class, args);
}
}
