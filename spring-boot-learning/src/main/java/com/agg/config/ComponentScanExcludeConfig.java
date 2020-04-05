package com.agg.config;


import com.agg.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration //告诉Spring这是一个配置类
@ComponentScan(value = "com.agg", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})
public class ComponentScanExcludeConfig {

	@Bean//给容器中注册一个bean,类型为返回值的类型，默认方法名作为id
	public Person person() {
		return new Person("李四", 20);
	}


	@Bean("another")
	public Person person02() {
		return new Person("张三", 21);
	}

}
