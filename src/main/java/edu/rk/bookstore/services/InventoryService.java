package edu.rk.bookstore.services;

import java.util.List;

import edu.rk.bookstore.domain.Inventory;
import edu.rk.bookstore.domain.OrderItem;
import edu.rk.bookstore.exceptions.ProductOutOfStockException;

public interface InventoryService {
	public List<Inventory> getInventory();
	public void updateInventory(List<OrderItem> oiList) throws ProductOutOfStockException;
}
