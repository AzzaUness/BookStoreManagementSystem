package edu.rk.bookstore.dao;

import java.util.List;

import edu.rk.bookstore.domain.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
}
