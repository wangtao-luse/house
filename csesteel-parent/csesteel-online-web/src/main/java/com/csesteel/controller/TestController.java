package com.csesteel.controller;

import com.alibaba.dubbo.config.annotation.Reference;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csesteel.api.AccountApi;
import com.csesteel.common.response.ResponseMessage;

@Controller
public class TestController {
	@Reference
AccountApi accountApi;
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(String name) {
		return accountApi.hello(name);
	}
@RequestMapping("/test")
@ResponseBody
public ResponseMessage test() {
	return ResponseMessage.getSuccess();
}
@RequestMapping("/emp")
@ResponseBody
public ResponseMessage empByempno(String empno) {
	Short short1 = new Short("7369");
	ResponseMessage queryEmp = this.accountApi.queryEmp(short1);
	return queryEmp;
}
@RequestMapping("/list")
public String list() {
	return "list";
}
@RequestMapping("/lists")
public String lists(ModelMap model,String id) {
	
	return "list";
}
}
