package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class ThreadYield {

	public static void main(String[] args) throws InterruptedException {

		IntStream.range(0, 2).mapToObj(ThreadYield::crate)
				.forEach(Thread::start);

	}

	static Thread crate(int index) {
		return new Thread(() -> {
			if (index == 0) {
				Thread.yield();
			}
			log.info("index={}", index);

		});
	}
}
