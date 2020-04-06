package com.agg.bean;

/**
 * @author liubo
 * @date 2020-04-06 22:37
 * @description
 **/
public class Car {

	public Car() {
		System.out.println("===>.1.Car constructor...");
	}

	public void init() {
		System.out.println("--->.2.car init....");
	}

	public void destroy() {
		System.out.println("--->.3.car destroy....");
	}
}
