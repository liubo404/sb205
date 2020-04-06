package com.agg.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author liubo
 * @date 2020-04-06 23:15
 * @description
 **/
public class Dog {

	public Dog() {
		System.out.println("--->1..Dog constructor.....");
	}


	//对象创建并赋值之后调用
	@PostConstruct
	public void init() {
		System.out.println("--->2. Dog PostConstruct");
	}

	//在容器移除对象之前调用¬
	@PreDestroy
	public void destroy() {
		System.out.println("---3..Dog PreDestroy");
	}
}
