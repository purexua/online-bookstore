package com.purexua.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc  //json数据处理,必须使用此注解,因为他会加入json处理器
@Configuration
@ComponentScan(basePackages = "com.purexua.controller")

//WebMvcConfigurer springMvc进行组件配置的规范,配置组件,提供各种方法!
public class SpringMvcConfig implements WebMvcConfigurer {
}
