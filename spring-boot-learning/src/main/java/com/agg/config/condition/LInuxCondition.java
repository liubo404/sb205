package com.agg.config.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author liubo
 * @date 2020-04-06 16:19
 * @description
 **/
//@Conditional() 放在类上，满足当前条件，这个类中配置的所有bean注册才能生效
public class LInuxCondition implements Condition {
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		//1.获得ioc使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

		//2.获取类加载器
		ClassLoader classLoader = context.getClassLoader();

		//3.获取当前环境
		Environment env = context.getEnvironment();

		//4.获取bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();


		String os = env.getProperty("os.name");

		return os.contains("Linux");
	}
}
