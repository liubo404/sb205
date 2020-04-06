package com.agg.config;


import com.agg.bean.Color;
import com.agg.bean.MyImportRegistrar;
import com.agg.bean.MyImportSelector;
import com.agg.bean.Shape;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({Color.class, Shape.class, MyImportSelector.class, MyImportRegistrar.class})
public class ImportConfig {


}
