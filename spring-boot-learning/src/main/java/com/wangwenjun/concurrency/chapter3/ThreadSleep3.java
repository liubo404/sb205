package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 *  interrupt supported
 **/
@Slf4j
public class ThreadSleep3 {

	public static void main(String[] args) throws InterruptedException {
//		log.info("-----------Daemon thread-----------");

//		log.info("1main isinterrupted:{}",Thread.currentThread().isInterrupted());

//		TimeUnit.MILLISECONDS.sleep(4000);

//		Thread.currentThread().interrupt();
//		log.info("2.main isinterrupted:{}",Thread.currentThread().isInterrupted());

		Thread thread = new Thread(()->{
			while (true){
//				log.info("....3....t1 is interrupted:{}",Thread.currentThread().isInterrupted());
				try {
					TimeUnit.SECONDS.sleep(30);
				} catch (InterruptedException e) {
					log.info("....4....t1 is interrupted:{}",Thread.currentThread().isInterrupted());

					e.printStackTrace();
				}
			}
		});

		thread.setDaemon(true);
		thread.start();
		TimeUnit.MILLISECONDS.sleep(2);
		log.info("....1....t1 is interrupted:{}",thread.isInterrupted());

		TimeUnit.MILLISECONDS.sleep(2);
		thread.interrupt();
		log.info("....2....t1 is interrupted:{}",thread.isInterrupted());

	}
}
