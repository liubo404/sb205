package com.wangwenjun.concurrency.chapter9;

/**
 * 5. initialize child cause parent initialized
 */
public class Child  extends Parent{

	static {
		System.out.println("Child   is   initialized");
	}

	public static int x = 10;

}
