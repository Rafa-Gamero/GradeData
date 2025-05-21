package com.lab.grades.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GradesDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradesDataServiceApplication.class, args);
	}

}
