package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * what's different between Thread.interrupted() and Thread.currentThread().isInterrupted()?
 *
 * hint: whether clear the interrupt flag
 *
 **/
@Slf4j
public class ThreadInterrupt3 {

	public static void main(String[] args) {
		log.info("1.Main thread isInterrupted:{}", Thread.interrupted());


		Thread.currentThread().interrupt();

		log.info("2.Main thread isInterrupted:{}", Thread.currentThread().isInterrupted());

		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			log.info("3.I'll be interrupted .....");
			e.printStackTrace();
		}
	}

}
