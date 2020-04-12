package com.wangwenjun.concurrency.chapter3.exit;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class InterruptExit {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			log.info("I'll start to work");
			while (!Thread.currentThread().isInterrupted()) {

			}
			log.info("I'll be exiting.");

		});

		t.start();

		TimeUnit.SECONDS.sleep(1);
		log.info("System will be shutdown");
		t.interrupt();
	}
}
