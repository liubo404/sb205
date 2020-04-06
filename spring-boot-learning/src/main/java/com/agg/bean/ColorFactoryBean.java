package com.agg.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个spring定义的 FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个Color对象，这个对象会添加到容器中
	public Color getObject() throws Exception {
		System.out.println("===> ColorFactoryBean...getObject...");
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	public boolean isSingleton() {
		return false;
	}
}
