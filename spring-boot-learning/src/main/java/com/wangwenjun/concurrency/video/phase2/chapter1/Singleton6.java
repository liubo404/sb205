package com.wangwenjun.concurrency.video.phase2.chapter1;


/**
 * heolder
 */
public class Singleton6 {

	private static Singleton6 instance;

	private Singleton6() {

	}

	private static class InstanceHolder {

		private final static Singleton6 instance = new Singleton6();
	}


	public Singleton6 getInstance() {
		return InstanceHolder.instance;
	}
}
