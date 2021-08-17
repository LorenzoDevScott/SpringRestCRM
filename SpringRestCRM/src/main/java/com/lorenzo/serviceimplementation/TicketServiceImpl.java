package com.lorenzo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzo.models.Ticket;
import com.lorenzo.repository.TicketRepo;
import com.lorenzo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepo ticketRepo;
	
	@Override
	public Ticket findById(Long id) throws Exception {
		return ticketRepo.findById(id).orElseThrow(() -> new Exception("Ticket with ID: " + id + "is not found"));
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepo.save(ticket);
	}
	
	

	@Override
	public void deleteById(Long id) {
		ticketRepo.deleteById(id);
	}

	@Override
	public List<Ticket> findByRepairType(String repairType) {
		return ticketRepo.findByRepairType(repairType);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepo.findAll();
	}
	
	

}
