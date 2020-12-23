package com.capgemini.census.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import com.capgemini.census.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addUser(User user) throws PersistenceException {
		
		try {
			
			entityManager.persist(user);
			entityManager.flush();
			

		} catch (PersistenceException e) {
			
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public User getUserById(Integer userId) throws PersistenceException {
		
		try {
			User user = entityManager.find(User.class, userId);
			return user;
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw e;
		} 

	}
}
