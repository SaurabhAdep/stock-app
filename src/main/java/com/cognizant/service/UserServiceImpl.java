package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.BadRequestException;
import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User loginUser(User user) throws BadRequestException {
		User userExists = userRepository.findUserByEmail(user.getEmail());

		if (userExists == null) {
			throw new BadRequestException("Invalid email!!!");
		}

		String password = user.getPassword();
		if (!password.matches(userExists.getPassword())) {
			throw new BadRequestException("Invalid email and password combination.");
		}
		
		return userExists;
	}



}
