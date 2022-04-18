package com.cognizant.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Stock;
import com.cognizant.service.StockService;

@RestController
@CrossOrigin("*")
public class StockController {

	@Autowired
	private StockService service;

	@GetMapping("/stocks")
	public List<Stock> getAllStocks() {
		return service.getStocks();
	}

	@GetMapping("/stocks/compare-performance/{companyCode1}/{companyCode2}/{from}/{to}")
	public List<Stock> getAllComparedStocks(@PathVariable int companyCode1 ,@PathVariable int companyCode2,@PathVariable String to,@PathVariable String from) {
		return service.getComparedStockss(companyCode1,companyCode2,from,to);
	}

}
