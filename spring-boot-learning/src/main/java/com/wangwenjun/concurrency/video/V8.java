package com.wangwenjun.concurrency.video;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class V8 {
	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();

		Thread t2 = new Thread();
		t2.start();


		System.out.println(t.getName());
		System.out.println(t2.getName());

		Thread t3 = new Thread("T3");
		t3.start();
		log.info(t3.getName());


		Thread t4 = new Thread( );
		t4.start();
		log.info(t4.getName());

	}

}
