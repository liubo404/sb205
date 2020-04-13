package com.wangwenjun.concurrency.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Properties;

/**
 * 1.interrupt a thread not means to kill a thread, end its lifecycle
 * just interrupt its blocked status.
 * <p>
 * 2.interrupt will throw a InterruptedException
 **/
@Slf4j
public class MainLoader {

	public static void main(String[] args) {


		log.info("Bootstrap ={}", String.class.getClassLoader());

		log.info("sun.boot.class.path={}", System.getProperty("sun.boot.class.path"));

		log.info("===========1.bootsrtap================");
		String[] paths = System.getProperty("sun.boot.class.path").split(":");
		Arrays.asList(paths).stream().forEach(log::info);

		log.info("============2.ext=========");
		String[] extJars = System.getProperty("java.ext.dirs").split(":");
		Arrays.asList(extJars).stream().forEach(log::info);

		log.info("============3.system AppClassLoader=========");
		log.info("this.loader={}", MainLoader.class.getClassLoader());
		log.info("system={}", System.getProperty("java.class.path"));
		String[] appJars = System.getProperty("java.class.path").split(":");
		Arrays.asList(appJars).stream().forEach(log::info);

		log.info("=======4.properties======");
		Properties p = System.getProperties();
		log.info("p_names={}", p.stringPropertyNames());
		p.stringPropertyNames().stream().filter(x->x.startsWith("java")).forEach(log::info);


	}

}
