package com.csesteel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.csesteel.api.AccountApi;
import com.csesteel.common.http.data.HttpData;
import com.csesteel.common.request.RequestMessage;
import com.csesteel.common.response.ResponseMessage;
import com.csesteel.model.Emp;
import com.github.pagehelper.PageInfo;

@Controller
public class EmpController {
	@Reference
	AccountApi accountApi;
@RequestMapping("/empPage")
public String empPage(ModelMap model) {
	return "list";
}
@RequestMapping("/emps")
@ResponseBody
public ResponseMessage emps(@RequestParam("pn")Integer pn) {
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("vo", new Emp());
	PageInfo page=new PageInfo();
	page.setPageNum(pn);
	page.setPageSize(2);
	jsonObject.put("page", page);
	RequestMessage requestMessage = HttpData.httpData(jsonObject);
	ResponseMessage queryEmps = this.accountApi.queryEmps(requestMessage);
	return queryEmps;
	
}
	@RequestMapping("/empList")
	@ResponseBody
public ResponseMessage empList(@RequestBody JSONObject jsonObject,PageInfo pageInfo){
	RequestMessage requestMessage = HttpData.httpData(jsonObject);
	ResponseMessage queryEmps = this.accountApi.queryEmps(requestMessage);
	return queryEmps;
}
}
