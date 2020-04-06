package com.agg.config;

import com.agg.CommonTools;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleConfigTest {

	@Test
	public void lazyTest() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(LifeCycleConfig.class);

		System.out.println("....IOC...创建完成....");

		CommonTools.printBeanNames(context);

		//关闭ioc container
		context.close();

	}
}