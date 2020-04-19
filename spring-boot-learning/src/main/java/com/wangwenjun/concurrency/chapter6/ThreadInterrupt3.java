package com.wangwenjun.concurrency.chapter6;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadInterrupt3 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {


				}
			}
		};

		t.start();

		Thread main = Thread.currentThread();
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					TimeUnit.MILLISECONDS.sleep(100);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				main.interrupt();
			}
		};

		t2.start();

		TimeUnit.SECONDS.sleep(1);

		t.join();
		System.out.println(t.isInterrupted());

	}


}
