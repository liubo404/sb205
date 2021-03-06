package com.agg.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanExcludeConfigTest {

	@Test
	public void excludeTest() {

		ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanExcludeConfig.class);


		String[] beanNamesForType = context.getBeanDefinitionNames();
		for (String name : beanNamesForType) {
			System.out.println("-->  beanNames: " + name);
		}

	}
}