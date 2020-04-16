package com.wangwenjun.concurrency.chapter23;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ProgrammerTravel extends Thread {
	private final Latch latch;

	private final String prgrammer;

	private final String transportation;

	public ProgrammerTravel(Latch latch, String prgrammer, String transportation) {
		this.latch = latch;
		this.prgrammer = prgrammer;
		this.transportation = transportation;
	}

	@Override
	public void run() {
		log.info("{} start take the transportation {}", prgrammer, transportation);

		try {
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("{} arrived by {}", prgrammer, transportation);

		latch.countDown();
	}
}
