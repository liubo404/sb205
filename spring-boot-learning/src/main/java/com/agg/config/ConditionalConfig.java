package com.agg.config;


import com.agg.bean.Person;
import com.agg.config.condition.LInuxCondition;
import com.agg.config.condition.MacOsCondition;
import com.agg.config.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Conditional 按照一定条件进行判断，满足条件给容器中注册Bean
 */
@Configuration
public class ConditionalConfig {


	/**
	 * add VM options: -Dos.name=Windows
	 * @return
	 */
	@Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person01() {
		return new Person("Bill Gates", 65);
	}

	@Conditional(LInuxCondition.class)
	@Bean("linus")
	public Person person02() {
		return new Person("Linus", 50);
	}

	@Conditional(MacOsCondition.class)
	@Bean("jobs")
	public Person person03() {
		return new Person("Steve Jobs", 55);
	}

}
