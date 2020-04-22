package com.wangwenjun.concurrency.video.phase2.chapter2;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


@Slf4j
public class WaitSet {
	private static final Object LOCK = new Object();


	/**
	 * 1.所有的对象都会有一个wait set, 用于存放调用了该对象的wait()方法之后进入blocked状态的线程
	 * 2.线程被notify这后，不一定立即得到执行
	 * 3.唤醒顺序不确定
	 * 4.线程被唤醒后，必须重新获取锁
	 * @param args
	 */
	public static void main(String[] args) {

		IntStream.range(1, 10).forEach(x -> {
			new Thread(String.valueOf(x)) {
				@Override
				public void run() {

					synchronized (LOCK) {

						try {
							log.info("{} will come to wait set", currentThread().getName());
							LOCK.wait();
							log.info("{} will leave to wait set", currentThread().getName());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		});

		IntStream.range(1, 10).forEach(x -> {

			synchronized (LOCK){
				LOCK.notify();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

	}
}
