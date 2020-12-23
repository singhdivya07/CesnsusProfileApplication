package com.capgemini.census.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.census.entity.Application;

public interface UserRepository 
	extends JpaRepository<Application,Integer>{
	
}


