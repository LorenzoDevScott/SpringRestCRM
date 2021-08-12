package com.lorenzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lorenzo.models.Customer;
import com.lorenzo.models.PartOrder;
import com.lorenzo.models.Product;
import com.lorenzo.models.Ticket;
import com.lorenzo.serviceimplementation.CustomerServiceImpl;
import com.lorenzo.serviceimplementation.PartOrderServiceImpl;
import com.lorenzo.serviceimplementation.ProductServiceImpl;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

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
	
	@Override
	public void run(String... args) throws Exception {
		ticketServ.save(new Ticket("Screen Repair", "Dropped phone on the concrete"));
		ticketServ.save(new Ticket("Screen Repair", "Tripped and dropped phone on rocks"));
		ticketServ.save(new Ticket("Water Damange", "Accidentally dropped phone in the toilet"));
		ticketServ.save(new Ticket("Water Damage", "Went swimming in lake and forgot phone was in pocket"));
		ticketServ.save(new Ticket("OS Install", "Customer bought a new computer and needs Windows 10 installed"));
		
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
		
		
	}

}
