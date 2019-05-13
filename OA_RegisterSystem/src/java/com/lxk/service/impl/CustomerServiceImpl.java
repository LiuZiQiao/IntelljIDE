package com.lxk.service.impl;

import com.lxk.dao.CustomerDao;
import com.lxk.dao.impl.CustomerDaoImpl;
import com.lxk.domain.Customer;
import com.lxk.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	public void regist(Customer customer) {
		customerDao.save(customer);
	}
	public Customer login(String email, String phoneNumber) {
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		return customerDao.uniqueResult(customer);
	}
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}
	public Customer findCustomerByActiveCode(String activeCode) {
		Customer customer = new Customer();
		customer.setActiveCode(activeCode);
		return customerDao.uniqueResult(customer);
	}
	
}
