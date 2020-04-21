package com.wangwenjun.concurrency.video.phase1.chapter13;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class SimplePool {

	private final int size;

	private final static int DEFAULT_SIZE = 10;

	public SimplePool() {
		this(DEFAULT_SIZE);
	}

	public SimplePool(int size) {
		this.size = size;
		init();
	}

	private void init() {

	}

	private enum TaskState {
		FREE, RUUNING, BLOCKED, DEAD
	}

	private static class WorkTask extends Thread {

		private volatile TaskState taskState;

		private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

		public TaskState getTaskState() {
			return taskState;
		}

		public void close() {
			this.taskState = TaskState.DEAD;
		}

		public WorkTask(ThreadGroup group, String name) {
			super(group, name);
		}

		@Override
		public void run() {
			OUTER:
			while (this.taskState != TaskState.DEAD) {

				synchronized (TASK_QUEUE) {
					while (TASK_QUEUE.isEmpty()) {
						try {
							this.taskState = TaskState.BLOCKED;

							TASK_QUEUE.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							break OUTER;
						}
					}

					Runnable runnable = TASK_QUEUE.removeFirst();
					if (runnable != null) {
						this.taskState = TaskState.RUUNING;

						runnable.run();
						this.taskState = TaskState.FREE;
					}

				}
			}
		}
	}
}
