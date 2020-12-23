package com.capgemini.census.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.census.dao.UserDao;
import com.capgemini.census.entity.User;
import com.capgemini.census.exception.UserException;
import com.capgemini.census.repository.UserRepository;

@Service(value = "UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userDao;
	public User addUser(User user) throws UserException {
		try 
		{
			return userDao.save(user);
			
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
	@Override
	public List<User> getAllUserDeatils() throws UserException {
		
			try {
				List<User> productList=
						userDao.findAll();
				return productList;
			}catch(DataAccessException e) {
				throw new UserException(e.getMessage(),e);
			}catch(Exception e) {
				throw new UserException(e.getMessage(),e);
			}
		
	}
	

}
