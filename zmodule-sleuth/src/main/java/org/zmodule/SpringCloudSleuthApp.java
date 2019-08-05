package org.zmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZipkinServer
public class SpringCloudSleuthApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(SpringCloudSleuthApp.class, args);
    }
}
