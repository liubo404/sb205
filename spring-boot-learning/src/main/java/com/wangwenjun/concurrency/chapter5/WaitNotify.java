package com.wangwenjun.concurrency.chapter5;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitNotify {

	private final Object MUTEX = new Object();



	public static void main(String[] args) {
		WaitNotify wn = new WaitNotify();
//		wn.testWait();
//		wn.testNotify();

//		wn.testNotifySync();
		wn.testWaitSync();
	}

	//---------------------------------------------------------------------
	// wait notify on different object
	//---------------------------------------------------------------------

	private synchronized void testWaitSync(){

		try {
			MUTEX.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private synchronized void testNotifySync(){
		MUTEX.notify();
	}




	//---------------------------------------------------------------------
	// wait notify without synchronized
	//---------------------------------------------------------------------



	private void testWait(){
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void  testNotify(){
		this.notify();
	}

}
