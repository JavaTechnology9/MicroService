package com.javatechnology.service.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class License {
	@Id
	private String id;
	@Column
	private String organizationId;
	@Column
	private String productName;
	@Column
	private String licenseType;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="License_organization",joinColumns = {@JoinColumn(name="id")},
	inverseJoinColumns= {@JoinColumn(name="Organization_id")})
	private Set<Organization> Organization;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public License withOrganizationId(String organizationId) {
		this.setOrganizationId(organizationId);
		return this;
	}
	public License withId(String id) {
		this.setId(id);
		return this;
	}
	public License withProductName(String productName) {
		this.setProductName(productName);
		return this;
	}
	
	public Set<Organization> getOrganization() {
		return Organization;
	}
	public void setOrganization(Set<Organization> organization) {
		Organization = organization;
	}
	public License withLicenseType(String licenseType) {
		this.setLicenseType(licenseType);
		return this;
	}
	
	
	
}
