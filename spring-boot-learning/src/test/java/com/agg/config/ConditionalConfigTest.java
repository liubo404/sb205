package com.agg.config;

import com.agg.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class ConditionalConfigTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConditionalConfig.class);

		System.out.println("===> IOC init completed....");

		String[] names = context.getBeanDefinitionNames();

		for (String bn : names) {
			System.out.println("===> conditional bn: " + bn);
		}

		System.out.println("====person objects====");

		Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
		System.out.println(beansOfType);

		ConfigurableEnvironment env = context.getEnvironment();
		String os = env.getProperty("os.name");

		System.out.println(os);

	}

}