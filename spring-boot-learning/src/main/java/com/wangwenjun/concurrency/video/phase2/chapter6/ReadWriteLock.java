package com.wangwenjun.concurrency.video.phase2.chapter6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadWriteLock {
	private int readingReaders = 0;
	private int waitingReaders = 0;

	private int writingWriters = 0;
	private int waitingWriters = 0;

	//---------------------------------------------------------------------
	// 1.read lock
	//---------------------------------------------------------------------


	public synchronized void readLock() throws InterruptedException {
		this.waitingReaders++;
		try {
			while (waitingWriters > 0) {
				this.wait();
			}
			this.readingReaders++;
		} finally {
			this.waitingReaders--;
		}
	}

	public synchronized void readUnlock() {
		this.readingReaders--;
		this.notifyAll();
	}


	//---------------------------------------------------------------------
	// 2.write lock
	//---------------------------------------------------------------------


	public synchronized void writeLock() throws InterruptedException {
		this.waitingWriters++;

		try {

			while (this.readingReaders > 0 || this.writingWriters > 0) {
				this.wait();
			}

			this.writingWriters++;

		} finally {
			this.waitingWriters--;
		}
	}

	public synchronized void writeUnlock() {
		this.writingWriters--;
		this.notifyAll();
	}
}
