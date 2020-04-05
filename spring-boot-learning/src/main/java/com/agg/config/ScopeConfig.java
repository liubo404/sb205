package com.agg.config;


import com.agg.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class ScopeConfig {


	/**
	 * singleton 单实例时，ioc 启动时调用方法创建对象放到ioc中
	 * 以后每次获取就是直接从ioc中拿(map.get())
	 *
	 * @return
	 */
	@Bean("wangwu")
	public Person person02() {
		System.out.println("... 给容器中添加 singleton object ...");
		return new Person("王五", 25);
	}

	/**
	 * 多实例时，ioc启动时并不会创建对象，每次获取对象时才会调用方法创建对象
	 *
	 * @return
	 */
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean("scopedPerson")
	public Person scopedPerson() {
		System.out.println("... 给容器中添加 scopedPerson ...");
		return new Person("scopedPerson", 25);
	}
}
