package com.lorenzo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tid;
	private String repairType;
	private String description;
	
	public Ticket() {
		super();
	}

	public Ticket(String repairType, String description) {
		super();
		this.repairType = repairType;
		this.description = description;
	}
	
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
}
