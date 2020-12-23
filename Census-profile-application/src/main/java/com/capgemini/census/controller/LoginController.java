package com.capgemini.census.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.census.entity.User;
import com.capgemini.census.exception.UserException;
import com.capgemini.census.service.UserService;

@RestController
@RequestMapping("/api/user")

public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public void addUser(@RequestBody User user) 
	{
		try {
			userService.addUser(user);
		} catch (UserException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/get/")
	public ResponseEntity<List<User>> getAllUserDeatils() {
		try {
			List<User> userList = userService.getAllUserDeatils();
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (UserException e) {
			//log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
