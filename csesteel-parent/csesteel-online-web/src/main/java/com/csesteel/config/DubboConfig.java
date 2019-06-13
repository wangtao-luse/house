
package com.csesteel.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {
   //  <dubbo:application name="online-consumer"/>
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig  applicationConfig=new ApplicationConfig();
        applicationConfig.setName("online-consumer");
        return applicationConfig;
    }
    // <dubbo:registry address="zookeeper://localhost:2181"/>
    @Bean
    public RegistryConfig  registryConfig(){
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        return registryConfig;
    }
    // <dubbo:protocol port="28080"/>
    public ProtocolConfig protocolConfig(){
        ProtocolConfig   protocolConfig=new ProtocolConfig();
        protocolConfig.setPort(28080);
        return protocolConfig;
    }
  // <dubbo:reference id="accountService" interface="com.csesteel.api.AccountApi"/>
    public ReferenceConfig referenceConfig(){
        ReferenceConfig referenceConfig=new ReferenceConfig();
        referenceConfig.setId("accountService");
        referenceConfig.setInterface("com.csesteel.api.AccountApi");
        referenceConfig.setTimeout(1200000);
        return referenceConfig;
    }
}
