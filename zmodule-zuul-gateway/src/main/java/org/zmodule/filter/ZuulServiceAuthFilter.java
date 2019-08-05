package org.zmodule.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulServiceAuthFilter extends ZuulFilter{

	public boolean shouldFilter() {
		//默认是false,是否需要过滤
		return true;
	}

	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext() ; // 获取当前请求的上下文
        String auth = "admin:enjoy"; // 认证的原始信息
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
		return null;
	}

	@Override
	public String filterType() {
		//认证相关的，应放在请求之前
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
