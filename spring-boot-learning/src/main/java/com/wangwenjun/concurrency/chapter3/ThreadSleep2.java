package com.wangwenjun.concurrency.chapter3;

import com.agg.CommonTools;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 *  interrupt supported
 **/
@Slf4j
public class ThreadSleep2 {

	public static void main(String[] args) throws InterruptedException {
		log.info("-----------Daemon thread-----------");

//		log.info("1main isinterrupted:{}",Thread.currentThread().isInterrupted());

//		TimeUnit.MILLISECONDS.sleep(4000);

//		Thread.currentThread().interrupt();
//		log.info("2.main isinterrupted:{}",Thread.currentThread().isInterrupted());

		Thread thread = new Thread(()->{
			while (true){
				log.info("....3....t1 is interrupted:{}",Thread.currentThread().isInterrupted());
			}
		});

		thread.start();
		log.info("....1....t1 is interrupted:{}",Thread.currentThread().isInterrupted());
		thread.interrupt();
		log.info("....2....t1 is interrupted:{}",Thread.currentThread().isInterrupted());

		TimeUnit.MINUTES.sleep(1);
	}
}
