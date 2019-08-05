package org.zmodule.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zmodule.vo.Users;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/get/{name}")
    @HystrixCommand(fallbackMethod = "fallbackMe")
    public  Object get(@PathVariable("name")String name) {
        Users users = new Users();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }
	
	public  Object fallbackMe(@PathVariable("name")String name) {
        Users users = new Users();
        users.setName("hystrix");
        users.setAge(0);
        users.setSex("hystrix");
        return users;
    }
	
}
