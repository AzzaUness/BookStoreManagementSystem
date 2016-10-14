package edu.rk.bookstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rk.bookstore.dao.CustomerDao;
import edu.rk.bookstore.domain.Customer;
import edu.rk.bookstore.services.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	public List<Customer> getCustomers(){
		return customerDao.getCustomers();
	}

}
