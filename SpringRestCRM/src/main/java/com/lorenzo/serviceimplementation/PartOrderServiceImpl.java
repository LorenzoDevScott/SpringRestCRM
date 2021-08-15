package com.lorenzo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzo.models.PartOrder;
import com.lorenzo.repository.PartOrderRepo;
import com.lorenzo.service.PartOrderService;

@Service
public class PartOrderServiceImpl implements PartOrderService{
	
	@Autowired
	private PartOrderRepo partOrderRepo;

	@Override
	public PartOrder findById(Long id) throws Exception {
		return partOrderRepo.findById(id).orElseThrow(() -> new Exception("Part Order with ID: " + id + "is not found"));
	}

	@Override
	public PartOrder save(PartOrder partOrder) {
		return partOrderRepo.save(partOrder);
	}

	@Override
	public PartOrder findByPartName(String partName) {
		return partOrderRepo.findByPartName(partName);
	}

	@Override
	public List<PartOrder> findAll() {
		return partOrderRepo.findAll();
	}
	
	

}
