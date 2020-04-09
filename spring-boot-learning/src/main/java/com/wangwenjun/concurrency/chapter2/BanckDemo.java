package com.wangwenjun.concurrency.chapter2;

public class BanckDemo {

	public static void main(String[] args) {
		System.out.println("----bank queue----");
		TicketWindow tw1 = new TicketWindow("Win1");
		tw1.start();

		TicketWindow tw2 = new TicketWindow("Win2");
		tw2.start();

		TicketWindow tw3 = new TicketWindow("Win3");
		tw3.start();

	}
}
