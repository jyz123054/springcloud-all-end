package org.zmodule.controller;

import org.zmodule.vo.Product;
import org.zmodule.service.IProductClientServiceInter;
import org.zmodule.service.IZuulClientServiceInter;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    @Resource
    private IProductClientServiceInter iProductClientServiceInter;
    
    @Resource
    private IZuulClientServiceInter iZuulClientServiceInter;
    
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/provider/get")
    public Object getProduct(long id) {
        return  iProductClientServiceInter.getProduct(id);
    }

    @RequestMapping("/provider/list")
    public  Object listProduct() {
    	//指定要是哪一个服务zmodule-provider
    	ServiceInstance instance = loadBalancerClient.choose("zmodule-provider");
    	
    	System.out.println(
                "【*** Feign ServiceInstance ***】host = " + instance.getHost()
                        + "、port = " + instance.getPort()
                        + "、serviceId = " + instance.getServiceId());
    	
        return iProductClientServiceInter.listProduct();
    }

    @RequestMapping("/provider/add")
    public Object addPorduct(Product product) {
        return  iProductClientServiceInter.addPorduct(product);
    }
    
    @RequestMapping("/provider/getProductAndUser")
    public Object getProductAndUser(long id) {
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("product", iZuulClientServiceInter.getProduct(id));
        result.put("user", iZuulClientServiceInter.getUsers(id+""));
        return  result;
    }
    
}