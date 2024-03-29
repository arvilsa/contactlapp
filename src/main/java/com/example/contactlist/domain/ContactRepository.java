package com.example.contactlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact>findByLastName(String lastName);

}
