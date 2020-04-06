package com.agg.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyInitConfigTest {

	@Test
	public void lazyTest() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(LazyInitConfig.class);

		System.out.println(".2...IOC...创建完成....");


	}

}