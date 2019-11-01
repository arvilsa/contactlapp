package com.example.contactlist;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.contactlist.domain.Company;
import com.example.contactlist.domain.Contact;
import com.example.contactlist.domain.ContactRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {
	@Autowired
	private ContactRepository repository;
	
	@Test
	public void findByLastnameShouldReturnContact() {
		List<Contact> contacts =repository.findByLastName("Johnson");
		assertThat(contacts).hasSize(1);
		assertThat(contacts.get(0).getFirstName()).isEqualTo("John");
	
		//assertThat(objectToTest). // code completion -> assertions specific to objectToTest
	}
	
	@Test
	public void createNewContact() {
	Contact contact = new Contact("Mickey", "Mouse", "mm@mouse.com", new Company("Disney Corporation"));
	repository.save(contact);
	assertThat(contact.getId()).isNotNull();
	}

}
