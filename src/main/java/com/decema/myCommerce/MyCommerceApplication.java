package com.decema.myCommerce;

import com.decema.myCommerce.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MyCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCommerceApplication.class, args);
	}

}
