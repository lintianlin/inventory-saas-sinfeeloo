package com.sinfeeloo.inventory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sinfeeloo.inventory.mapper")
public class BasicinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicinfoApplication.class, args);
	}
}
