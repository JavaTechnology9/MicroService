package com.javatechnology.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechnology.service.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, String>{
	public List<License> findByOrganizationId(String organizationId);

}
