package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 1.interrupt a thread not means to kill a thread, end its lifecycle
 * just interrupt its blocked status.
 * <p>
 * 2.interrupt will throw a InterruptedException
 **/
@Slf4j
public class ThreadInterrupt2 {

	public static void main(String[] args) throws InterruptedException {

		String name = Thread.currentThread().getName();

		log.info("main thread name ={}", name);

		Thread thread = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.MINUTES.sleep(1);
				} catch (InterruptedException e) {
					log.info("thread interrupted?={}",Thread.currentThread().isInterrupted());
					e.printStackTrace();
				}
			}
		});
		thread.setDaemon(true);
		thread.start();

		TimeUnit.MILLISECONDS.sleep(2);
		log.info("1.interrupted?={}", thread.isInterrupted());

		thread.interrupt();

		TimeUnit.MILLISECONDS.sleep(2);
		log.info("2.interrupted?={}", thread.isInterrupted());




	}

}
