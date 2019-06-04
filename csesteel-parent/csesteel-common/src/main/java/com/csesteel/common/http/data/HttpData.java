package com.csesteel.common.http.data;

import com.alibaba.fastjson.JSONObject;
import com.csesteel.common.request.RequestBody;
import com.csesteel.common.request.RequestHeader;
import com.csesteel.common.request.RequestMessage;

public class HttpData {

public static RequestMessage httpData(JSONObject jsonObject) {
	RequestMessage requestMessage=new RequestMessage();
	RequestHeader requestHeader=new RequestHeader();
	RequestBody requestBody=new RequestBody();
	requestBody.setContent(jsonObject);
	requestMessage.setRequestBody(requestBody);
	requestMessage.setRequestHeader(requestHeader);
	return requestMessage;
}
}
