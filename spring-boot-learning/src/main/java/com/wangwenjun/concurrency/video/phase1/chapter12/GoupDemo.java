package com.wangwenjun.concurrency.video.phase1.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * sleep 不会放弃CPU的执行权，不会block住
 */
@Slf4j
public class GoupDemo {
	public static void main(String[] args) {
		log.info("{}", Thread.currentThread().getName());
		log.info("{}", Thread.currentThread().getThreadGroup());


		//1. use name
		ThreadGroup tg1 = new ThreadGroup("TG1");

		Thread t1 = new Thread(tg1, "t1") {
			@Override
			public void run() {
				while (true) {

					try {

						log.info("t1.group={},parent={}", getThreadGroup().getName(),getThreadGroup().getParent());
						log.info(" parent.parent={}",  getThreadGroup().getParent().activeCount());
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t1.start();



		ThreadGroup tg2 = new ThreadGroup(tg1,"TG2");

		log.info("tg2.group={},parent={}", tg2.getName() ,tg2.getParent() );



	}
}
