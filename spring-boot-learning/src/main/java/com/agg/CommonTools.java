package com.agg;

import org.springframework.context.ApplicationContext;

/**
 * @author liubo
 * @date 2020-04-06 16:47
 * @description
 **/
public class CommonTools {
	public static void printBeanNames(ApplicationContext context) {
		String[] beanNamesForType = context.getBeanDefinitionNames();
		for (String name : beanNamesForType) {
			System.out.println("--> include beanNames: " + name);
		}
	}

	public static  void sleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
