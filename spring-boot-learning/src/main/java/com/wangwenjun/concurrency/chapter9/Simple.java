package com.wangwenjun.concurrency.chapter9;

import com.wangwenjun.concurrency.chapter10.MyLoader;
import lombok.extern.slf4j.Slf4j;

/**
 * 1.access Simple.x cause Simple initialized.
 * 2.access Simple.test() cause Simple initialized.
 */
public class Simple {

	static {
		System.out.println("I will be initialized");
	}

	public static int x = 10;

	public static void test(){

	}

	// 4. main method cause Simple to initialized. start class
	public static void main(String[] args) throws ClassNotFoundException {
		// 3. reflect cause Simple initialized.
		Class.forName("com.wangwenjun.concurrency.chapter9.Simple");
	}

}
