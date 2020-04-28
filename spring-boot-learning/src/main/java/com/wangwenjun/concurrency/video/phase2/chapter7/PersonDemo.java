package com.wangwenjun.concurrency.video.phase2.chapter7;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class PersonDemo {

	public static void main(String[] args) {

		Person p = new Person("LExa", "Ganshu");

		IntStream.range(1, 5).forEach(x -> {
			new PersonThread(p).start();
		});
	}
}

