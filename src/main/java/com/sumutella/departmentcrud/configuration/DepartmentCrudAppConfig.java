package com.sumutella.departmentcrud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author sumutella
 * @time 1:33 PM
 * @since 11/12/2019, Tue
 */


@Configuration
@EnableWebMvc  //annotation driven. formatting, conversion, ...
@ComponentScan(basePackages = "com.sumutella.departmentcrud")
public class DepartmentCrudAppConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver1 = new InternalResourceViewResolver();
        viewResolver1.setPrefix("/WEB-INF/view/");
        viewResolver1.setSuffix(".jsp");
        return viewResolver1;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

    }


}
