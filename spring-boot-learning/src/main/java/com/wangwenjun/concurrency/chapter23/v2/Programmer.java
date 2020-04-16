package com.wangwenjun.concurrency.chapter23.v2;

import java.util.concurrent.TimeUnit;

public class Programmer {

	public static void main(String[] args) throws InterruptedException {
		Latch latch = new CountDownLatch(4);
		new ProgrammerTravel(latch, "Alex", "Bus").start();
		new ProgrammerTravel(latch, "Bob", "walking").start();
		new ProgrammerTravel(latch, "Cat", "Subway").start();
		new ProgrammerTravel(latch, "Dillon", "Bicycle").start();

		try {
			latch.await(TimeUnit.SECONDS,5);
			System.out.println("====================== all programmer arrived ========");
		} catch (WaitTimeoutException e) {
			e.printStackTrace();
		}

	}
}
