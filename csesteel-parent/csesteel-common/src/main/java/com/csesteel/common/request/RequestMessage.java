package com.csesteel.common.request;

import java.io.Serializable;

public class RequestMessage implements Serializable {
private RequestHeader requestHeader;
private RequestBody requestBody;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }
    
}
