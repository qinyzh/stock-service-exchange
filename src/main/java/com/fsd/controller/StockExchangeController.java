package com.fsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.domain.StockExchange;
import com.fsd.service.StockExchangeService;
import com.fsd.util.ResponseResult;

@CrossOrigin
@RestController
@RequestMapping("/stockexchange")
public class StockExchangeController {
	
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@GetMapping("/list")
    public ResponseResult queryStockExchangeAll() {
        return stockExchangeService.findAll();
    }
	
	@GetMapping("/list/{id}")
    public ResponseResult queryStockExchangeById(@PathVariable Integer id){
        return stockExchangeService.findById(id);
    }

    @PostMapping
    public ResponseResult addStockExchange(@RequestBody StockExchange stockExchange){
        return stockExchangeService.save(stockExchange);
    }
    
    @PutMapping
    public ResponseResult editStockExchange(@RequestBody StockExchange stockExchange) {
    	return stockExchangeService.updateStockExchangeById(stockExchange);
    }
	
    @DeleteMapping("/del/{id}")
    public ResponseResult delStockExchange(@PathVariable Integer id) {
    	return stockExchangeService.deleteStockExchangeById(id);
    }

}
