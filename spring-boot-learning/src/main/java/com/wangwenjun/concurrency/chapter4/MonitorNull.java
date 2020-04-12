package com.wangwenjun.concurrency.chapter4;

public class MonitorNull {
	private final static  Object mutex = null;

	public static void main(String[] args) {
		synchronized (mutex){

		}
	}
}
