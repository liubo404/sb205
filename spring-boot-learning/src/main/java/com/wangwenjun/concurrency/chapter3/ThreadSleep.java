package com.wangwenjun.concurrency.chapter3;

import com.agg.CommonTools;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		log.info("-----------Daemon thread-----------");


		Thread thread = new Thread(() -> {

			long startTime = System.currentTimeMillis();
			CommonTools.sleep(2000L);
			long endTime = System.currentTimeMillis();

			log.info(" Total spend {} ms",endTime-startTime);

		});


		thread.start();


		long startTime = System.currentTimeMillis();
		TimeUnit.MILLISECONDS.sleep(4000);
//		CommonTools.sleep(3000L);
		long endTime = System.currentTimeMillis();

		log.info("Main Thread  Total spend {} ms.",endTime-startTime);
	}
}
