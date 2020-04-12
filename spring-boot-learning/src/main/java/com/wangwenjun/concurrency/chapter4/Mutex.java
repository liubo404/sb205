package com.wangwenjun.concurrency.chapter4;

//import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

//@Slf4j
public class Mutex {

	private final static Object MUTEX = new Object();

	private void accessResource(){
		synchronized (MUTEX){
			try {
				TimeUnit.MINUTES.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final Mutex m = new Mutex();

		for(int i =0; i <5; i++){
			new Thread(m::accessResource).start();
		}
	}

}
