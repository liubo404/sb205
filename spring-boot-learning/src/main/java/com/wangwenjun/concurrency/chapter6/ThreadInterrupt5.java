package com.wangwenjun.concurrency.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt5 {


	static class Worker extends Thread {

		@Override
		public void run() {
			while (true) {

				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}

			}

			System.out.println("-------------breaking....");
		}


	}


	public static void main(String[] args) throws InterruptedException {

		Worker worker = new Worker();

		worker.start();


		TimeUnit.SECONDS.sleep(1);

		worker.interrupt();
	}


}
