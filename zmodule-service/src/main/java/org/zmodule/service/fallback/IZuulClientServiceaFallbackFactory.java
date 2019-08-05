package org.zmodule.service.fallback;

import java.util.List;

import org.springframework.stereotype.Component;
import org.zmodule.service.IZuulClientServiceInter;
import org.zmodule.vo.Product;
import org.zmodule.vo.Users;

import feign.hystrix.FallbackFactory;

@Component	//记得要加上组件标识
public class IZuulClientServiceaFallbackFactory implements FallbackFactory<IZuulClientServiceInter>{

	@Override
	public IZuulClientServiceInter create(Throwable cause) {
		return new IZuulClientServiceInter() {
			
			@Override
			public List<Product> listProduct() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Users getUsers(String name) {
				Users user = new Users();
				user.setName("Hystrix Fallback");
				return user;
			}
			
			@Override
			public Product getProduct(long id) {
				Product product = new Product();
				product.setProductName("Hystrix Fallback");
				return product;
			}
			
			@Override
			public boolean addPorduct(Product product) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
