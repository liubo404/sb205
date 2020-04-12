package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		log.info("-----------Daemon thread-----------");


		Thread thread = new Thread(() -> {
			while (true) {
				try {
					log.info("daemon thread:{}", Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});


		thread.setDaemon(true);

		thread.start();

		Thread.sleep(2000L);

		log.info("Main Thread finished lifecycle.");
	}
}
