package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class ThreadPriority2 {

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup group = new ThreadGroup("test");
		group.setMaxPriority(7);

		Thread t1 = new Thread(group,"Test_1");
		t1.setPriority(10);

		log.info("p={}",t1.getPriority());
		log.info("tid=={}",t1.getPriority());


		log.info("main id={}",Thread.currentThread().getId());


	}

}
