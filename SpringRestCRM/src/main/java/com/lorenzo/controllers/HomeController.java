package com.lorenzo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzo.models.Ticket;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

@RestController
@CrossOrigin("http://localhost:8080/**")
public class HomeController {

	@Autowired
	private TicketServiceImpl ticketServ;
	
	// Get Ticket By ID
	@GetMapping("data/tickets/{id}")
	public Ticket getTicket(@PathVariable Long id) throws Exception{
		System.out.println(ticketServ.findById(id));
		return ticketServ.findById(id);
	}
	
	
    // Get List of Tickets 
	@GetMapping("data/tickets/")
	public List<Ticket> findAll() {
		return ticketServ.findAll();
	}
	
	// Get List of Ticket by Repair Type
	@GetMapping("data/tickets/{repairType}")
	public List<Ticket> getTickets(@PathVariable String repairType) {
		return ticketServ.findByRepairType(repairType);
	}
	
	
	
	
}
