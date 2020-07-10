package com.wangwenjun.concurrency.video.phase2.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadLocalSimulator<T> {
	private final Map<Thread, T> storage = new HashMap<>();


	public void set(T t) {
		synchronized (this) {
			Thread key = Thread.currentThread();
			storage.put(key, t);
		}
	}


	public T get() {
		synchronized (this) {
			Thread key = Thread.currentThread();
			T value = storage.get(key);
			if (value == null) {
				return initialValue();
			} else {
				return value;
			}
		}
	}

	private T initialValue() {

		return null;
	}
}
