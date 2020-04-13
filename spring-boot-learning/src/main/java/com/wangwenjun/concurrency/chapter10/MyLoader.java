package com.wangwenjun.concurrency.chapter10;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
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
public class MyLoader extends ClassLoader {

	private final static Path DEFAULT_CLASS_DIR = Paths.get("/tmp");

	private final Path classDir;

	public MyLoader( ) {
		super();
		this.classDir = DEFAULT_CLASS_DIR;
	}
	public MyLoader(String  classDir) {
		super();
		this.classDir = Paths.get( classDir);
	}

	public MyLoader(String  classDir,ClassLoader parent) {
		super(parent);
		this.classDir = Paths.get( classDir);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		byte[] classBytes = this.readClassBytes(name);
		if(classBytes==null || classBytes.length==0){
			throw  new ClassNotFoundException("Cannot load class:"+name);
		}

		return this.defineClass(name,classBytes,0,classBytes.length);
	}

	private byte[] readClassBytes(String name) throws ClassNotFoundException {

		String classPath = name.replace(".","/");
		Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));

		if(!classFullPath.toFile().exists()){
			throw new ClassNotFoundException("The class "+ name + " not found.");
		}

		try(ByteArrayOutputStream bao = new ByteArrayOutputStream()){
			Files.copy(classFullPath,bao);
			return bao.toByteArray();

		}catch (Exception ex){
			throw new ClassNotFoundException("load the class "+ name + " occur error.");
		}

	}

	@Override
	public String toString() {
		return "My classLoader";
	}
}
