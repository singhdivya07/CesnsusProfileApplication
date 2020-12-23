package com.capgemini.census.dao;

import javax.persistence.PersistenceException;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;

public interface UserDao {
	public void addUser(User user) throws PersistenceException ;
	public User getUserById(Integer userId) throws PersistenceException ;
}
