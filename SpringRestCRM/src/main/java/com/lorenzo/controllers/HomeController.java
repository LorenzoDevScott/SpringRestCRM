package com.lorenzo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lorenzo.TicketServiceImpl;
import com.lorenzo.models.Ticket;

@RestController
@CrossOrigin("http://localhost:8080/**")
public class HomeController {

	@Autowired
	private TicketServiceImpl ticketServ;
	
	@GetMapping("ticket/{id}")
	public Ticket getTicket(@PathVariable Long id) throws Exception{
		System.out.println(ticketServ.findById(id));
		return ticketServ.findById(id);
	}
	
	
}
