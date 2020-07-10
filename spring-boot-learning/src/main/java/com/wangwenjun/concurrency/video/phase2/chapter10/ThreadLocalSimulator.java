package com.wangwenjun.concurrency.video.phase2.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadLocalDemo2 {

	private static ThreadLocal<String> tl = ThreadLocal.withInitial(() -> "ALEX");

	private final static Random random = new Random(System.currentTimeMillis());


	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			tl.set("Thread-t1");
			try {
				TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
				log.info("{} -1-> {}",Thread.currentThread().getName(), tl.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "T1");

		t1.start();

		Thread t2 = new Thread(() -> {
			tl.set("Thread-t2");
			try {
				TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
				log.info("{} -2-> {}",Thread.currentThread().getName(), tl.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "T2");
		t2.start();


		t1.join();
		t2.join();

		log.info("===================================");

		log.info("{} -3-> {}",Thread.currentThread().getName(), tl.get());


	}


}
