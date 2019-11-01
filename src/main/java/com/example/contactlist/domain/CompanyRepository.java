package com.example.contactlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long>{
	List<Company> findByCompanyName(String companyName);
}
