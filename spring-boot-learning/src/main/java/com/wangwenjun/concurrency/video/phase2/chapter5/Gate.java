package com.wangwenjun.concurrency.video.phase2.chapter5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Gate {
	private int count = 0;
	private String name = "Nobody";
	private String address = "Nowhere";


	public synchronized   void pass(String name, String address) {
		this.count++;
		this.name = name;
		this.address = address;
		log.info("count={}",count);
		check();
	}

	private  void check() {

		if (this.name.charAt(0) != this.address.charAt(0)) {
			System.out.println("-------------BROKEN-------" + checkedString());
		}
	}

	public String checkedString() {
		return "No." + this.count + ":" + this.name + ":" + this.address;
	}
}
