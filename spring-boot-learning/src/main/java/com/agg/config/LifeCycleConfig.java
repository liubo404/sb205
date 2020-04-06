package com.agg.config;


import com.agg.bean.Car;
import com.agg.bean.Cat;
import com.agg.bean.Dog;
import com.agg.bean.MyBeanPostProcessor;
import com.agg.bean.Sheep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({Cat.class, Dog.class, Sheep.class, MyBeanPostProcessor.class})
public class LifeCycleConfig {

	//	@Scope("prototype")// 容器关闭时不会自动调用销毁方法
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Car car() {

		return new Car();
	}

}
