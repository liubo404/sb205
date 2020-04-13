package com.wangwenjun.concurrency.chapter9;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class GlobalConstants {
	static {
		System.out.println(" GlobalConstants initialized ");
	}

	// access this const wont cause class initialized
	public final static int MAX = 10;

	// cause initialize
	public final static int RANDOM = new Random().nextInt();

}
