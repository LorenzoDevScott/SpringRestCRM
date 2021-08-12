package com.lorenzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzo.models.PartOrder;

public interface PartOrderRepo extends JpaRepository<PartOrder, Long> {

}
