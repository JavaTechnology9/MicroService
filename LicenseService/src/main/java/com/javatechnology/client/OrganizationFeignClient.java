package com.javatechnology.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatechnology.service.model.Organization;

@FeignClient(name="organzationservice")
public interface OrganizationFeignClient {
	@RequestMapping(value="/v1/organizations/{organizationId}",method=RequestMethod.GET)
	Organization getOranization(@PathVariable("organizationId") String  organizationId);

}
