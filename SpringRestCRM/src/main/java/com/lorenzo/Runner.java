package com.lorenzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lorenzo.models.Customer;
import com.lorenzo.models.PartOrder;
import com.lorenzo.models.Product;
import com.lorenzo.models.Ticket;
import com.lorenzo.models.TicketUpdate;
import com.lorenzo.serviceimplementation.CustomerServiceImpl;
import com.lorenzo.serviceimplementation.PartOrderServiceImpl;
import com.lorenzo.serviceimplementation.ProductServiceImpl;
import com.lorenzo.serviceimplementation.TicketServiceImpl;
import com.lorenzo.serviceimplementation.TicketUpdateServiceImpl;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private TicketServiceImpl ticketServ;
	
	@Autowired
	private CustomerServiceImpl customerServ;
	
	@Autowired
	private PartOrderServiceImpl partOrderServ;
	
	@Autowired
	private ProductServiceImpl productServ;
	
	@Autowired
	private TicketUpdateServiceImpl ticketUpdateServ;
	
	@Override
	public void run(String... args) throws Exception {
		
		Customer customer = new Customer("Mary","Jay","mjay@gmail.com");
		
		// Create the ticket
		Ticket ticket = new Ticket("Screen Repair", "Droped phone on some rocks", customer);
		Ticket ticket2 = new Ticket("Water Damage", "Phone slipped out of sweater pocket into toilet", customer);
		
		// Create updates
		TicketUpdate update1 = new TicketUpdate("Diagnosed the phone and realized the camera is also broken", ticket);
		ticket.getUpdates().add(update1);
//		ticketServ.save(ticket);
		
		TicketUpdate update2 = new TicketUpdate("Opened the phone and found corrosion on multiple componenets", ticket2);
		ticket2.getUpdates().add(update2);
//		ticketServ.save(ticket2);
		customer.getTickets().add(ticket);
		customer.getTickets().add(ticket2);
		customerServ.save(customer);
		
		
		customerServ.save(new Customer("John","Doe","johnd@gmail.com"));
		customerServ.save(new Customer("Jane","Dawson","janed@gmail.com"));
		customerServ.save(new Customer("Riley","Hurst","rhurst@gmail.com"));
		customerServ.save(new Customer("Lenny","Kravitz","lkravitz@gmail.com"));
		customerServ.save(new Customer("Abigail","Taylor","ataylor@gmail.com"));
		
		partOrderServ.save(new PartOrder("iPhone 12 LCD", 129.99 ,10));
		partOrderServ.save(new PartOrder("iPhone 13 LCD", 141.99 ,67));
		partOrderServ.save(new PartOrder("iPhone 11 LCD", 81.99 ,10));
		partOrderServ.save(new PartOrder("iPad Air 2020 LCD", 159.99 ,20));
		partOrderServ.save(new PartOrder("iPhone 12 Battery", 49.99 ,17));
		
		productServ.save(new Product("iPhone 12", 899.99 ,10));
		productServ.save(new Product("iPhone 13", 999.99 ,27));
		productServ.save(new Product("iPad M1 2021", 1099.99 ,159));
		productServ.save(new Product("MacBook Pro M2 2021", 1499.99 ,120));
		
		ticketServ.save(new Ticket("Screen Repair", "Dropped phone on the concrete", customerServ.findById((long) 1)));
		ticketServ.save(new Ticket("Screen Repair", "Tripped and dropped phone on rocks", customerServ.findById((long) 2)));
		ticketServ.save(new Ticket("Water Damage", "Accidentally dropped phone in the toilet", customerServ.findById((long) 1)));
		ticketServ.save(new Ticket("Water Damage", "Went swimming in lake and forgot phone was in pocket", customerServ.findById((long) 3)));
		ticketServ.save(new Ticket("OS Install", "Customer bought a new computer and needs Windows 10 installed", customerServ.findById((long) 4)));
		
		
	}

}
