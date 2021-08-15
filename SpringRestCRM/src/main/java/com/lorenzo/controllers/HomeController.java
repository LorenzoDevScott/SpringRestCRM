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

import com.lorenzo.models.Customer;
import com.lorenzo.models.PartOrder;
import com.lorenzo.models.Product;
import com.lorenzo.models.Ticket;
import com.lorenzo.serviceimplementation.CustomerServiceImpl;
import com.lorenzo.serviceimplementation.PartOrderServiceImpl;
import com.lorenzo.serviceimplementation.ProductServiceImpl;
import com.lorenzo.serviceimplementation.TicketServiceImpl;

@RestController
@CrossOrigin("http://localhost:8080/**")
public class HomeController {

	@Autowired
	private TicketServiceImpl ticketServ;
	
	@Autowired
	private CustomerServiceImpl customerServ;
	
	@Autowired 
	private ProductServiceImpl productServ;
	
	@Autowired
	private PartOrderServiceImpl partOrderServ;
	
	// Ticket REST Controls
	
	// Get Ticket By ID
	@GetMapping("data/tickets/{tid}")
	public Ticket getTicket(@PathVariable Long tid) throws Exception{
		System.out.println(ticketServ.findById(tid));
		return ticketServ.findById(tid);
	}
	
    // Get List of Tickets 
	@GetMapping("data/tickets")
	public List<Ticket> findAllTickets() {
		return ticketServ.findAll();
	}
	
	// Get List of Ticket by Repair Type
	@GetMapping("data/tickets/repair-type/{repairType}")
	public List<Ticket> getTickets(@PathVariable String repairType) {
		return ticketServ.findByRepairType(repairType);
	}
	
	// Customer REST Controls
	
	// Get Customer By ID
	@GetMapping("data/customers/{cid}")
	public Customer getCustomer(@PathVariable Long cid) throws Exception {
		System.out.println(customerServ.findById(cid));
		return customerServ.findById(cid);
	}
	
	// Get Customer By Email
	@GetMapping("data/customers/email/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return customerServ.findByEmail(email);
	}
	
	// Get List of Customers
	@GetMapping("data/customers")
	public List<Customer> findAllCustomers() {
		return customerServ.findAll();
	}
	
	// Get List of Customers with Same First Name
	@GetMapping("data/customers/first-name/{firstName}")
	public List<Customer> getCustomersByFirstName(@PathVariable String firstName) {
		return customerServ.findByFirstName(firstName);
	}
	
	// Get List of Customers with Same Last Name
	@GetMapping("data/customers/last-name/{lastName}")
	public List<Customer> getCustomersByLastName(@PathVariable String lastName) {
		return customerServ.findByFirstName(lastName);
	}
	
	// Product REST Controls
	@GetMapping("data/products")
	public List<Product> getProducts() {
		return productServ.findAll();
	}
	
	@GetMapping("data/products/{pid}")
	public Product getProductById(Long pid) throws Exception {
		return productServ.findById(pid);
	}
	
	@GetMapping("data/products/product-name/{productName}")
	public Product getProductByProductName(String productName) {
		return productServ.findByProductName(productName);
	}
	
	// PartOrder REST Controls
	@GetMapping("data/part-orders/{poid}")
	public PartOrder getPartOrderById(@PathVariable Long pid) throws Exception {
		return partOrderServ.findById(pid);
	}
	
	@GetMapping("data/part-orders")
	public List<PartOrder> getPartOrders(){
		return partOrderServ.findAll();
	}
	
	@GetMapping("data/part-orders/part-name/{partName}")
	public PartOrder getPartOrderByPartName(String partName) {
		return partOrderServ.findByPartName(partName);
	}
	
	
	
	
}
