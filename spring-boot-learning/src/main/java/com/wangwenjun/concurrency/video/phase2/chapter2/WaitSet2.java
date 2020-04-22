package com.wangwenjun.concurrency.video.phase2.chapter2;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class WaitSet2 {
	private static final Object LOCK = new Object();

	public static void work() {
		synchronized (LOCK) {
			System.out.println("Begin....");

			try {
				System.out.println("will wait....");
				LOCK.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("thread out....");
		}
	}

	/**
	 * 4.线程被唤醒后，必须重新获取锁
	 * 然后从wait()处继续执行
	 *
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {

		new Thread(() -> work()).start();

		TimeUnit.SECONDS.sleep(2);

		synchronized (LOCK) {
			LOCK.notify();
		}

	}


}
