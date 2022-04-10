package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.BadRequestException;
import com.cognizant.model.User;
import com.cognizant.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path = "/users")
	public User login(@RequestBody User user) throws BadRequestException {
		return userService.loginUser(user);
	}
}
