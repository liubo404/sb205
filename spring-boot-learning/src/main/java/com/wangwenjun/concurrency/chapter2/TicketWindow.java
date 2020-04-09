package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketWindow extends Thread {
	private final String name;

	public TicketWindow(String name) {
		this.name = name;
	}

	private static final int MAX = 50;

	private static int index = 1;

	@Override
	public void run() {

		while (index <= 50) {

			log.info("  {}-->number: {}", name, index++);
		}
	}
}
