package edu.rk.bookstore.dao;

import java.util.List;

import edu.rk.bookstore.domain.Inventory;
import edu.rk.bookstore.domain.OrderItem;
import edu.rk.bookstore.exceptions.ProductOutOfStockException;

public interface InventoryDao {
	public List<Inventory> getInventory();
	public void updateInventory(List<OrderItem> oiList) throws ProductOutOfStockException;
	
}
