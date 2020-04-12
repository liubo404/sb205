package com.wangwenjun.concurrency.chapter3;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-11 13:54
 * @description
 **/
@Slf4j
public class CurrentThread {

	public static void main(String[] args) throws InterruptedException {

		 String name = Thread.currentThread().getName();

		 log.info("main thread name ={}",name);

	}

}
