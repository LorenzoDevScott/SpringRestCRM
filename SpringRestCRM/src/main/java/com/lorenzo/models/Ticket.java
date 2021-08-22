package com.lorenzo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tid;
	private String repairType;
	private String description;
	
	// One Ticket can have many updates
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TicketUpdate> updates;
	
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	
	public Ticket() {

	}

	public Ticket(String repairType, String description, Customer customer) {
		this();
		this.repairType = repairType;
		this.description = description;
		this.customer = customer;
		this.updates = new ArrayList<>();
	}
	
	@JsonProperty("tid")
	public long getId() {
		return tid;
	}
	
	public String getRepairType() {
		return repairType;
	}
	
	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<TicketUpdate> getUpdates() {
		return updates;
	}

	public void setUpdates(List<TicketUpdate> updates) {
		this.updates = updates;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
