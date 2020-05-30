package com.javatechnology.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.javatechnology.service.model.Organization;
@Component
public class RestTemplateClient {
	@Autowired
	private RestTemplate restTemplate;
	
	public Organization getOranization(String organizationId) {
		ResponseEntity<Organization> exchange = restTemplate.exchange("http://organzationservice/v1/organizations/{organizationId}", HttpMethod.GET, null, Organization.class, organizationId);
		return exchange.getBody();
		//http://organzationservice/v1/organizations/
		//http://		192.168.0.7/v1/organization
		
	}

}
