package com.wangwenjun.concurrency.video.phase2.chapter1;


/**
 * lazy load
 * <p>
 * not thread-safe
 */
public class Singleton2 {

	private static Singleton2 instance;

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		if (instance == null) {//multi-thread note safe
			instance = new Singleton2();
		}

		return Singleton2.instance;
	}
}
