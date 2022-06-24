package com.IPCFeignClient01.App1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application1 {
	public static void main(String[] args) {
		SpringApplication.run(Application1.class, args);
	}
}
