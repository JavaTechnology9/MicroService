package com.javatechnology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetFlixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetFlixEurekaServerApplication.class, args);
	}

}
