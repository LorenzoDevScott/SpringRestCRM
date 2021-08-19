package com.lorenzo.service;

import java.util.List;

import com.lorenzo.models.PartOrder;

public interface PartOrderService {
	PartOrder findById(Long id) throws Exception;
	PartOrder save(PartOrder partOrder);
	void deleteById(Long id);
	PartOrder findByPartName(String partName);
	List<PartOrder> findAll();
}
