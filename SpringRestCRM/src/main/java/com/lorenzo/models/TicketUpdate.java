package com.lorenzo.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name="ticketupdates")
public class TicketUpdate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tuid")
	private long tuid;
	
	private String ticketUpdate;
	
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	@ManyToOne
	@JsonBackReference
	private Ticket ticket;
	
	public TicketUpdate() {
	
	}
	
	public TicketUpdate(Ticket ticket) {
		this();
		this.ticket = ticket;
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

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
}
