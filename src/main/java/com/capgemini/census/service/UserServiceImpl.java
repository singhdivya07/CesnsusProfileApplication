package com.capgemini.census.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.census.dao.UserDao;
import com.capgemini.census.entity.User;
import com.capgemini.census.exception.UserException;

@Service(value = "UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	public void addUser(User user) throws UserException {
		try 
		{
			userDao.addUser(user);
			
		} catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
		
	}
	public User updateUser(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	public int deleteMember(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
