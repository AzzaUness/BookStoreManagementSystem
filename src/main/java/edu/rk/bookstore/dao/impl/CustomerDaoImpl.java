package edu.rk.bookstore.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.rk.bookstore.dao.CustomerDao;
import edu.rk.bookstore.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private CustomerRowMapper customerRowMapper;
	
	@PostConstruct
	public void setup(){
		jdbcTemplate = new JdbcTemplate(dataSource);
		customerRowMapper = new CustomerRowMapper();
	}
	
	
	public List<Customer> getCustomers(){
		String sql = "SELECT * FROM CUSTOMER";
		return jdbcTemplate.query(sql, customerRowMapper);
	}
}
