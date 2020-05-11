package com.fsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.domain.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Long>{
	
	StockExchange findById(Integer id);	
	void deleteById(Integer id);
}
