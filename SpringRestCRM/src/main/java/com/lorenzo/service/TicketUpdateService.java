package com.lorenzo.service;

import java.util.List;

import com.lorenzo.models.TicketUpdate;

public interface TicketUpdateService {
	TicketUpdate save(TicketUpdate update);
	void delete(TicketUpdate update);
	TicketUpdate findById(Long id) throws Exception;
	List<TicketUpdate> findAll();
}
