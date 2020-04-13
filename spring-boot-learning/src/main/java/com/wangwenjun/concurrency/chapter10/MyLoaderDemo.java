package com.wangwenjun.concurrency.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1.interrupt a thread not means to kill a thread, end its lifecycle
 * just interrupt its blocked status.
 * <p>
 * 2.interrupt will throw a InterruptedException
 **/
@Slf4j
public class MyLoaderDemo extends ClassLoader {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		MyLoader ml = new MyLoader();

		Class<?> sc  = ml.loadClass("java.lang.String");
		log.info("sc loader:{}",sc.getClassLoader());


		Class<?> aClass = ml.loadClass("com.wangwenjun.concurrency.chapter10.HelloWorld");

		log.info("aclass loader:{}",aClass.getClassLoader());

		Object hw = aClass.newInstance();
		log.info("hw={}",hw);

		Method wm = aClass.getMethod("welcome");

		String result =(String) wm.invoke(hw);
		log.info("result={}",result);
	}
}
