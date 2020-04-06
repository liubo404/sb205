package com.agg.config;

import com.agg.CommonTools;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanIncludeConfigTest {

	@Test
	public void includeTest() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanIncludeConfig.class);

		CommonTools.printBeanNames(context);
	}


}