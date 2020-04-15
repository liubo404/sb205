package com.wangwenjun.concurrency.chapter5;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author liubo
 * @date 2020-04-15 16:38
 * @description
 **/
@Slf4j
public class EventQueue {
	private final int MAX;

	static class Event {
	}

	private final LinkedList<Event> eventQueue = new LinkedList<>();

	private final static int DEFAULT_MAX_EVENT = 10;

	public EventQueue(int MAX) {
		this.MAX = MAX;
	}

	public EventQueue() {
		this(DEFAULT_MAX_EVENT);
	}


	public void offer(Event event){
		synchronized (eventQueue){
			if(eventQueue.size()>=MAX){

			}
		}
	}
}
