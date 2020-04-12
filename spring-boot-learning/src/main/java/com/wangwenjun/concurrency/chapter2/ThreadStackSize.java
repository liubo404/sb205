package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class ThreadStackSize {

	final static String PREFIX = "ALEX-";

	private static Thread constructThread(final int name) {
		return new Thread(() -> log.info(Thread.currentThread().getName()), PREFIX + name);
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			log.info("Please enter the stack size.");
			System.exit(1);
		}

		ThreadGroup group = new ThreadGroup("TestGroup");

		Runnable runnable = new Runnable() {
			final int MAX = Integer.MAX_VALUE;

			@Override
			public void run() {
				int i = 0;
				recursive(i);
			}

			private void recursive(int i) {
				log.info("i={}", i);
				if (i < MAX) {
					recursive(i + 1);
				}
			}
		};


		Thread thread = new Thread(group, runnable, "Test-", Integer.parseInt(args[0]));

		thread.start();
	}
}
