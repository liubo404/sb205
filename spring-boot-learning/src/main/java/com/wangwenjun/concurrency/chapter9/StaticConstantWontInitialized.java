package com.wangwenjun.concurrency.chapter9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticConstantWontInitialized {

	public static void main(String[] args) {
//		log.info("access constant wont initialize, MAX={}",GlobalConstants.MAX);
		log.info(" use Random cause initialize, RANDOM={}",GlobalConstants.RANDOM);
	}


}
