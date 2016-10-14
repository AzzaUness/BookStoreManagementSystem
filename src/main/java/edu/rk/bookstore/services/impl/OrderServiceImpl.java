package edu.rk.bookstore.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rk.bookstore.dao.OrderDao;
import edu.rk.bookstore.domain.Order;
import edu.rk.bookstore.domain.OrderItem;
import edu.rk.bookstore.domain.Product;
import edu.rk.bookstore.services.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void saveOrder(Order order){
		orderDao.saveOrder(order);
	}
	public int getOrdersCount(){
		return orderDao.getOrdersCount();
	}
	public void addProduct(Order order, Product product, int quantity){
		List<OrderItem> oiList = order.getOiList();
		boolean exist = false;
		for(OrderItem oi: oiList){
			if(!exist && oi.getProduct().getName().equalsIgnoreCase(product.getName())){
				oi.setQuantity(quantity);
				exist = true;
			}
		}
		if(!exist){
			OrderItem oi = new OrderItem();
			oi.setOrderId(order.getCode());
			oi.setProduct(product);
			oi.setQuantity(quantity);
			oiList.add(oi);
		}
	}
}
