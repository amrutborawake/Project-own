package com.stackroute;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.GenericFilterBean;



import com.stackroute.filter.AuthFilter;
@SpringBootApplication
public class MusemanagerApplication {

	public static final String JOBS_PATH = "/api/v1/";  //jobs_path
	public static void main(String[] args) {
		
		SpringApplication.run(MusemanagerApplication.class, args);
		
	}

	    @Bean
	    public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
	        FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
	        filterRegistrationBean.setFilter(new AuthFilter());
	        filterRegistrationBean.addUrlPatterns(JOBS_PATH);
	        return filterRegistrationBean;
	    }
		
	

}
