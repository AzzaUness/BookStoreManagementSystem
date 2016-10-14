package edu.rk.bookstore.test.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.rk.bookstore.domain.Customer;
import edu.rk.bookstore.domain.Order;
import edu.rk.bookstore.domain.OrderItem;
import edu.rk.bookstore.domain.Product;
import edu.rk.bookstore.exceptions.ProductOutOfStockException;
import edu.rk.bookstore.exceptions.ProductRuntimeException;
import edu.rk.bookstore.services.BillingService;

@ContextConfiguration("classpath:bookstore-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BillingServiceTest {
	@Autowired
	private BillingService billingService;
	private Order order;
	private OrderItem orderItem;
	private Product product;
	private List<OrderItem> oiList;
	private Customer cust;
	
	@Before
	public void init() {
		product = new Product();
		product.setCatId(1);
		product.setPrice(19.25);
		product.setProdId(1);
		orderItem = new OrderItem();
		orderItem.setProduct(product);
		orderItem.setQuantity(0);
		oiList = new ArrayList<OrderItem>();
		oiList.add(orderItem);
		product.setCatId(1);
		product.setPrice(99.50);
		product.setProdId(2);
		orderItem = new OrderItem();
		orderItem.setProduct(product);
		orderItem.setQuantity(10);
		oiList.add(orderItem);
		order = new Order();
		order.setOiList(oiList);
		cust = new Customer();
		cust.setId(1);
		cust.setName("JOHN");
		cust.setState("CA");
		order.setCustomer(cust);
		order.setSubtotal(202.54);
		order.setTax(22.5);
		order.setTotal(1200.98);
	}
	
	/* Verifies that ZERO product quantity in an order is not acceptable  */
	@Test(expected=ProductRuntimeException.class) 
	public void testZeroQuantityProduct() throws ProductRuntimeException, ProductOutOfStockException {
		billingService.processCustomerPurchase(order);
	}
	
	/* Verifies that a product cannot be ordered more than its availability  */
	@Test(expected=ProductOutOfStockException.class) 
	public void testOrderMoreThanProductAvailability() throws ProductOutOfStockException {
		order.getOiList().get(0).setQuantity(70);
		billingService.processCustomerPurchase(order);
	}
	
}
