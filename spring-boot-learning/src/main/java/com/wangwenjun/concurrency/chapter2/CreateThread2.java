package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-10 21:00
 * @description
 **/
@Slf4j
public class CreateThread2 {

	public static void main(String[] args) {

		log.info(Thread.currentThread().getName());

		Thread t  = new Thread();
//		t.start();

		log.info(Thread.currentThread().getThreadGroup().getName());
		log.info("t.g={}",t.getThreadGroup());


	}
}
