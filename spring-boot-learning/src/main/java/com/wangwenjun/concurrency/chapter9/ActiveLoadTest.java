package com.wangwenjun.concurrency.chapter9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActiveLoadTest {
	public static void main(String[] args) {

		//  both child and parent initialized.
		log.info("Initializing child cause parent initialized:{}", Child.x);

		// only parent initialized.
		log.info("If child just use parent static variable, child won't be initialized:{}",Child.y);

	}
}
