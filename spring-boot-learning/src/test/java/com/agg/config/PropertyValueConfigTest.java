package com.agg.config;

import com.agg.CommonTools;
import com.agg.bean.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class PropertyValueConfigTest {

	@Test
	public void lazyTest() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(PropertyValueConfig.class);

		System.out.println("....IOC...创建完成....");

		CommonTools.printBeanNames(context);

		Person p = (Person) context.getBean("person");

		System.out.println(p);

		System.out.println("===使用env取得配置文件中的值=====");
		ConfigurableEnvironment env = context.getEnvironment();
		System.out.println(env.getProperty("person.nickName"));

		//关闭ioc container
		context.close();

	}
}