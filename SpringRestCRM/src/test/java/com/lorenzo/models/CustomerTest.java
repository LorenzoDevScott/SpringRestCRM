package com.lorenzo.models;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CustomerTest {
	
	@Mock
	private Ticket ticket;
	
	@Test
	void createCustomer() {
		Customer customer = new Customer();
		Assertions.assertNotNull(customer);
	}
	
	@Test
	void setCustomerFirstName() {
		Customer customer = new Customer();
		String firstName = "John";
		customer.setFirstName(firstName);
		Assertions.assertEquals(firstName, customer.getFirstName());
	}
	
	@Test
	void setCustomerLastName() {
		Customer customer = new Customer();
		String lastName = "Wayne";
		customer.setLastName(lastName);
		Assertions.assertEquals(lastName, customer.getLastName());
	}
	
	@Test
	void setCustomerEmail() {
		Customer customer = new Customer();
		String email = "jwayne@email.com";
		customer.setEmail(email);
		Assertions.assertEquals(email, customer.getEmail());
	}
	
	@Test
	void setCustomerTickets() {
		Customer customer = new Customer();
		customer.getTickets().add(ticket);
		Assertions.assertEquals(1, customer.getTickets().size());
	}
	
	@Test
	void setCustomerListTickets() {
		Customer customer = new Customer();
		
		ArrayList<Ticket> ticketsArray = new ArrayList<>();
		Ticket ticket1 = new Ticket();
		Ticket ticket2 = new Ticket();
		ticket1.setRepairType("Cracked Screen");
		ticket2.setRepairType("Water Damage");
		ticketsArray.add(ticket1);
		ticketsArray.add(ticket2);
		
		customer.setTickets(ticketsArray);
		
		Assertions.assertEquals(ticketsArray.size(), customer.getTickets().size());
	}

}
