package com.wangwenjun.concurrency.chapter9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassArrayWontInitialized {
	public static void main(String[] args) {

		// construct class array won't cause initialize
		Simple[] simples = new Simple[10];

		log.info("simples length={}", simples.length);

		log.info("// Simple not initialized.");
	}
}
