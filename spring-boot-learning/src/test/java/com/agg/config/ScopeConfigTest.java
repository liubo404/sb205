package com.agg.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeConfigTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ScopeConfig.class);

		String[] beanDefinitionNames = context.getBeanDefinitionNames();

		for (String name : beanDefinitionNames) {
			System.out.println("---> MainConfig2  beanDefinitionName: " + name);
		}


		System.out.println("-====================");
		Object wangwu = context.getBean("wangwu");
		Object wangwu2 = context.getBean("wangwu");

		System.out.println(wangwu == wangwu2);

		System.out.println("===========scopedPerson==========");
		Object scopedPerson = context.getBean("scopedPerson");
		Object scopedPerson2 = context.getBean("scopedPerson");

		System.out.println(scopedPerson == scopedPerson2);
	}

}