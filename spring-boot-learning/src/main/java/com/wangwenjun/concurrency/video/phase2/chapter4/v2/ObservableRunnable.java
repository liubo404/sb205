package com.wangwenjun.concurrency.video.phase2.chapter4.v2;

import org.apache.catalina.LifecycleListener;

/**
 * @author liubo
 * @date 2020-04-22 10:34
 * @description
 **/
public abstract class ObservableRunnable implements Runnable {

	final protected LifecycleListenerObserver listener;

	public ObservableRunnable(LifecycleListenerObserver listener) {
		this.listener = listener;
	}

	protected void notifyChange(final RunnableEvent event ) {

		listener.onEvent(event);
	}

	public enum RunningState {
		RUNNING, ERROR, DONE;
	}

	public static class RunnableEvent {

		private final RunningState state;
		private final Thread thread;
		private final Throwable cause;

		public RunnableEvent(RunningState state, Thread thread, Throwable cause) {
			this.state = state;
			this.thread = thread;
			this.cause = cause;
		}

		public RunningState getState() {
			return state;
		}

		public Thread getThread() {
			return thread;
		}

		public Throwable getCause() {
			return cause;
		}
	}
}
