package com.lorenzo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="partorders")
public class PartOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long poid;
	private String partName;
	private double partPrice;
	private long partQuantity;
	
	public PartOrder() {
		
	}
	
	public PartOrder(String partName, double partPrice, long partQuantity) {
		this();
		this.partName = partName;
		this.partPrice = partPrice;
		this.partQuantity = partQuantity;
	}

	@JsonProperty("poid")
	public long getPoid() {
		return poid;
	}
	
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public double getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(double partPrice) {
		this.partPrice = partPrice;
	}
	public long getPartQuantity() {
		return partQuantity;
	}
	public void setPartQuantity(long partQuantity) {
		this.partQuantity = partQuantity;
	}
	
	
	
	
	
	
	

}
