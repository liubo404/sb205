package com.agg.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author liubo
 * @date 2020-04-06 23:04
 * @description
 **/
public class Cat implements InitializingBean, DisposableBean {

	public Cat() {
		System.out.println("---> 1. Cat contructor....");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("---> 2. Cat InitializingBean ...afterPropertiesSet...");

	}

	public void destroy() throws Exception {
		System.out.println("---> 3. Cat DisposableBean....destroy...");
	}
}
