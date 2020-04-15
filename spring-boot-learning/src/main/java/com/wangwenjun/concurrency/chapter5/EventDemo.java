package com.wangwenjun.concurrency.chapter5;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author liubo
 * @date 2020-04-15 16:38
 * @description
 **/
@Slf4j
public class EventDemo {

	public static void main(String[] args) {
		final EventQueue eq = new EventQueue();

		new Thread(() -> {
			for (; ; ) {
				eq.offer(new EventQueue.Event());
			}
		}, "Producer").start();

		new Thread(() -> {
			for (; ; ) {
				eq.take();
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Consumer").start();

	}
}
