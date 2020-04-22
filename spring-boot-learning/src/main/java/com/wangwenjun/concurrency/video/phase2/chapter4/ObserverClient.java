package com.wangwenjun.concurrency.video.phase2.chapter4;

/**
 * @author liubo
 * @date 2020-04-22 10:26
 * @description
 **/
public class ObserverClient {

	public static void main(String[] args) {
		Subject s = new Subject();

		new BinaryObserver(s);
		new OctalObserver(s);
		new HexObserver(s);

		System.out.println("========");


		s.setState(10);

		System.out.println("===2=====");
		s.setState(10);


		System.out.println("===3=====");
		s.setState(15);

	}
}
