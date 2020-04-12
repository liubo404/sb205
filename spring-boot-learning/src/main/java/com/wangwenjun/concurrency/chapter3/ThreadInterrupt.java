package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 1.interrupt a thread not means to kill a thread, end its lifecycle
 * just interrupt its blocked status.
 *
 * 2.interrupt will throw a InterruptedException
 **/
@Slf4j
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {

		String name = Thread.currentThread().getName();

		log.info("main thread name ={}", name);

		Thread thread = new Thread(()->{
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				log.info("This thread has been interrupted");
				e.printStackTrace();

			}
		});

		thread.start();

		TimeUnit.MILLISECONDS.sleep(2);

		thread.interrupt();

	}

}
