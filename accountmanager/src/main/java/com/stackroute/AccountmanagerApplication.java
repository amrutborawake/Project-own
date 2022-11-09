package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.GenericFilterBean;

import com.stackroute.filter.AuthFilter;


@SpringBootApplication
public class AccountmanagerApplication {
	
	//Providing user path
	public static final String User_PATH = "/api/admin/";

	public static void main(String[] args) {
		SpringApplication.run(AccountmanagerApplication.class, args);
		

		
		
	}
	

    @Bean
    public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
        FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new AuthFilter()); //calling auth filter
        filterRegistrationBean.addUrlPatterns(User_PATH);
        return filterRegistrationBean;
    }
	

}
