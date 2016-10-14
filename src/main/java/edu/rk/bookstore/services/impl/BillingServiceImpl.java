package edu.rk.bookstore.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.rk.bookstore.domain.Order;
import edu.rk.bookstore.exceptions.ProductOutOfStockException;
import edu.rk.bookstore.services.BillingService;
import edu.rk.bookstore.services.InventoryService;
import edu.rk.bookstore.services.OrderService;
import edu.rk.bookstore.services.TaxService;

@Service("billingService")
public class BillingServiceImpl implements BillingService {

	@Autowired
	private TaxService taxService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private InventoryService inventoryService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	public void computeTotalPrice(Order order){
		double totalTax = order.getSubtotal() * taxService.computeTax(order)/100;
		order.setTax(totalTax);
		order.setTotal(order.getSubtotal() + totalTax);
	}
	@Transactional(readOnly=false, rollbackForClassName="ProductOutOfStockException")
	public void processCustomerPurchase(Order order) throws ProductOutOfStockException{
		orderService.saveOrder(order);
		inventoryService.updateInventory(order.getOiList());
	}
}
