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
public class ThreadInterrupted {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(()->{
  			while (true){
				System.out.println(Thread.interrupted());
//  				log.info("Thread Interrupted:{}",Thread.interrupted());
			}
		});

		thread.setDaemon(true);
		thread.start();

		TimeUnit.MILLISECONDS.sleep(1);
		thread.interrupt();

	}

}
