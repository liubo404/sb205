package com.wangwenjun.concurrency.chapter21;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.stream.Collectors.toList;

@Slf4j
public class ThreadLocalDemo2 {


	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<Integer> tlocal = new ThreadLocal<>();

		IntStream.range(0, 10)
				.forEach(i -> new Thread(()->{
					try {
						tlocal.set(i);
//						log.info("{}  set i {}",currentThread(),tlocal.get());
						TimeUnit.SECONDS.sleep(1);
						log.info("{}  get i {}",currentThread(),tlocal.get());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				},"T_"+i).start());



		log.info("{}  get i {}",currentThread(),tlocal.get());

	}
}
