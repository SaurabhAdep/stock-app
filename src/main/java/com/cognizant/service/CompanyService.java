package com.cognizant.service;

import java.util.List;

import com.cognizant.exception.WatchListNotFoundException;
import com.cognizant.model.Company;


public interface CompanyService {
	
	public List<Company> getAllCompanies();
	
	public List<Company> getWatchList(int userId) throws WatchListNotFoundException;
	
	public List<Company> getStocks();
	
	public String addToWatchList(int userId,int companyId);
	
	
	public String deleteFromWatchList(int userId, int companyId) throws WatchListNotFoundException;
}
