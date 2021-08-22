package com.lorenzo.serviceimplementation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lorenzo.models.Customer;
import com.lorenzo.models.Ticket;
import com.lorenzo.repository.CustomerRepo;
import com.lorenzo.repository.TicketRepo;
import com.lorenzo.service.TicketService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TicketServiceImplTest {

	@Autowired
	private TicketServiceImpl ticketServImpl;
	
	@Autowired
	private CustomerServiceImpl customerServImpl;
	
	@Test
	void testFindById() throws Exception {
		Customer customer = new Customer();
		customerServImpl.save(customer);
		
		Ticket ticket = new Ticket("Screen Repair", "Dropped phone on pavement", customer);
		ticketServImpl.save(ticket);
		
		long id = ticket.getId();
		Ticket foundTicket = ticketServImpl.findById(id);
		assertEquals(ticket.getId(), foundTicket.getId());
	}
	
//	@Test
//	void testFindByRepairType() {
//		Customer customer2 = new Customer();
//		Customer customer3 = new Customer();
//		Ticket ticket1 = new Ticket("Screen Repair", "Dropped phone on cement", customer2);
//		Ticket ticket2 = new Ticket("Water Damage", "Dropped phone inside pool", customer3);
//		
//		ticketServImpl.save(ticket1);
//		ticketServImpl.save(ticket2);
//
//		List<Ticket> tickets = ticketServImpl.findByRepairType("Screen Repair");
//		Assertions.assertThat(tickets.size()).isEqualTo(2);
//	}
	
	
	
	
	
	

}
