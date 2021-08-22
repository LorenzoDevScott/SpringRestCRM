package com.lorenzo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzo.models.Customer;
import com.lorenzo.models.TicketUpdate;
import com.lorenzo.repository.TicketUpdateRepo;
import com.lorenzo.service.TicketUpdateService;

@Service
public class TicketUpdateServiceImpl implements TicketUpdateService{

	@Autowired
	TicketUpdateRepo ticketUpdateRepo;

	@Override
	public TicketUpdate save(TicketUpdate update) {
		return ticketUpdateRepo.save(update);
	}

	@Override
	public void delete(TicketUpdate update) {
		ticketUpdateRepo.delete(update);
		
	}

	@Override
	public TicketUpdate findById(Long id) throws Exception{
		
		if(ticketUpdateRepo.findById(id).isPresent()) {
			return (TicketUpdate) ticketUpdateRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<TicketUpdate> findAll() {
		return ticketUpdateRepo.findAll();
	}
	
	

}
