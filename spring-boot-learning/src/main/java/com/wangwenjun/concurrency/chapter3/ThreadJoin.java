package com.wangwenjun.concurrency.chapter3;

import com.agg.CommonTools;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * interrupt supported
 **/
@Slf4j
public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {

		List<Thread> threads = IntStream.range(1, 3)
				.mapToObj(ThreadJoin::crate)
				.collect(toList());

		threads.forEach(Thread::start);

		log.info("---------------man------------start sleep---------");
		TimeUnit.SECONDS.sleep(2);
		log.info("---------------man------------end sleep---------");

		for (Thread t : threads) {
			t.join();
		}


		for (int i = 0; i < 10; i++) {
			log.info("name={},i={}", Thread.currentThread().getName(), i);
			shortSleep();
		}

	}

	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Thread crate(int seq) {
		return new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				log.info("name={},#={}", Thread.currentThread().getName(), i);
			}
		}, "SUB_"+ seq );
	}




}
