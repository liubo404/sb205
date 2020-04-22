package com.wangwenjun.concurrency.video.phase2.chapter4;


public abstract class MyObserver {

	protected Subject subject;

	public MyObserver(Subject subject) {
		this.subject = subject;
		this.subject.attatch(this);
	}

	public abstract void update();
}
