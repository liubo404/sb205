package com.agg.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author liubo
 * @date 2020-04-06 00:03
 * @description
 **/
public class MyTypeFilter implements TypeFilter {
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

		//当前类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

		//当前类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();

		//当前类的资源信息 （类的路径 ）
		Resource resource = metadataReader.getResource();

		String className = classMetadata.getClassName();
		System.out.println(" ---> className: " + className);

		if (className.contains("oo")) {
			return true;
		}
		return false;
	}
}
