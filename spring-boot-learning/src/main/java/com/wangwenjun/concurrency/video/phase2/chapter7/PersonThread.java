package com.wangwenjun.concurrency.video.phase2.chapter7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonThread extends Thread {
	private Person person;

	public PersonThread(Person person) {
		this.person = person;

	}

	@Override
	public void run() {
		while (true) {

			log.info("person={}", person);
		}
	}
}

