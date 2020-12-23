package com.capgemini.census.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.census.entity.Application;
import com.capgemini.census.entity.MemberInformation;
	
	@Repository
public class MemberInformationDaoImpl implements MemberInformationDao {

		@Autowired
	private ApplicationDao appDao ;
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void addMember(MemberInformation memberInformation,Integer id) throws PersistenceException {
		Application app = new Application();
	
		
		try {
//			System.out.println("before transaction begin");
//			
//			System.out.println("before getting app id");
			app = appDao.getApplicationById(id);
			memberInformation.setApplication(app);
		//	System.out.println("before persisting app id");
			entityManager.persist(memberInformation);
			
			

		} catch (PersistenceException e) {
			
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public MemberInformation searchMemberById(Integer memberId) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(Integer memberId) throws PersistenceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberInformation> searchMemberByFirstName(String firstName) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberInformation> searchMemberByLastName(String lastName) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberInformation> searchMemberByDob(Date dob) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

//	public MemberInformation searchMemberById(Integer memberId) throws PersistenceException {
//
//		EntityManager entityManager = emf.createEntityManager();
//		try {
//			MemberInformation memberInfo = entityManager.find(MemberInformation.class, memberId);
//			return memberInfo;
//		} catch (PersistenceException e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			entityManager.close();
//		}
//
//	}

//	public List<MemberInformation> searchMemberByFirstName(String firstName) throws PersistenceException {
//
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//
//			TypedQuery<MemberInformation> query = entityManager.createQuery(
//					"SELECT c FROM MemberInformation c WHERE c.firstName = :firstName", MemberInformation.class);
//			/**/
//			query.setParameter("firstName", firstName);
//			List<MemberInformation> list=query.getResultList();
//			return list;
//
//		}catch(PersistenceException e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//
//	public List<MemberInformation> searchMemberByLastName(String lastName) throws PersistenceException {
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//
//			TypedQuery<MemberInformation> query = entityManager.createQuery(
//					"SELECT c FROM MemberInformation c WHERE c.lastName = :lastName", MemberInformation.class);
//			/**/
//			query.setParameter("lastName", lastName);
//			List<MemberInformation> list=query.getResultList();
//			return list;
//
//		}catch(PersistenceException e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//	public int deleteMember(Integer memberId) throws PersistenceException {
//		EntityManager entityManager=emf.createEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			MemberInformation memberInformation= 
//					entityManager.find(MemberInformation.class, memberId);
//			entityManager.remove(memberInformation);
//			entityManager.flush();
//			entityManager.getTransaction().commit();	
//			return memberInformation.getMemberId();
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			throw e;
//		}finally {
//			entityManager.close();
//		}	
//	}
//
//	public List<MemberInformation> searchMemberByDob(Date dob) throws PersistenceException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

//
