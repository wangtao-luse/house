package com.csesteel.controller;

import com.csesteel.common.response.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class testController {
    @RequestMapping("/test")
    @ResponseBody
    public ResponseMessage test() {
        return ResponseMessage.getSuccess();
    }
}
