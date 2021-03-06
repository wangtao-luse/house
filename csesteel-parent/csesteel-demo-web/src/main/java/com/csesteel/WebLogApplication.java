package com.csesteel;


import com.alibaba.fastjson.JSONObject;
import com.csesteel.common.request.RequestBody;
import com.csesteel.common.request.RequestHeader;
import com.csesteel.common.request.RequestMessage;
import com.csesteel.common.response.ResponseMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Aspect
@Component
public class WebLogApplication {
    private static Logger logger = (Logger) LoggerFactory.getLogger(WebLogApplication.class);
    ThreadLocal<Long> time=new ThreadLocal<>();
    @Pointcut("execution(public * com.csesteel.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        String string = joinPoint.toString();
        Object[] args = joinPoint.getArgs();
        final Object target = joinPoint.getTarget();
        System.out.println("########前置通知########");
        long startTime = System.currentTimeMillis();
        time.set(startTime);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequestMessage requestMessage = new RequestMessage();
        RequestHeader requestHeader = new RequestHeader();
        RequestBody requestbody = new RequestBody();
        //url
        requestHeader.setRequestURI(request.getRequestURI());//返回除去host（域名或者ip）部分的路径
        requestHeader.setRequestURL(request.getRequestURL());//返回全路径
        requestHeader.setContextPath(request.getContextPath());//返回工程名部分，如果工程映射为/，此处返回则为空
        requestHeader.setServletPath(request.getServletPath());////返回除去host和工程名部分的路径

        //addr
        requestHeader.setRemoteAddr(request.getRemoteAddr());//获得客户端的ip地址
        requestHeader.setLocalAddr(request.getLocalAddr());////获取服务器的IP地址
        requestHeader.setServerName(request.getServerName());//当前页面所在的服务器的名字
        requestHeader.setServerPort(request.getServerPort());
        requestHeader.setScheme(request.getScheme());//返回当前页面使用的协议，http 或是 https;
        requestHeader.setRemoteHost(request.getRemoteHost());//获得客户端的主机名
        requestMessage.setRequestHeader(requestHeader);
        Map<String, Object> parameters = new HashMap<String, Object>();
        Enumeration<String> en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String name = en.nextElement();
            String value = request.getParameter(name);
            parameters.put(name, value);

        }
        JSONObject content = new JSONObject(parameters);
        requestbody.setContent(content);
        requestMessage.setRequestHeader(requestHeader);
        requestMessage.setRequestBody(requestbody);
        logger.info("RequestMessage:"+JSONObject.toJSONString(requestMessage));

    }

    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint JoinPoint ,Object object) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("########后置通知########");
        JSONObject jsonObject=new JSONObject();
        String json=JSONObject.toJSONString(object);
        ResponseMessage responseMessage = JSONObject.parseObject(json, ResponseMessage.class);
        long endTime = System.currentTimeMillis();
        long  t= endTime-time.get();
        JSONObject jsonObject1 = JSONObject.parseObject(json);
        jsonObject1.put("time",t);
        logger.info("ResponseMessage :" + jsonObject1.toJSONString());
        //logger.info("RESPONSE :" + JSONObject.toJSONString(object));




    }
    @After("webLog()")
    public void doAfter(JoinPoint JoinPoint ){
        System.out.println("########最终通知####");
    }
    @AfterThrowing(pointcut = "webLog()")
    public void afterThrow(JoinPoint JoinPoint ){
        System.out.println("#####报错了######" );
    }
    @Around("webLog()")
    public Object  doAround(ProceedingJoinPoint proceedingJoinPoint ){
        try {
            time.set(System.currentTimeMillis());
            System.out.println("###########方法前#########");
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("###########方法后#########");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
