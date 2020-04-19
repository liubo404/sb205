package com.wangwenjun.concurrency.chapter21;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

@Slf4j
public class ThreadLocalDemo3 {


	public static void main(String[] args) throws InterruptedException {
//		Object o = new Object();
//		ThreadLocal<Object> tlocal = ThreadLocal.withInitial(() -> o);
		ThreadLocal<Object> tlocal = ThreadLocal.withInitial(Object::new);

		new Thread(() -> log.info("{}", tlocal.get())).start();


		log.info("{}  get i {}", currentThread(), tlocal.get());

	}
}
