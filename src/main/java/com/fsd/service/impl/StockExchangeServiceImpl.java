package com.fsd.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsd.domain.StockExchange;
import com.fsd.repository.StockExchangeRepository;
import com.fsd.service.StockExchangeService;
import com.fsd.util.ResponseCode;
import com.fsd.util.ResponseResult;

@Service
@Transactional
public class StockExchangeServiceImpl implements StockExchangeService{
	
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@Override
	public ResponseResult findAll() {
		try {
			List<StockExchange> list = this.stockExchangeRepository.findAll();
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", list);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
	}

	@Override
	public ResponseResult findById(Integer id) {
		// TODO Auto-generated method stub
		try {
			StockExchange stockExchange = this.stockExchangeRepository.findById(id);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", stockExchange);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        } 
	}

	@Override
	public ResponseResult save(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		try {
			StockExchange _stockExchange = this.stockExchangeRepository.save(stockExchange);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!", _stockExchange);
        } catch (Exception e) {
            return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
        
	}

	@Override
	public ResponseResult updateStockExchangeById(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		try {
			StockExchange oldExchange = this.stockExchangeRepository.findById(stockExchange.getId());
			oldExchange.setStockexchange(stockExchange.getStockexchange());
			oldExchange.setContactaddress(stockExchange.getContactaddress());
			oldExchange.setBrief(stockExchange.getBrief());
			oldExchange.setRemarks(stockExchange.getRemarks());
            this.stockExchangeRepository.save(oldExchange);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
        	return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
	}

	@Override
	public ResponseResult deleteStockExchangeById(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.stockExchangeRepository.deleteById(id);
            return ResponseResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
        	return ResponseResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
	}
	

}
