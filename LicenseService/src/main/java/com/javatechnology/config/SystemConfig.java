package com.javatechnology.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component 
public class SystemConfig {
	@Value("${example.property}")
	private String exampleProperty;
	
	public String getProperty() {
		
		return exampleProperty;
	}

}
