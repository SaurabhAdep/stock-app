package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.WatchListNotFoundException;
import com.cognizant.model.Company;
import com.cognizant.model.WatchList;
import com.cognizant.repository.CompanyRepository;
import com.cognizant.repository.WatchListRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private WatchListRepository watchRepo;
	
	
	@Override
	public List<Company> getAllCompanies() {
		log.info("start");
		List<Company> companies = companyRepo.findAll();
		log.info("End");
		return companies;
	}

	@Override
	public List<Company> getWatchList(int userId) throws WatchListNotFoundException {
		log.info("start");
		return companyRepo.getWatchList(userId);
	}
	
	

   
    

	@Transactional
	public String deleteFromWatchList(int userId, int companyId) throws WatchListNotFoundException {
		log.info("start");
		int watchId = watchRepo.findWatchId(userId, companyId);
		Optional<WatchList> watchObj = watchRepo.findById(watchId);
		
		if(!watchObj.isPresent()) {
			throw new WatchListNotFoundException("Watch List with the id "+ watchId +" doesn't exist");
		} 
		else {
			watchRepo.deleteById(watchId);
			log.debug("deleted successfully {}", watchObj.get());
		}
		log.info("End");
		return watchId + " deleted successfully....";
	}

	

	@Override
	public String addToWatchList(int userId, int companyId) {
    	watchRepo.addCompanyToWatchList(userId, companyId);
		return "Company added to watch List successfully...";
	}
	
	

	
	

}
