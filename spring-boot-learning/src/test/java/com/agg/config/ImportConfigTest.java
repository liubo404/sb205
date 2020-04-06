package com.agg.config;

import com.agg.CommonTools;
import com.agg.bean.Blue;
import com.agg.bean.RainBow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportConfigTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ImportConfig.class);


		System.out.println("-======ioc init completed==============");


		CommonTools.printBeanNames(context);

		Blue blue = context.getBean(Blue.class);
		System.out.println(blue);

		RainBow rainBow = context.getBean(RainBow.class);
		System.out.println(rainBow);

	}

}