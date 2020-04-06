package com.agg.config;

import com.agg.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author liubo
 * @date 2020-04-07 00:21
 * @description
 **/
//使用PropertySource读取外部配置文件中的k/v保存到运行的环境变量中
//加载完配置文件的值以后，使用${}取出配置文件中的值
@PropertySource("person.properties") // value={"classpath:/person.properties"}
@Configuration
public class PropertyValueConfig {

	@Bean
	public Person person() {
		return new Person();
	}
}
