package com.lorenzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzo.models.TicketUpdate;

public interface TicketUpdateRepo extends JpaRepository<TicketUpdate, Long> {

}
