package com.wangwenjun.concurrency.chapter5;

import java.util.concurrent.TimeUnit;

/**
 * @author liubo
 * @date 2020-04-16 11:06
 * @description
 **/
public class SynchronizedDefect {

	public synchronized void syncMethod() {

		try {
			TimeUnit.HOURS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedDefect defect = new SynchronizedDefect();

		Thread t1 = new Thread(defect::syncMethod, "T1");
		t1.start();

		TimeUnit.SECONDS.sleep(1);

		Thread t2 = new Thread(defect::syncMethod, "21");
		t2.start();

		t2.interrupt();

		System.out.println(t2.isInterrupted());
		System.out.println(t2.getState());
	}
}
