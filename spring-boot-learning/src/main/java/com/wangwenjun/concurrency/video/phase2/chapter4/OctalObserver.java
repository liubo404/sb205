package com.wangwenjun.concurrency.video.phase2.chapter4;


public class OctalObserver extends MyObserver {

	public OctalObserver(Subject subject) {
		super(subject);
	}


	@Override
	public void update() {
		System.out.println("octal =" + Integer.toOctalString(subject.getState()));
	}
}
