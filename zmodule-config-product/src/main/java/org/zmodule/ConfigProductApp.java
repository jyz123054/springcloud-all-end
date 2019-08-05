package org.zmodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("org.zmodule.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class ConfigProductApp {
    public static void main( String[] args ) {
    	SpringApplication.run(ConfigProductApp.class, args);
    }
    
}
