package com.wangwenjun.concurrency.chapter23.v2;

public class WaitTimeoutException extends Exception {

	public WaitTimeoutException(String msg) {
		super(msg);
	}
}
