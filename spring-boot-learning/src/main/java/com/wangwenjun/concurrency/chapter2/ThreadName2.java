package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class ThreadName2 {

	final static String PREFIX = "ALEX-";

	private static Thread constructThread(final int name) {
		return new Thread(() -> log.info(Thread.currentThread().getName()), PREFIX + name);
	}

	public static void main(String[] args) {
		IntStream.range(0, 5).boxed().map(ThreadName2::constructThread)
				.forEach(Thread::start);
	}
}
