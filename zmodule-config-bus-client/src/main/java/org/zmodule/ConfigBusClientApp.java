package org.zmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigBusClientApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ConfigBusClientApp.class, args);
    }
}
