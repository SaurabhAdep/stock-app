package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	/*
	 * @Query(value="SELECT * from Stock",nativeQuery=true)
	 * 
	 * public List<Stock> getComparedStocks(String CompanyCode1,String
	 * CompanyCode2,String to,String from);
	 */
	
	@Query(value = "Select * from stock", nativeQuery = true)
	public List<Stock> getStocks();
	
	  @Query(value="SELECT * FROM Stock WHERE price_on_date >= :from AND price_on_date <= :to AND company_id IN (:CompanyCode1 ,:CompanyCode2) order by stock_id",nativeQuery=true)
	  public List<Stock> getComparedStocks(@Param("CompanyCode1") int companyCode1,@Param("CompanyCode2") int companyCode2 , @Param("from") String from,@Param("to") String to);
	 
}
