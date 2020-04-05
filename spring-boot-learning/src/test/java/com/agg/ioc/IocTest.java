package com.agg.ioc;

import com.agg.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liubo
 * @date 2020-04-05 23:13
 * @description
 **/
public class IocTest {

	@Test
	public void componentScanTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		String[] beanDefinitionNames = context.getBeanDefinitionNames();

		for (String name : beanDefinitionNames) {
			System.out.println("---> beanDefinitionName: " + name);
		}

	}
}
