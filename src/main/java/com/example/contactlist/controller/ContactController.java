package com.example.contactlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.contactlist.domain.CompanyRepository;
import com.example.contactlist.domain.Contact;
import com.example.contactlist.domain.ContactRepository;

@Controller
public class ContactController {
	
	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private CompanyRepository crepository; 
	
	
    //Show all contacts
	@GetMapping(value= "/contactlist")
    public String contactList(Model model) {	
        model.addAttribute("contacts", repository.findAll());
        return "contactlist";
    }
    
    @RequestMapping(value = "/add")
    public String addContact(Model model){
    	model.addAttribute("contact", new Contact());
    	model.addAttribute("companies", crepository.findAll());
        return "addcontact";
    } 
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Contact contact){
        repository.save(contact);
        return "redirect:contactlist";
    } 
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Long contactId, Model model) {
    	repository.deleteById(contactId);
        return "redirect:../contactlist";
    } 
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editcontact(@PathVariable("id") Long contactId, Model model) {	
        model.addAttribute("contact", repository.findById(contactId));
        model.addAttribute("companies", crepository.findAll());
        return "editcontact";
    }
    
	// RESTful service to get all contacts
    @RequestMapping(value="/contacts", method = RequestMethod.GET)
    public @ResponseBody List<Contact> contactListRest() {	
        return (List<Contact>) repository.findAll();
        //palauttaa JSON listan
    }  
    
	// RESTful service to get contacts by id
    @RequestMapping(value="/contact/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Contact> findContactRest(@PathVariable("id") Long contactId) {	
    	return repository.findById(contactId);
    
    } 





	

}
