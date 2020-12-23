package com.capgemini.census.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.MemberInformation;


public interface MemberInformationDao {
	
	public void addMember(MemberInformation memberInformation,Integer id) throws PersistenceException;
	public MemberInformation searchMemberById(Integer memberId) throws PersistenceException ;
	//Search Operations
	
	public int deleteMember(Integer memberId) throws PersistenceException;
			
			//by firstName
			public List<MemberInformation> searchMemberByFirstName(String firstName) throws PersistenceException;
			
			//by lastName
			public List<MemberInformation> searchMemberByLastName(String lastName) throws PersistenceException;
			
			//by DOB
			public List<MemberInformation> searchMemberByDob(Date dob) throws PersistenceException;

}
