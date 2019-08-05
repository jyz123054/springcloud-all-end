package org.zmodule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zmodule.filter.ZuulServiceAuthFilter;

@Configuration
public class ZuulConfig {
	@Bean
	public ZuulServiceAuthFilter zuulServiceAuthFilter() {
		return new ZuulServiceAuthFilter();
	}
}
