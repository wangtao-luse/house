package com.csesteel.common.request;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class RequestBody implements Serializable{
private JSONObject content;//客户端传入的数据
	//用户信息
	//....

public JSONObject getContent() {
	return content;
}

public void setContent(JSONObject content) {
	this.content = content;
}
}
