package com.lorenzo.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	private String description;
	
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
