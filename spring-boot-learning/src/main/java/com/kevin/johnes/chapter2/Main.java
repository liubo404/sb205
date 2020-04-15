package com.kevin.johnes.chapter2;

import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@Slf4j
public class Main {

	public static void main(String[] args) {

		URL url;
		try {

			url = new URL("file:///tmp/a.jar");


			URLClassLoader ucl = new URLClassLoader(new URL[]{url});
			Class clazz = ucl.loadClass("com.mantiso.Quote");
			Object o = clazz.newInstance();

			System.out.println(o.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
