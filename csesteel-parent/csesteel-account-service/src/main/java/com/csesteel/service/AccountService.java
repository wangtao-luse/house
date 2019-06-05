package com.csesteel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csesteel.api.AccountApi;
import com.csesteel.common.request.RequestMessage;
import com.csesteel.common.response.ResponseMessage;
import com.csesteel.model.Emp;
import com.csesteel.presist.mapper.EmpMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AccountService  extends ServiceImpl<EmpMapper, Emp>implements AccountApi {
	@Autowired
 EmpMapper empMapper;
	@Override
	public String hello(String hello) {
		// TODO Auto-generated method stub
	
		return "hello "+hello;
	}

	@Override
	public ResponseMessage queryEmp(Short empno) {
		// TODO Auto-generated method stub
		ResponseMessage responseMessage = ResponseMessage.getSuccess();
		
		
		return responseMessage;
	}

	@Override
	public ResponseMessage queryEmps(RequestMessage requestMessage) {
		// TODO Auto-generated method stub
		ResponseMessage responseMessage = ResponseMessage.getSuccess();
		try {			
			JSONObject jsonObject = requestMessage.getRequestBody().getContent();
			Emp emp = jsonObject.getJSONObject("vo").toJavaObject(Emp.class); 
			PageInfo page = jsonObject.getJSONObject("page").toJavaObject(PageInfo.class); 						
			if(page!=null) {//分页查询
			PageHelper.offsetPage(page.getPageNum(), page.getPageSize());
			PageInfo<Emp> pageInfo=new PageInfo<Emp>(this.empMapper.selectEmpWidthDept(emp));		
			 responseMessage.setReturnResult(pageInfo);
			}else {
			List<Emp> selectEmpWidthDept = this.empMapper.selectEmpWidthDept(emp);
			 responseMessage.setReturnResult(selectEmpWidthDept);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return responseMessage;
	}

}
