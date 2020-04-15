package com.wangwenjun.concurrency.chapter5.v2;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class EventQueue {
	private final int max;

	static class Event {

	}

	private final LinkedList<Event> eventQueue = new LinkedList<>();

	private final static int DEFAULT_MAX = 10;

	public EventQueue() {
		this(DEFAULT_MAX);
	}

	public EventQueue(int max) {
		this.max = max;
	}


	public void offer(Event e) {
		synchronized (eventQueue) {
			if (eventQueue.size() >= max) {
				try {
					log.info("the queue is full");
					eventQueue.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

			log.info(" the new event is submitted");
			eventQueue.addLast(e);
			eventQueue.notify();
		}
	}


	public Event take() {
		synchronized (eventQueue) {
			if (eventQueue.isEmpty()) {
				try {
					log.info(" the queue is empty");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			Event e = eventQueue.removeFirst();
			this.eventQueue.notify();
			log.info(" The event {} is handled.", e);
			return e;
		}
	}


}
