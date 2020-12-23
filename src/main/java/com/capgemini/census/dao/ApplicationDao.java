package com.capgemini.census.dao;

import javax.persistence.PersistenceException;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;

public interface ApplicationDao {
	public void addApplication(Integer userId,Application application) throws PersistenceException ;
	public Application getApplicationById(Integer appId) throws PersistenceException ;
}
