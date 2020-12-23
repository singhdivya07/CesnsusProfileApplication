package com.capgemini.census.service;

import java.util.Date;
import java.util.List;

import com.capgemini.census.entity.User;
import com.capgemini.census.exception.UserException;

public interface UserService {
	public User addUser(User user) throws UserException;
	public User updateUser(Integer userId) throws UserException;
	public int deleteMember(Integer userId) throws UserException;

}
