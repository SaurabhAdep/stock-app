package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Stock;
import com.cognizant.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> getStocks() {

		return stockRepository.getStocks();

	}

	@Override
	public List<Stock> getComparedStockss(int CompanyCode1, int CompanyCode2, String from, String to) {
		
		return stockRepository.getComparedStocks(CompanyCode1, CompanyCode2, from, to);
	}


}
