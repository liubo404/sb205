package com.wangwenjun.concurrency.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1.interrupt a thread not means to kill a thread, end its lifecycle
 * just interrupt its blocked status.
 * <p>
 * 2.interrupt will throw a InterruptedException
 **/
@Slf4j
public class NameSpace  {

	public static void main(String[] args) throws ClassNotFoundException {
		 ClassLoader cl = NameSpace.class.getClassLoader();

		 log.info("cl={}",cl);

		 Class<?> a = cl.loadClass("com.wangwenjun.concurrency.chapter10.Test");
		 Class<?> b = cl.loadClass("com.wangwenjun.concurrency.chapter10.Test");

		 log.info("a.hashCode={}",a);
		 log.info("b.hashCode={}",b);

		 log.info("a==b?{}",a==b);
	}
}
