package com.lorenzo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lorenzo.models.Customer;
import com.lorenzo.models.Ticket;
import com.lorenzo.repository.CustomerRepo;
import com.lorenzo.serviceimplementation.CustomerServiceImpl;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

@Controller
public class HomeController {

	
	// Services 
	@Autowired
	private CustomerServiceImpl customerServ;
	
	@Autowired
	private TicketServiceImpl ticketServ;
	
	
	// Controller Mappings
	
	// Customer Mappings
	@GetMapping("/customers")
	public String customersForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}
	
	@PostMapping("/customers")
	  public String customerSubmit(@ModelAttribute Customer customer) {
	    customerServ.save(customer);
	    return "redirect:/customers-view";
	  }
	
	@GetMapping("/customers/{id}")
	public String getCustomer(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("customer", customerServ.findById(id));
		return "customerupdate";
	}
	
	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) throws Exception {
		Customer dataCustomer = customerServ.findById(id);
		dataCustomer.setEmail(customer.getEmail());
		dataCustomer.setFirstName(customer.getFirstName());
		dataCustomer.setLastName(customer.getLastName());
		customerServ.save(dataCustomer);
		return "redirect:/customers-view";
	}
	@RequestMapping(value = "/customers/{id}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteCustomer(@PathVariable Long id) {
		customerServ.deleteById(id);
		return "redirect:/customers-view";
	}
	
	@GetMapping("/customers-view")
	public String viewCustomers(Model model) {
		model.addAttribute("customers", customerServ.findAll());
		return "customers-view";
	}
	
	// Ticket Mappings
	
	@GetMapping("/tickets")
	public String ticketsForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticketform";
	}
	
	@PostMapping("/tickets")
	  public String ticketSubmit(@ModelAttribute Ticket ticket) {
	    ticketServ.save(ticket);
	    return "redirect:/tickets-view";
	  }
	
	@GetMapping("/tickets/{id}")
	public String getTicket(@PathVariable Long id, Model model) throws Exception {
		model.addAttribute("ticket", ticketServ.findById(id));
		return "ticketupdate";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute Ticket ticket) throws Exception {
		Ticket dataTicket = ticketServ.findById(id);
		dataTicket.setRepairType(ticket.getRepairType());
		dataTicket.setDescription(ticket.getDescription());
		ticketServ.save(dataTicket);
		return "redirect:/tickets-view";
	}
	@RequestMapping(value = "/tickets/{id}/remove", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteTicket(@PathVariable Long id) {
		ticketServ.deleteById(id);
		return "redirect:/tickets-view";
	}
	
	@GetMapping("/tickets-view")
	public String viewTickets(Model model) {
		model.addAttribute("tickets", ticketServ.findAll());
		return "tickets-view";
	}
}
