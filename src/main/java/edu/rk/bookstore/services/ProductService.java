package edu.rk.bookstore.services;

import java.util.List;

import edu.rk.bookstore.domain.Category;
import edu.rk.bookstore.domain.Product;

public interface ProductService {
	public List<Category> getCategories();
	public List<Product> getProducts(int catId);
	public void updatePrice(int prodId, double newPrice);
	public Product getProduct(int prodId);
	public void addNewProduct(Product product);
	public void deleteProduct(int prodId);
}
