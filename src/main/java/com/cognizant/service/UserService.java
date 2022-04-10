package com.cognizant.service;

import com.cognizant.exception.BadRequestException;
import com.cognizant.model.User;

public interface UserService {
	
	public User loginUser(User user) throws BadRequestException;
}
