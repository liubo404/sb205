package com.wangwenjun.concurrency.video.phase2.chapter7;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
final public class ImmutAdder {
	private int value;

	public ImmutAdder(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public int add(int x) {
		return this.value += x;
	}


	public static void main(String[] args) throws InterruptedException {
		ImmutAdder ia = new ImmutAdder(0);

		List<Thread> threads = IntStream.rangeClosed(1, 10)
				.mapToObj(x -> new Thread(() -> {
					for (int j = 0; j < 10000; j++) {
						ia.add(1);
					}
					log.info("{}-{}", Thread.currentThread().getName(), ia.getValue());
				}, "T" + x))
				.collect(Collectors.toList());

		threads.forEach(Thread::start);

		for (Thread thread : threads) {
			thread.join();
		}


		log.info("{}-{}", Thread.currentThread().getName(), ia.getValue());
	}
}
