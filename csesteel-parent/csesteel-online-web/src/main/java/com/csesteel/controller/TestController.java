package com.csesteel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csesteel.api.AccountApi;
import com.csesteel.common.response.ResponseMessage;
import com.csesteel.model.Emp;

@Controller
public class TestController {
	@Autowired
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
public String empByempno(String empno) {
	Short short1 = new Short(empno);
	Emp queryEmp = this.accountApi.queryEmp(short1);
	return null;
}
}
