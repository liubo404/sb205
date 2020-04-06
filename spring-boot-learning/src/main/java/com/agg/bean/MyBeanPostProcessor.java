package com.agg.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 后置处理器，在bean初始化前后进行处理
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("--->postProcessBeforeInitialization..." + beanName + "=>" + bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("--->postProcessAfterInitialization..." + beanName + "=>" + bean);
		return bean;
	}
}
