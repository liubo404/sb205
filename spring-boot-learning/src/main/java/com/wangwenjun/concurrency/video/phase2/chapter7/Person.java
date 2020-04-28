package com.wangwenjun.concurrency.video.phase2.chapter7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person {
	private final String name;
	private final String address;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}

