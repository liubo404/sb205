package com.wangwenjun.concurrency.video.phase2.chapter5;

/**
 * @author liubo
 * @date 2020-04-22 12:03
 * @description
 **/
public class User extends Thread {

	private final String name;
	private final String address;

	private final Gate gate;

	public User(String name, String address, Gate gate) {
		this.name = name;
		this.address = address;
		this.gate = gate;
	}

	@Override
	public void run() {
		System.out.println(name + " BEGIN..");
		while (true) {
			this.gate.pass(name, address);
		}
	}
}
