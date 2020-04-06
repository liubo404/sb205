package com.agg.config;

import com.agg.CommonTools;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanConfigTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(FactoryBeanConfig.class);


		System.out.println("-======ioc init completed==============");
		CommonTools.printBeanNames(context);


		System.out.println("===========工厂Bean获取的是调用getObject创建的对象==========");
		Object bean2 = context.getBean("colorFactoryBean");
		Object bean3 = context.getBean("colorFactoryBean");
		System.out.println("===> bean factory class type= " + bean2.getClass());

		//是否一样，取决于 FactoryBean 中的isSingleton()方法
		boolean same = bean2 == bean3;
		System.out.println("单实例时，这两个Bean是否一样:" + same);


		//获取FactoryBean本身
		Object bf = context.getBean("&colorFactoryBean");
		System.out.println("bf 的type= "+ bf.getClass());


	}

}