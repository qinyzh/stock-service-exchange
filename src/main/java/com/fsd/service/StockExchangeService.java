package com.fsd.service;

import com.fsd.domain.StockExchange;
import com.fsd.util.ResponseResult;

public interface StockExchangeService {
	
	ResponseResult findAll();
	ResponseResult findById(Integer id);
	ResponseResult save(StockExchange stockExchange);
    ResponseResult updateStockExchangeById(StockExchange stockExchange);
    ResponseResult deleteStockExchangeById(Integer id);

}
