package com.lorenzo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ticketupdates")
public class TicketUpdate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tuid")
	private long tuid;
	
	private String ticketUpdate;
	
	@ManyToOne
	@JsonBackReference
	private Ticket ticket;
	
	public TicketUpdate() {
	}

	public TicketUpdate(String update, Ticket ticket) {
		this();
		this.ticketUpdate = update;
		this.ticket = ticket;
	}

	@JsonProperty("tuid")
	public long getTuid() {
		return tuid;
	}
	
	public void setTuid(long tuid) {
		this.tuid = tuid;
	}

	@JsonProperty("update")
	public String getTicketUpdate() {
		return ticketUpdate;
	}

	public void setTicketUpdate(String ticketUpdate) {
		this.ticketUpdate = ticketUpdate;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}
