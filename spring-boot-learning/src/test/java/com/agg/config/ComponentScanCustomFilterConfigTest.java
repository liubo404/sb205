package com.agg.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanCustomFilterConfigTest {

	@Test
	public void includeTest() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanCustomFilterConfig.class);


		String[] beanNamesForType = context.getBeanDefinitionNames();
		for (String name : beanNamesForType) {
			System.out.println("--> include custome filter  beanNames: " + name);
		}
	}

}