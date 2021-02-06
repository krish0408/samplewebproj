package com.mtc.dao;

import java.sql.SQLException;
import java.util.List;

import com.mtc.vo.Product;

public interface IProductDAO {
	
	Product add(Product product) throws SQLException;
	Product findById(int id);
	List<Product> findAll();
	void update(Product product) throws SQLException;
	void delete(int id);
	
}
