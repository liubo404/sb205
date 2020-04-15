package com.wangwenjun.concurrency.chapter9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Singleton {

	//.1.
	private static int x = 0;

	private static int y;

	private static Singleton instance = new Singleton();

	private Singleton() {
		x++;
		y++;
	}


	public static Singleton getInstance() {
		return instance;
	}


	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();

		log.info("Singleton.x = {}", singleton.x);
		log.info("Singleton.y = {}", singleton.y);

	}

}
