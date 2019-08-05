package org.zmodule;
import org.selfribbon.config.SelfRibbonPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//自定义Ribbon路由策略
@RibbonClient(name = "zmodule-provider", configuration = SelfRibbonPolicy.class)
@EnableFeignClients("org.zmodule.service")
public class ConsumerFeignApp {
	
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApp.class,args);
    }
    
}