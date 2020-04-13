package com.wangwenjun.concurrency.chapter10;

import lombok.extern.slf4j.Slf4j;

/**
 *  same loader, different loader instance, load same class
 **/
@Slf4j
public class DifferentLoader   {

	public static void main(String[] args) throws ClassNotFoundException {
		 MyLoader loader1 = new MyLoader("/tmp",null);
		 MyLoader loader2 = new MyLoader("/tmp",null);

		 Class<?> a = loader1.loadClass("com.wangwenjun.concurrency.chapter10.HelloWorld");
		 Class<?> b = loader2.loadClass("com.wangwenjun.concurrency.chapter10.HelloWorld");

		 log.info("a.classLoader={}",a.getClassLoader());
		 log.info("b.classLoader={}",b.getClassLoader());

		 log.info("a.hash={}",a.hashCode());
		 log.info("b.hash={}",b.hashCode());

		 log.info("a==b? :{}", a  == b);

	}
}
