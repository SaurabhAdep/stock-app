package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dto.Dto;
import com.cognizant.exception.WatchListNotFoundException;
import com.cognizant.model.Company;
import com.cognizant.model.Stock;
import com.cognizant.service.CompanyService;

@RestController
@CrossOrigin("*")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	
	@GetMapping("/companies")
	public List<Company> getAllCompanies() {
		return service.getAllCompanies();
	}
	
	
	@GetMapping("/watchList/{userId}")
	
	public List<Company> getWatchList(@PathVariable int userId) throws WatchListNotFoundException {
		return service.getWatchList(userId);
	}
	
	
	
	
	
	@PostMapping(path = "/watchList")
	public String addToWatchList(@RequestBody Dto dto) {
		 System.out.println();
		return service.addToWatchList(dto.getUserId(), dto.getCompanyId());
		
	}
	
	
	@DeleteMapping("/delete/{userId}/{companyId}")
	public String deleteFromWatchList(@PathVariable int userId, @PathVariable int companyId) throws WatchListNotFoundException {
		service.deleteFromWatchList(userId,companyId);
		return "Company deleted from watch List successfully...";
	}
	
}
