package com.wangwenjun.concurrency.video.phase2.chapter1;


/**
 *  lazy load
 */
public class Singleton3 {

	private static Singleton3 instance;

	private Singleton3() {

	}

	/**
	 * performance deffectvie
	 * @return
	 */
	public synchronized static Singleton3 getInstance() {
		if (instance == null) {
			instance = new Singleton3();
		}

		return Singleton3.instance;
	}
}
