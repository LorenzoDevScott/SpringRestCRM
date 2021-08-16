package com.lorenzo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lorenzo.models.Customer;
import com.lorenzo.models.Ticket;
import com.lorenzo.serviceimplementation.CustomerServiceImpl;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private CustomerServiceImpl customerServ;
	
	@GetMapping("/customers")
	public String ticketsForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}
	
	@PostMapping("/customers")
	  public String greetingSubmit(@ModelAttribute Customer customer, Model model) {
	    model.addAttribute("customer", customer);
	    customerServ.save(customer);
	    return "../static/index";
	  }
	
}
