package com.lorenzo.service;

import com.lorenzo.models.PartOrder;

public interface PartOrderService {
	PartOrder findById(Long id) throws Exception;
	PartOrder save(PartOrder partOrder);
}
