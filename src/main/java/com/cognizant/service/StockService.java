package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Stock;

public interface StockService {

	

	public List<Stock> getComparedStockss(int companyCode1,int companyCode2,String from,String to);
	
    
	public List<Stock> getStocks();

	

}
