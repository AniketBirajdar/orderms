package com.api.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.order.entity.Productsordered;


public interface ProductsOrderedRepo extends JpaRepository<Productsordered, Integer> {
	
	List<Productsordered> findByBuyerid(Integer buyerid);

}