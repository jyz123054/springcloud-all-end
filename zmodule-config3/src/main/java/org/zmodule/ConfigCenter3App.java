package org.zmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * SpringCloud配置中心
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3App {
    public static void main( String[] args ) {
    	SpringApplication.run(ConfigCenter3App.class, args);
    }
}
