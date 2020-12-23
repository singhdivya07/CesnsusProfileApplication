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
import com.capgemini.census.repository.UserRepository;


@Service(value = "ApplicationServiceImpl")
@Transactional
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	ApplicationRepository applicationRepositoryImpl;
	@Autowired
	UserRepository userRepository;
	public Application addApplication(Integer id,Application application) throws ApplicationException {
		
		try 
		{
		User user = userRepository.findById(id).get();
		application.setUser(user);
		return applicationRepositoryImpl.save(application);
		

		} catch(PersistenceException e) {
			throw new ApplicationException(e.getMessage(),e);
		}
		
	}



}
