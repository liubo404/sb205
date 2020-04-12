package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class ThreadPriority {

	public static void main(String[] args) throws InterruptedException {


		Thread t1 = new Thread(() -> {
			while (true) {
				log.info("t1");
			}
		});
		t1.setPriority(2);



		Thread t2 = new Thread(() -> {
			while (true) {
				log.info("t2");
			}
		});
		t2.setPriority(10);


		t1.start();
		t2.start();


	}

}
