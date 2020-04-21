package com.wangwenjun.concurrency.video.phase2.chapter1;


/**
 *  double check
 */
public class Singleton4 {

	private static Singleton4 instance;

	private Singleton4() {

	}

	/**
	 * defect: NPE
	 * @return
	 */
	public  static Singleton4 getInstance() {
		if(null==instance){
			synchronized(Singleton4.class){
				if (instance == null) {
					instance = new Singleton4(); //thread.1.init not completed
				}
			}
		}


		return Singleton4.instance; //thread.2.get instance will be null
	}
}
