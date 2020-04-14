package com.wangwenjun.concurrency.video;


public class SOF {

	private static int counter = 0;

	public static void main(String[] args) {

		try {
			add(0);
		}catch (Error ex){
			ex.printStackTrace();
			System.out.println("counter="+counter);
		}
	}

	private static void add(int i) {
		++counter;
		add(i + 1);

	}
}
