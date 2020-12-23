package com.capgemini.census.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.census.dao.ApplicationDao;
import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;
import com.capgemini.census.exception.ApplicationException;
import com.capgemini.census.repository.ApplicationRepository;


@Service(value = "ApplicationServiceImpl")
@Transactional
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	ApplicationRepository applicationRepositoryImpl;

	
	public void addApplication(User user,Application application) throws ApplicationException {
		try 
		{
		application.setUser(user);
			applicationRepositoryImpl.save(application);
			
		} catch(PersistenceException e) {
			throw new ApplicationException(e.getMessage(),e);
		}
		
	}



}
