package edu.rk.bookstore.services;

import edu.rk.bookstore.domain.Order;
import edu.rk.bookstore.exceptions.ProductOutOfStockException;

public interface BillingService {
	public void computeTotalPrice(Order order);
	public void processCustomerPurchase(Order order) throws ProductOutOfStockException;
}
