package com.wangwenjun.concurrency.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {

					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						System.out.println("sleep interrupted....");
						e.printStackTrace();
					}
				}
			}
		};

		t.start();

		TimeUnit.SECONDS.sleep(1);
		System.out.println(t.isInterrupted());

		t.interrupt();
		System.out.println(t.isInterrupted());
	}


}
