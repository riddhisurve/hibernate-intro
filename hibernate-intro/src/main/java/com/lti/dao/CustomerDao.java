package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {
	
	public void add(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			//Step 1. Create/Obtain EntityManagerFactory object
			//During this step, META-INF/persistence.xml file will be read
			//oracleTest is same as the persistence-unit name in persistence.xml file 
			emf=Persistence.createEntityManagerFactory("oracleTest");
			
			//Step 2. Create/Obtain EntityManager object
			//This step is similar to opening a  connection in regular jdbc code.
			em=emf.createEntityManager();
			
			//Step 3. Start/Participate in a transaction
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			
			//Now we c an perform insert/update/select operations
			em.persist(customer);
			
			tx.commit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			//below code should be in finally block
			emf.close();
			em.close();
		}
	}

	public void update(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			
			tx.begin();
			em.merge(customer);
			tx.commit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			//below code should be in finally block
			emf.close();
			em.close();
		}
	}

	public Customer fetchById(int id) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			
			Customer c = em.find(Customer.class,id);
			return c;
		}
		finally {
			//below code should be in finally block
			emf.close();
			em.close();
		}
		
	}

	public Customer fetchByEmail(String email, String password) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			
			EntityTransaction tx=em.getTransaction();
			
			String query = "select c from Customer c where c.email=:em and c.password = :pwd";
			Query q = em.createQuery(query);
			q.setParameter("em", email);
			q.setParameter("pwd", password);
		
			Customer c = (Customer) q.getSingleResult();
			return c;
		}
		finally {
			//below code should be in finally block
			emf.close();
			em.close();
		}		
	}
	
	public List<Customer> fetchByCity(String city) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			
			EntityTransaction tx=em.getTransaction();
			
			String query = "select c from Customer c where c.city=:em";
			Query q = em.createQuery(query);
			q.setParameter("em", city);
		
			List<Customer> list = q.getResultList();
			return list;
		}
		finally {
			//below code should be in finally block
			emf.close();
			em.close();
		}
	}
	
}
