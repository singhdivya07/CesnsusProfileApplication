package com.capgemini.census.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.census.dao.UserDao;
import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;
import com.capgemini.census.exception.ApplicationException;
import com.capgemini.census.service.ApplicationService;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
		
		@Autowired
		private ApplicationService applicationService;
		@Autowired
		private UserDao userDao;
			
		@PostMapping("/{id}")
		public void addApplication(@PathVariable Integer id,@RequestBody Application application) 
		{
			//user = userDao.getUserById(userId);
			

			try {
				//application.setUser(user);
				applicationService.addApplication(id,application);
			} catch (ApplicationException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		}

}
