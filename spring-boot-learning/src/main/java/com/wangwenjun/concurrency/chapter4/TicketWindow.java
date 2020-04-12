package com.wangwenjun.concurrency.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TicketWindow implements Runnable {
	private int index = 1;

	private final int MAX = 500;

	@Override
	public void run() {

		while (index <= MAX) {
			int r = ThreadLocalRandom.current().nextInt(50);
			if (r % 33 == 0) {
				try {
					TimeUnit.MILLISECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			log.info("{} number is: {}", Thread.currentThread(), index++);
		}
	}
}
