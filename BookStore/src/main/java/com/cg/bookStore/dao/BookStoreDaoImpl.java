package com.cg.bookStore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CustomerInformation;

@Repository
public class BookStoreDaoImpl implements BookStoreDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CustomerInformation viewCustomer(String email) {
		
		return em.find(CustomerInformation.class,email);
	}

	@Override
	public Admin viewAdmin(String email) {
		
		return em.find(Admin.class, email);
	}
	
	@Override
	public boolean saveCustomer(CustomerInformation customer) {
		em.persist(customer);
		return true;
	

}
    

	@Override
	public boolean checkAdminByEmail(String email) {
			String checkquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
			TypedQuery<String> query=em.createQuery(checkquery,String.class).setParameter("email",email);
			try {
				
				query.getSingleResult();
				
			} catch(Exception exception) {
				
				return false;
			}
			
			return true;
		}

	@Override
	public boolean saveAdmin(Admin admin) {
		em.persist(admin);
		return true;
	}

	@Override
	public Long getMaxCustomerID() {
		String jpql = "select max(customerId) from CustomerInformation";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		
		return query.getSingleResult();
	}

	@Override
	public Long getMaxAdminID() {
		String jpql = "select max(adminId) from Admin";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		
		return query.getSingleResult();
	}

	@Override
	public boolean checkCustomerByEmail(String email) {
		
		String checkquery="Select customer.email FROM CustomerInformation customer WHERE customer.email= :email";
		TypedQuery<String> query=em.createQuery(checkquery,String.class).setParameter("email",email);
		try {
			
			query.getSingleResult();
			
		} catch(Exception exception) {
			
			return false;
		}
		
		return true;
		
	}


	
	
}
