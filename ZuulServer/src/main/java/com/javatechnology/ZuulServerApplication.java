package com.javatechnology;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.javatechnology.utils.UserContextInteceptor;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		RestTemplate template= new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
		if(interceptors==null) {
			template.setInterceptors(Collections.singletonList(new UserContextInteceptor()));
		}else {
			interceptors.add(new UserContextInteceptor());
			template.setInterceptors(interceptors);
		}
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

}
