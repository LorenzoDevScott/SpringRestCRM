package com.lorenzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lorenzo.models.Ticket;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private TicketServiceImpl ticketServ;
	
	@Override
	public void run(String... args) throws Exception {
		ticketServ.save(new Ticket("Screen Repair", "Dropped phone on the concrete"));
		ticketServ.save(new Ticket("Screen Repair", "Tripped and dropped phone on rocks"));
		ticketServ.save(new Ticket("Water Damange", "Accidentally dropped phone in the toilet"));
		ticketServ.save(new Ticket("Water Damage", "Went swimming in lake and forgot phone was in pocket"));
		ticketServ.save(new Ticket("OS Install", "Customer bought a new computer and needs Windows 10 installed"));
	}

}
