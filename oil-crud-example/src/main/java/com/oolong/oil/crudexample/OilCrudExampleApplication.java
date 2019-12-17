package com.oolong.oil.crudexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oolong.oil.crudexample.repository.mybatis")
public class OilCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OilCrudExampleApplication.class, args);
	}

}
