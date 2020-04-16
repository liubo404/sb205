package com.wangwenjun.concurrency.chapter23;

public class Programmer {

	public static void main(String[] args) throws InterruptedException {
		Latch latch = new CountDownLatch(4);
		new ProgrammerTravel(latch, "Alex", "Bus").start();
		new ProgrammerTravel(latch, "Bob", "walking").start();
		new ProgrammerTravel(latch, "Cat", "Subway").start();
		new ProgrammerTravel(latch, "Dillon", "Bicycle").start();

		latch.await();

		System.out.println("====================== all programmer arrived ========");
	}
}
