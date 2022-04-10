package com.cognizant.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.model.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList, Integer> {

	@Query(value = "Select watch_id from watchlist where user_id = :userId AND company_id = :companyId", nativeQuery = true)
	public int findWatchId(int userId, int companyId);
	
	
	@Modifying
	@Transactional
	@Query(value = "Insert into watchlist(user_id,company_id) values(:userId, :companyId)", nativeQuery = true)
	public int addCompanyToWatchList(@Param("userId") int userId, @Param("companyId") int companyId);

}
