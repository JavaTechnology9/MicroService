package com.javatechnology.service.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Organization")
public class Organization {
	@Id
	private String Organization_id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String contactNumber;
	@ManyToMany(mappedBy = "Organization")
	private Set<License> license;
	
	
	public Set<License> getLicense() {
		return license;
	}
	public void setLicense(Set<License> license) {
		this.license = license;
	}
	public String getId() {
		return Organization_id;
	}
	public void setId(String id) {
		this.Organization_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
