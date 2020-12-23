package com.capgemini.census.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;

public interface ApplicationRepository 
	extends JpaRepository<Application,Integer>{

	
}
