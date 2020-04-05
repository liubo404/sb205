package com.agg.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//配置类==配置文件
@Configuration //告诉Spring这是一个配置类
@ComponentScan(value = "com.agg",
		useDefaultFilters = false, // includeFilters company with this can availability
		includeFilters = {
				@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
		}
)
public class ComponentScanCustomFilterConfig {


}
