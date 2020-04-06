package com.agg.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liubo
 * @date 2020-04-06 17:16
 * @description
 **/
public class MyImportSelector implements ImportSelector {
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {



		return new String[]{"com.agg.bean.Blue","com.agg.bean.Yellow"};
	}
}
