package com.agg.config;


import com.agg.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//配置类==配置文件
@Configuration //告诉Spring这是一个配置类
@ComponentScan(value = "com.agg")
public class MainConfig {

	@Bean//给容器中注册一个bean,类型为返回值的类型，默认方法名作为id
	public Person person() {
		return new Person("李四", 20);
	}


	@Bean("another")
	public Person person02() {
		return new Person("张三", 21);
	}

}
