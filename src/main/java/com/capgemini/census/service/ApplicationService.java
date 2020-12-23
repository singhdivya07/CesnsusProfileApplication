package com.capgemini.census.service;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.User;
import com.capgemini.census.exception.ApplicationException;

public interface ApplicationService {
	public void addApplication(User user,Application application) throws ApplicationException;
}
