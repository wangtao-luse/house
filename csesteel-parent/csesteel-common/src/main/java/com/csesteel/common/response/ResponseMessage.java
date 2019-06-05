package com.csesteel.common.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.csesteel.common.constant.Constant;

public class ResponseMessage implements Serializable  {

	private static final long serialVersionUID = 1L;
	private String resultcode; //返回码
    private String description; //返回描述
    private Map<String,Object> returnResult; //返回结果
    
	public ResponseMessage() {}
     
	public ResponseMessage(String resultcode, String description) {
		super();
		this.resultcode = resultcode;
		this.description = description;
	}
	public ResponseMessage(String resultcode, String description, Map<String, Object> returnResult) {
		super();
		this.resultcode = resultcode;
		this.description = description;
		this.returnResult = returnResult;
	}

	

	public String getResultcode() {
		return resultcode;
	}
	public String getDescription() {
		return description;
	}
	public Map<String, Object> getReturnResult() {
		return returnResult;
	}
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setReturnResult(Map<String, Object> returnResult) {
		this.returnResult = returnResult;
	}
	public void setReturnResult(String key,Object object) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(key, object);
		this.returnResult = result;
	}
	public void setReturnResult(Object object) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", object);
		this.returnResult = result;
	}
   public static ResponseMessage getSuccess(){	   
	  return new ResponseMessage(Constant.SUCCESS, Constant.SUCCESS_DESCRIPTION);
   }
   public  static ResponseMessage getSuccess(Object value){
	   Map<String, Object> result = new HashMap<String, Object>();
	   result.put("result", value);
	   return new ResponseMessage(Constant.SUCCESS, Constant.SUCCESS_DESCRIPTION,result);
   }
   public static ResponseMessage getSuccess(String key,Object value){
	   Map<String, Object> result = new HashMap<String, Object>();
	   result.put(key, value);
	   return new ResponseMessage(Constant.SUCCESS, Constant.SUCCESS_DESCRIPTION,result);
   }
   
   public static ResponseMessage getFailed(){	 
	   return new ResponseMessage(Constant.FAILED, Constant.FAILED_SYSTEM_ERROR);
   }
   public static ResponseMessage getFailed(Object value){
	   Map<String, Object> result = new HashMap<String, Object>();
	   result.put("result", value);
	   return new ResponseMessage(Constant.FAILED, Constant.FAILED_SYSTEM_ERROR,result);
   }
   public static ResponseMessage getFailed(String key,Object value){
	   Map<String, Object> result = new HashMap<String, Object>();
	   result.put(key, value);
	   return new ResponseMessage(Constant.FAILED, Constant.FAILED_SYSTEM_ERROR,result);
   }
   public ResponseMessage add(String key,Object value){
	   this.returnResult.put(key, value);
	   return this;
   }
   public ResponseMessage add(Object value){
	   this.returnResult.put("data", value);
	   return this;
   }

@Override
public String toString() {
	return "ResponseMessage [resultcode=" + resultcode + ", description=" + description + ", returnResult="
			+ returnResult + "]";
}
}
