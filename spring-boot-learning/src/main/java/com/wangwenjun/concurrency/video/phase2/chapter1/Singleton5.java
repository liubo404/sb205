package com.wangwenjun.concurrency.video.phase2.chapter1;


/**
 *  volatile
 */
public class Singleton5 {

	private static volatile Singleton5 instance; //here fixed

	private Singleton5() {

	}

	/**
	 * defect: NPE fixed
	 * @return
	 */
	public  static Singleton5 getInstance() {
		if(null==instance){
			synchronized(Singleton5.class){
				if (instance == null) {
					instance = new Singleton5(); //thread.1.init not completed
				}
			}
		}


		return Singleton5.instance; //thread.2.get instance will be null
	}
}
