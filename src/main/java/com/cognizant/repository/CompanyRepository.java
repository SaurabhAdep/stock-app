package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.exception.WatchListNotFoundException;
import com.cognizant.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	@Query(value = "Select c.company_id,c.company_name,c.description,c.market_price,c.price_on_date from company c Join watchlist w ON w.company_id = c.company_id AND w.user_id = :userId", nativeQuery = true)
	public List<Company> getWatchList(int userId) throws WatchListNotFoundException;
	
	@Query(value = "Select * from company", nativeQuery = true)
	public List<Company> getStocks();
}










