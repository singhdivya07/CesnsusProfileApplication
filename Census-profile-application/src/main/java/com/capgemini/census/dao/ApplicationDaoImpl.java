package com.capgemini.census.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
private UserDao userDao;
	
	public void addApplication(Integer userId,Application application) throws PersistenceException {
		
		User user = new User();
		try {
			
//					user = userDao.getUserById(userId);
//					application.setUser(user);
//		
			entityManager.persist(application);
			entityManager.flush();
		

		} catch (PersistenceException e) {
			
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	// getappbyid();

	public Application getApplicationById(Integer appId) throws PersistenceException {
		
		try {
			Application memberInfo = entityManager.find(Application.class, appId);
			return memberInfo;
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw e;
		} 

	}

}
