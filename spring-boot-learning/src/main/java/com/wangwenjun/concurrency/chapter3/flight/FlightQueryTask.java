package com.wangwenjun.concurrency.chapter3.flight;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class FlightQueryTask extends Thread implements FlightQuery {

	private final String origin;
	private final String destination;
	private final List<String> flightList = new ArrayList<>();

	public FlightQueryTask(String airline, String origin, String destination) {
		super("[" + airline + "]");
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public void run() {
		int random = ThreadLocalRandom.current().nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(random);
			this.flightList.add(getName() + "_" + random);
			log.info("The Flight:{} is query successful", getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> query() {
		return this.flightList;
	}
}
