package com.wangwenjun.concurrency.video.phase2.chapter6;

import java.util.concurrent.TimeUnit;

/**
 * @author liubo
 * @date 2020-04-22 14:52
 * @description
 **/
public class SharedData {

	private final ReadWriteLock lock = new ReadWriteLock();

	private final char[] buffer;

	public SharedData(char[] buffer) {
		this.buffer = buffer;
		for(int i=0;i<buffer.length;i++){
			buffer[i]='*';
		}
	}

	public char[] read() throws InterruptedException {
		try{
			lock.readLock();
			return doRead();
		}finally {
			lock.readUnlock();
		}
	}

	private char[] doRead() {

		char[] newBuffer = new char[buffer.length];

		for(int i=0;i<buffer.length;i++){
			newBuffer[i]=buffer[i];
		}

		slowly(50);
		return newBuffer;

	}

	private void slowly(int i) {

		try {
			TimeUnit.MILLISECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
