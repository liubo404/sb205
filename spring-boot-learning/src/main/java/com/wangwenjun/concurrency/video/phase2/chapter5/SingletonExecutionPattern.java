package com.wangwenjun.concurrency.video.phase2.chapter5;

/**
 * @author liubo
 * @date 2020-04-22 12:03
 * @description
 **/
public class SingletonExecutionPattern  {

	public static void main(String[] args) {
		Gate gate = new Gate();

		User bj  = new User("Bobo","Bejin",gate);
		User sh  = new User("shloar","sh",gate);
		User gz  = new User("gualao","gz",gate);

		bj.start();
		sh.start();
		gz.start();

	}
}
