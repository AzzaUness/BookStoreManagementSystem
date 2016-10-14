package edu.rk.bookstore.dao;

import edu.rk.bookstore.domain.Order;

public interface OrderDao {

	public void saveOrder(Order order);
	public int getOrdersCount();
}
