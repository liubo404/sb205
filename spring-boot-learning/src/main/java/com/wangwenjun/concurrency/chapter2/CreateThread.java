package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-10 20:40
 * @description
 **/
@Slf4j
public class CreateThread {

	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();

		System.out.println(t.getName());

		Thread t2 = new Thread();
		t2.start();

		log.info(t2.getName());


		Thread t3 = new Thread("t3");
		Thread t4 = new Thread(() -> log.info("Runnable ...."));
		Thread t5 = new Thread(() -> log.info("Runnable ...." + Thread.currentThread().getName()), "R5");

		t5.start();

		log.info(t3.getName());
		log.info(t4.getName());
		log.info(t5.getName());
	}
}
