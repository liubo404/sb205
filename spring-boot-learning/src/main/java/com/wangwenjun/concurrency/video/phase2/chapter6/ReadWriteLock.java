package com.wangwenjun.concurrency.video.phase2.chapter6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadWriteLock {
	private int readingReaders = 0;
	private int waitingReaders = 0;

	private int writingWriters = 0;
	private int waitingWriters = 0;


	public synchronized void readLock(){
		this.waitingReaders++;

	}
}
