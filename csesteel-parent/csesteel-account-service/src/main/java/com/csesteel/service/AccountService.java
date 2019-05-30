package com.csesteel.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.csesteel.api.AccountApi;
import com.csesteel.model.Emp;
import com.csesteel.presist.mapper.EmpMapper;

@Service
public class AccountService implements AccountApi {
	@Autowired
 EmpMapper empMapper;
	@Override
	public String hello(String hello) {
		// TODO Auto-generated method stub
		return "hello "+hello;
	}

	@Override
	public Emp queryEmp(Short empno) {
		// TODO Auto-generated method stub
		return empMapper.selectByPrimaryKey(empno);
	}

}
