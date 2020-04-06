package com.agg.config;


import com.agg.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 单实例bean, 默认在容器启动时创建对象
 * 懒加载： 容器启动时不创建对象，第一次使用（获取）Bean时创建对象,并初始化
 */
@Configuration
public class LazyInitConfig {

	@Lazy
	@Bean
	public Person person() {
		System.out.println(".1...add Person instance to IOC....");
		return new Person("李四", 20);
	}


}
