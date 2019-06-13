  package com.csesteel.config;
  
  import com.alibaba.dubbo.config.ApplicationConfig; 
  import com.alibaba.dubbo.config.ProtocolConfig; 
  import com.alibaba.dubbo.config.RegistryConfig;
  import com.alibaba.dubbo.config.ServiceConfig; 
  import com.csesteel.service.AccountService;
  import org.springframework.context.annotation.Bean; 
  import org.springframework.context.annotation.Configuration;  
  import java.util.HashMap;
  import java.util.Map;
  
  @Configuration 
  public class DubboConfig {
  
	/*
	 * <dubbo:application name="account-provider"> <!-- 为了解决端口冲突
	 * https://blog.csdn.net/u012988901/article/details/84503672 -->
	 * <dubbo:parameter key="qos.enable" value="true"/> <dubbo:parameter
	 * key="qos.accept.foreign.ip" value="false"/> <dubbo:parameter key="qos.port"
	 * value="33333"/> </dubbo:application>
	 */
  
  @Bean 
  public ApplicationConfig applicationConfig(){ ApplicationConfig
	  applicationConfig=new ApplicationConfig();
	  applicationConfig.setName("account-provider"); 
	  Map<String,String> map=new  HashMap<String,String>();
	  map.put("qos.enable","true");
	  map.put("qos.accept.foreign.ip","false"); map.put("qos.port","33333");
	  applicationConfig.setParameters(map); 
	 return applicationConfig; 
  }
  
  //  <dubbo:registry id="acountaddr" address="zookeeper://localhost:2181"/>  
  @Bean 
  public RegistryConfig registryConfig(){ RegistryConfig
		  registryConfig=new RegistryConfig(); 
		  registryConfig.setId("acountaddr");
		  registryConfig.setAddress("zookeeper://localhost:2181");
		  return   registryConfig;
  } 
  // <dubbo:protocol name="dubbo" port="28080"/>  
  @Bean 
  public ProtocolConfig protocolConfig(){ ProtocolConfig
	  protocolConfig=new ProtocolConfig(); protocolConfig.setName("dubbo");
	  protocolConfig.setPort(28080); 
	 return protocolConfig;
  
  } //<dubbo:service registry="acountaddr" timeout="3000"
  //interface="com.csesteel.api.AccountApi" ref="accountService"></dubbo:service>  
  @Bean 
  public ServiceConfig serviceConfig(){ 
	  ServiceConfig serviceConfig=new  ServiceConfig(); 
	  serviceConfig.setRegistry(this.registryConfig());
      serviceConfig.setInterface("com.csesteel.api.AccountApi");
      serviceConfig.setTimeout(1200000); 
      serviceConfig.setRef(AccountService.class);  
    return serviceConfig; 
  } 
  
  }
  
 