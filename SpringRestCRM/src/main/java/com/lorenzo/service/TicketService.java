package com.lorenzo.service;

import java.util.List;

import com.lorenzo.models.Ticket;

public interface TicketService {
	Ticket findById(Long id) throws Exception;
	Ticket save(Ticket ticket);
	List<Ticket> findAll();
	List<Ticket> findByRepairType(String repairType);
}