package com.wangwenjun.concurrency.video.phase1.chapter12;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GroupApi {


	public static void main(String[] args) {
		ThreadGroup tg1 = new ThreadGroup("TG1");

		Thread t1 = new Thread(tg1, "t1") {
			@Override
			public void run() {

				while (true) {
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};

		t1.start();

		ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
		Thread t2 = new Thread(tg2, "t2") {
			@Override
			public void run() {
				while (true) {
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t2.start();

		System.out.println(tg1.activeCount());
		System.out.println(tg1.activeGroupCount());

		t2.checkAccess();

//		tg1.destroy();

		Thread[] ts1 = new Thread[tg1.activeCount()];
		log.info("ts1.length={}",ts1.length);

		tg1.enumerate(ts1);
		Arrays.asList(ts1).forEach(System.out::println);

		tg1.interrupt();
	}
}
