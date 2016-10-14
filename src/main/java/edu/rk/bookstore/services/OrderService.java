package edu.rk.bookstore.services;

import edu.rk.bookstore.domain.Order;
import edu.rk.bookstore.domain.Product;

public interface OrderService {
	public void saveOrder(Order order);
	public int getOrdersCount();
	public void addProduct(Order order, Product product, int quantity);
}
