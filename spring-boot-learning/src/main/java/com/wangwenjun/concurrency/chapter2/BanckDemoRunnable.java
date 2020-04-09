package com.wangwenjun.concurrency.chapter2;

public class BanckDemoRunnable {

	public static void main(String[] args) {
		System.out.println("----bank queue----");
		final TicketWindowRunnable tw = new TicketWindowRunnable();

		Thread t1 = new Thread(tw,"Window_1");
		Thread t2 = new Thread(tw,"Window_2");
		Thread t3 = new Thread(tw,"Window_3");

		t1.start();
		t2.start();
		t3.start();

	}
}
