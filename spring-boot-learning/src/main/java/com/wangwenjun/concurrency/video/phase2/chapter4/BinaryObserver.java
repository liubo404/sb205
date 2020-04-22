package com.wangwenjun.concurrency.video.phase2.chapter4;


public class BinaryObserver extends MyObserver {

	public BinaryObserver(Subject subject) {
		super( subject);
	}


	@Override
	public void update() {
		System.out.println("binary =" + Integer.toBinaryString(subject.getState()));
	}
}
