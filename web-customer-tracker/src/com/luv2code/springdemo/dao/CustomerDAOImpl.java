package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		
		//get the current hibernate session
		Session currentSession =sessionFactory.getCurrentSession();
		
		
		// create a query 
		
		Query<Customer> theQuery=currentSession.createQuery("from Customer",Customer.class);
		
		// execute query and get result list 
		
		List<Customer> customer =theQuery.getResultList();
		
		
		// return the results 
		
		return customer;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
    
		//get the current hibernate session 
		
		
		Session currentSession =sessionFactory.getCurrentSession();
		
		// save the customer .. 
		
		currentSession.save(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		

		//get the current hibernate session 
		
		
		Session currentSession =sessionFactory.getCurrentSession();
		
		
		//now retrive /read from data base  using the primary key 
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	
}
