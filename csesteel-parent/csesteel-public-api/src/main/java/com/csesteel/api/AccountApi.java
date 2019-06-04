package com.csesteel.api;

import com.csesteel.common.request.RequestMessage;
import com.csesteel.common.response.ResponseMessage;
import com.csesteel.model.Emp;

public interface AccountApi {
public String hello(String hello);
public ResponseMessage queryEmp(Short empno);
public ResponseMessage queryEmps(RequestMessage requestMessage);
}
