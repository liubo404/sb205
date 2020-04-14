package com.wangwenjun.concurrency.chapter9;

/**
 * 5. initialize child cause parent initialized
 */
public class Parent {

	static {
		System.out.println("Parent   is   initialized");
	}

	public static int y = 10;

	public Parent() {
		System.out.println("parent constructor.....");
	}
}
