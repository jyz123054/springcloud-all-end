package org.zmodule.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zmodule.feign.FeignClientConfig;
import org.zmodule.service.fallback.IZuulClientServiceaFallbackFactory;
import org.zmodule.vo.Product;
import org.zmodule.vo.Users;

import java.util.List;

@FeignClient(name = "zmodule-zuul-gateway",
			 configuration = FeignClientConfig.class,
			 fallbackFactory = IZuulClientServiceaFallbackFactory.class)
public interface IZuulClientServiceInter {

    @RequestMapping("/jyz/zuul-proxy-product/provider/get/{id}")
    public Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/jyz/zuul-proxy-product/provider/list")
    public List<Product> listProduct() ;

    @RequestMapping("/jyz/zuul-proxy-product/provider/add")
    public boolean addPorduct(Product product) ;

    @RequestMapping("/jyz/zuul-proxy-user/user/get/{name}")
    public Users getUsers(@PathVariable("name")String name);
}