package com.example.contactlist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long companyid;
	private String companyName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Contact> contacts;
	
	public Company() {}

	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Company [companyid=" + companyid + ", companyName=" + companyName + ", contacts=" + contacts + "]";
	}
	
	


}
