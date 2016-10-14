package edu.rk.bookstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rk.bookstore.dao.InventoryDao;
import edu.rk.bookstore.domain.Inventory;
import edu.rk.bookstore.domain.OrderItem;
import edu.rk.bookstore.exceptions.ProductOutOfStockException;
import edu.rk.bookstore.services.InventoryService;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	InventoryDao inventoryDao;

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	public List<Inventory> getInventory() {
		return inventoryDao.getInventory();
	}

	public void updateInventory(List<OrderItem> oiList) throws ProductOutOfStockException {
		inventoryDao.updateInventory(oiList);
	}
}
