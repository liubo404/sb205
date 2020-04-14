package com.wangwenjun.concurrency.chapter11;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLoader {
	public static void main(String[] args) {
		log.info("main loader={}",Thread.currentThread().getContextClassLoader());

		new Thread(()->{
			log.info("thread loader={}",Thread.currentThread().getContextClassLoader());

		}).start();
	}

}
