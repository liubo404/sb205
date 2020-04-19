package com.wangwenjun.concurrency.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt2 {

	private static final  Object monitor = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {

					 synchronized (monitor ){
						 try {
							 monitor.wait(10);
						 } catch (InterruptedException e) {
							 e.printStackTrace();
						 }
					 }
				}
			}
		};

		t.start();

		TimeUnit.SECONDS.sleep(1);
		System.out.println(t.isInterrupted());

		t.interrupt();
		System.out.println(t.isInterrupted());

		t.stop();
	}


}
