package com.wangwenjun.concurrency.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt4 {


	static class Worker extends Thread {
		private volatile boolean start = true;

		@Override
		public void run() {
			while (start) {

			}
		}

		public void shutdown() {
			this.start = false;
		}
	}


	public static void main(String[] args) throws InterruptedException {

		Worker worker = new Worker();

		worker.start();


		TimeUnit.SECONDS.sleep(1);

		worker.shutdown();

	}


}
