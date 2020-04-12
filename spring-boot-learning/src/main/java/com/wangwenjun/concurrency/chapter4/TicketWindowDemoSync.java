package com.wangwenjun.concurrency.chapter4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketWindowDemoSync {

	public static void main(String[] args) {
		final TicketWindowSync task = new TicketWindowSync();

		Thread w1 = new Thread(task,"Window_1");
		Thread w2 = new Thread(task,"Window_2");
		Thread w3 = new Thread(task,"Window_3");
		Thread w4 = new Thread(task,"Window_4");

		w1.start();
		w2.start();
		w3.start();
		w4.start();

	}
}
