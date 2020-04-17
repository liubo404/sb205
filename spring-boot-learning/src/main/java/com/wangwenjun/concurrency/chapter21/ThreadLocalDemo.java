package com.wangwenjun.concurrency.chapter21;

import com.wangwenjun.concurrency.chapter23.Latch;
import com.wangwenjun.concurrency.chapter3.ThreadJoin;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class ThreadLocalDemo {


	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<Cats> cats = new ThreadLocal<>();
		Cats old = new Cats();
		old.setNum(0);
		cats.set(old);
		List<Thread> threads = IntStream.range(0, 10000)
				.mapToObj(i -> new Thread(() -> {
					try {
						TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					cats.set(old);
					Cats c = cats.get();
					c.setNum(c.getNum() + 1);
					cats.set(c);
				}))
				.collect(toList());

		threads.forEach(Thread::start);


		for (Thread t : threads) {
			t.join();
		}

		log.info("---------------cats.get().num={}---------", cats.get().getNum());


	}
}
