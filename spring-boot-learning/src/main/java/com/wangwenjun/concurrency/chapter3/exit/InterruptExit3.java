package com.wangwenjun.concurrency.chapter3.exit;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class InterruptExit3 {

	static class MyTask extends Thread {
		private volatile boolean closed = false;

		@Override
		public void run() {
			log.info("I'll start to work");
			while (!closed && !isInterrupted()) {

			}
			log.info("I'll be exiting");

		}

		public void close() {
			this.closed = true;
			this.interrupt();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyTask t = new MyTask();
		t.start();

		TimeUnit.SECONDS.sleep(1);
		log.info("System will be shutdown");
		t.close();
	}
}
