package com.example.contactlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.contactlist.domain.Company;
import com.example.contactlist.domain.CompanyRepository;
import com.example.contactlist.domain.Contact;
import com.example.contactlist.domain.ContactRepository;
import com.example.contactlist.domain.User;
import com.example.contactlist.domain.UserRepository;

@SpringBootApplication
public class ContactlistApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ContactlistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContactlistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository urepository, ContactRepository repository, CompanyRepository crepository) {
	return (args) -> {
		// Code to add some test data
		User user1= new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
	
		log.info("save a couple of contacts");
		crepository.save(new Company("Yhtiö Oy"));
		crepository.save(new Company("Ab Firma Oy"));
		
		repository.save(new Contact("John", "Johnson", "jj@mail.com", crepository.findByCompanyName("Ab Firma Oy").get(0)));
		repository.save(new Contact("Jaska", "Jokunen", "jaska@mail.com", crepository.findByCompanyName("Ab Firma Oy").get(0)));
	
		
		log.info("fetch all contacts");
		for (Contact contact : repository.findAll()) {
			log.info(contact.toString());
		}

	};
	}
	

}
