package com.wangwenjun.concurrency.chapter1;


import lombok.extern.slf4j.Slf4j;

/**
 * @author liubo
 * @date 2020-04-08 13:42
 * @description
 **/
@Slf4j
public class DemoCon {

	public static void main(String[] args) {
//		Thread t1 = new Thread("Custom_Thread") {
//			@Override
//			public void run() {
//				for (int i = 0; i < 100; i++) {
//					log("Task A=>" + i);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
////				try {
////					Thread.sleep(1000*300L);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
//			}
//		};


//		t1.start();


//		for (int i = 0; i < 100; i++) {
//			log("Task A=>" + i);
//		}
//
//		for (int i = 0; i < 100; i++) {
//			log("Task B=>" + i);
//		}
//
//		readFromDB();
//
//		writeToFile();

		new Thread("READ_DB") {
			@Override
			public void run() {
				readFromDB();
			}
		}.start();


		new Thread("WRITE_FILE") {
			@Override
			public void run() {
				writeToFile();
			}
		}.start();
	}

	private static void readFromDB() {

		try {
			log("1.begin read data from db");
			Thread.sleep(1000 * 10L);
			log("1.read data done and start to handle it");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log("1.data handle complelte");
	}

	private static void writeToFile() {
		try {
			log("2.begin write to file");
			Thread.sleep(2000 * 10L);
			log("2. write done, handle it");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log("2.write finished");
	}

	private static void log(String msg) {
		log.info(msg);
	}
}
