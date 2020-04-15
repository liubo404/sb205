package com.wangwenjun.concurrency.chapter12;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ReaderUpdater {
	final static int MAX = 5;
	static volatile	 int init_value = 0;

	public static void main(String[] args) {
		new Thread(()->{
			int local_value = init_value;
			while (local_value<MAX){
				if(local_value!=init_value){
					log.info("The init_value is updated to {}",init_value);
					local_value=init_value;
				}
			}
		},"Reader").start();

		new Thread(()->{
			int localValue = init_value;
			while (localValue<MAX){
				log.info("The init_value will be changed to {}",++localValue);
					init_value = localValue;
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"Updater").start();

	}

}
