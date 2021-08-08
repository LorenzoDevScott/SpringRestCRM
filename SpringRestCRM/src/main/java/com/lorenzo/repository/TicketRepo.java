package com.lorenzo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lorenzo.models.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long>{
//	This is where I create my custom repositories
	List<Ticket> findByRepairType(String repairType);
}
