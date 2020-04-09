package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketWindowRunnable implements Runnable {


	private static final int MAX = 50;

	private int index = 1;

	@Override
	public void run() {

		while (index <= MAX) {

			log.info("  {}-->number: {}", Thread.currentThread().getName(), index++);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
