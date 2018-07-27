package com.grand.enoteboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author GrandX
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.grand.enoteboot.dao")
public class EnoteBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnoteBootApplication.class, args);
	}
}
