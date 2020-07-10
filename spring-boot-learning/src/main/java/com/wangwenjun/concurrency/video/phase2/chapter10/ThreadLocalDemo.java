package com.wangwenjun.concurrency.video.phase2.chapter10;

import com.wangwenjun.concurrency.video.phase2.chapter6.ReadWriteLock;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {

	private static  ThreadLocal<String> tl = new ThreadLocal(){
		@Override
		protected String initialValue() {
			return "ALEX";
		}
	};


	//JVM start the main thread
	public static void main(String[] args) throws InterruptedException {

//		tl.set("ALex");


		TimeUnit.MILLISECONDS.sleep(100);

		System.out.println(tl.get());



	}

}
