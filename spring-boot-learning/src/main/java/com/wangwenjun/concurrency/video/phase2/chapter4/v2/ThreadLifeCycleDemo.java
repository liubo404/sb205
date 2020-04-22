package com.wangwenjun.concurrency.video.phase2.chapter4.v2;

import java.util.Arrays;

/**
 * @author liubo
 * @date 2020-04-22 10:55
 * @description
 **/
public class ThreadLifeCycleDemo {
	public static void main(String[] args) {
		new ThreadLifecycleListenerObserver().query(Arrays.asList("1","2"));
	}
}
