package com.wangwenjun.concurrency.video.phase2.chapter1;


import java.util.stream.IntStream;

/**
 * enum
 */
public class Singleton7 {


	private Singleton7() {

	}

	private   enum  InstanceEnum{
		INSTANCE;

		private   Singleton7 instance;

		InstanceEnum(){
			instance = new Singleton7();
		}
		public Singleton7 getInstance(){
			return instance;
		}


	}


	public static  Singleton7 getInstance() {
		return InstanceEnum.INSTANCE.getInstance();
	}

	public static void main(String[] args) {
		IntStream.rangeClosed(1,100).forEach(x->{
			new Thread(String.valueOf(x)){
				@Override
				public void run() {
					System.out.println(Singleton7.getInstance());
				}
			};
		});
	}
}
