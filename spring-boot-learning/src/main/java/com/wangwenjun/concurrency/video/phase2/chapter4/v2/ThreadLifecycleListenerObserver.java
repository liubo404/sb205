package com.wangwenjun.concurrency.video.phase2.chapter4.v2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadLifecycleListenerObserver implements LifecycleListenerObserver {

	private final Object LOCK = new Object();

	public void query(List<String> ids){
		if(ids==null || ids.isEmpty()){
			return;
		}

		ids.stream().forEach(id->new Thread(new ObservableRunnable(this) {
			@Override
			public void run() {
				try{
					notifyChange(new RunnableEvent(RunningState.RUNNING, Thread.currentThread(),null));
					System.out.println("query for the id ="+id);
					TimeUnit.SECONDS.sleep(1);
					int x= 1/0;
					notifyChange(new RunnableEvent(RunningState.DONE, Thread.currentThread(),null));

				}catch (Exception ex){
					notifyChange(new RunnableEvent(RunningState.ERROR, Thread.currentThread(),ex));

				}

			}
		},"T"+id).start()	);
	}


	@Override
	public void onEvent(ObservableRunnable.RunnableEvent event) {

		synchronized (LOCK){
			log.info("the Runnalbe {} data changed and state is {}",event.getThread().getName(),event.getState());
			if(event.getCause()!=null){
				log.info("the Runnalbe {} failed ",event.getThread().getName() );

				event.getCause().printStackTrace();
			}
		}
	}
}
