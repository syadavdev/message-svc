package com.sandi.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication( scanBasePackages = {"com.sandi.message", "com.sandi.commonsvc"})
@EnableDiscoveryClient
public class MessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}
}
