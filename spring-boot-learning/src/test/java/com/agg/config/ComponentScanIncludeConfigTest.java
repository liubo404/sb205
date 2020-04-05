package com.agg.config;

import com.agg.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanIncludeConfigTest {

	@Test
	public void includeTest() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanIncludeConfig.class);


		String[] beanNamesForType =  context.getBeanDefinitionNames();
		for (String name : beanNamesForType) {
			System.out.println("--> include beanNames: " + name);
		}
	}
}