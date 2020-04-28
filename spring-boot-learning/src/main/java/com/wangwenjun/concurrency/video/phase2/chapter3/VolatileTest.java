package com.wangwenjun.concurrency.video.phase2.chapter3;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class VolatileTest {

	private static volatile int init = 0;

	private final static int MAX = 5;

	public static void main(String[] args) {
		new Thread(() -> {

			int local = init;
			while (local < MAX) {
				if (local != init) {
					System.out.println("The value update to " + init);
					local = init;
				}
			}


		}, "READER").start();

		new Thread(() -> {
			int local = init;
			while (init < MAX) {
				log.info("The value will  to {}", ++local);
				init = local;

				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}


		}, "Writer").start();
	}
}
