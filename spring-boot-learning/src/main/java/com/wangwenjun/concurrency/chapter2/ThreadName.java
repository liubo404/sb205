package com.wangwenjun.concurrency.chapter2;

import java.util.stream.IntStream;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
public class ThreadName {

	public static void main(String[] args) {
		IntStream.range(0, 5).boxed().map(i -> new Thread(() -> System.out.println(Thread.currentThread().getName())))
				.forEach(Thread::start);
	}
}
