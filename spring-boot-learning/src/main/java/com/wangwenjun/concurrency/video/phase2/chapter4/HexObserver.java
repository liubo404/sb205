package com.wangwenjun.concurrency.video.phase2.chapter4;


public class HexObserver extends MyObserver {

	public HexObserver(Subject subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("hex =" + Integer.toHexString(subject.getState()));
	}
}
