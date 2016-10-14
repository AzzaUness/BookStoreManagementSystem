package edu.rk.bookstore.services;

import edu.rk.bookstore.domain.Order;

public interface TaxService {
	public double computeTax(Order order);
}
