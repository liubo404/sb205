package com.agg.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liubo
 * @date 2020-04-06 17:27
 * @description
 **/
public class MyImportRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * 把需要添加到ioc中的bean,调用此方法手工注册
	 *
	 * @param importingClassMetadata 当前类的注解信息
	 * @param registry               BeanDefinition的注册类
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		boolean blue = registry.containsBeanDefinition("com.agg.bean.Blue");
		boolean yellow = registry.containsBeanDefinition("com.agg.bean.Yellow");
		if (blue && yellow) {
			BeanDefinition bd = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainBow", bd);
		}

	}
}
