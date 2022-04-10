package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "watchlist")
@Data
@NoArgsConstructor
public class WatchList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int watchId;
	
	@ManyToOne(targetEntity = User.class)
   @JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(targetEntity = Company.class)
	@JoinColumn(name = "company_id")
	private Company company;
	
}
