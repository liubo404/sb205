package com.wangwenjun.concurrency.video.phase2.chapter4;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


@Slf4j
public class Subject {

	List<MyObserver> observerList = new ArrayList<>();

	private int state;

	public void setState(int state) {
		if(state !=this.state){

		}
		this.state = state;
		notifyAllObservers();
	}

	public int getState() {
		return state;
	}

	public void attatch(MyObserver observer){
		observerList.add(observer);
	}

	public void notifyAllObservers(){

		observerList.stream().forEach(MyObserver::update);
	}

}
