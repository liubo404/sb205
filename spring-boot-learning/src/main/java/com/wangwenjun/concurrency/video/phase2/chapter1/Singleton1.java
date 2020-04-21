package com.wangwenjun.concurrency.video.phase2.chapter1;


import lombok.extern.slf4j.Slf4j;

/**
 * eagle load
 */
@Slf4j
public class Singleton1 {

	private static Singleton1 instance = new Singleton1();


	private Singleton1() {

	}


	public Singleton1 getInstance() {
		return instance;
	}


}
