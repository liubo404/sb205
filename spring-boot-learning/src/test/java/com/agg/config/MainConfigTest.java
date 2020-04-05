package com.agg.config;

import com.agg.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigTest {

	@Test
	public void person() {

		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		Person person = context.getBean(Person.class);

		System.out.println(person);

		String[] beanNamesForType = context.getBeanNamesForType(Person.class);
		for (String name : beanNamesForType) {
			System.out.println("--> name=" + name);
		}

	}
}