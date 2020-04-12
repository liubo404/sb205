package com.wangwenjun.concurrency.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TicketWindowSync implements Runnable {
	private int index = 1;

	private final int MAX = 500;

	private final static Object MUTEX = new Object();

	@Override
	public void run() {

		synchronized (MUTEX) {

			while (index <= MAX) {

				log.info("{} number is: {}", Thread.currentThread(), index++);
			}
		}
	}
}
