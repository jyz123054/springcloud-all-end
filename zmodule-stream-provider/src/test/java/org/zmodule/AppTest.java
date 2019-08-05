package org.zmodule;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zmodule.service.IMessageProvider;
import org.zmodule.vo.Product;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = StreamProviderApp.class)
@RunWith(SpringRunner.class)
public class AppTest{
	
	@Resource
	private IMessageProvider iMessageProvider;
	
	@Test
	public void test1() {
		Product d = new Product();
		d.setProductId(1L);
		d.setProductName("jyz");
		d.setProductDesc("jyz desc");
		iMessageProvider.send(d);
	}
}
