package com.kevin.johnes.chapter2;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author liubo
 * @date 2020-04-14 22:37
 * @description
 **/
@Slf4j
public class Delegation {
	public static void main(String[] args) {
		URLClassLoader classLoader =(URLClassLoader) ClassLoader.getSystemClassLoader();

		do{
			System.out.println(classLoader);
//			for(URL url : classLoader.getURLs()){
//				log.info("{}",url.getPath());
//			}
		}while ((classLoader =(URLClassLoader) classLoader.getParent())!=null);

		System.out.println("Bootstrap classloader");
	}
}
