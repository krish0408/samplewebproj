package com.mtc.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mtc.vo.Product;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;


public class ProductDAO extends BaseDAO implements IProductDAO{
	
	private static final String insertQuery = "insert into test.product(id,name,price,description,quantity) values(?,?,?,?,?)";
    //1,2,3,4,5
	private static final String SELECT_QUERY = "select * from test.product where id=?";
	private static final String SELECT_ALL_QUERY = "select * from test.product";
	private static final String UPDATE_PRODUCT_SQL = "update test.product set id = ?, name =?, price = ?, description = ?, quantity = ?";
    private static final String DELETE_PRODUCT_SQL = "delete from test.product where id =?";
    
@Override
	public Product add(Product product) throws SQLException{
		Product p = null;	
		
		try (Connection connection = getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1,p.getId());
			preparedStatement.setString(2,p.getName());
			preparedStatement.setFloat(3, p.getPrice());
			preparedStatement.setString(4, p.getDescription());
			preparedStatement.setInt(5,p.getQuantity());
			
			//Step4 : execute the query
			int noOfRows = preparedStatement.executeUpdate();
		
			//Step5 : validating results
			if(noOfRows == 1) {
				System.out.println("Record added successfully");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return p;

	}

	private Product toProduct(ResultSet resultSet) {
		Product product = null;		
	
		try {
			product = new Product();
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getFloat("price"));
			product.setDescription(resultSet.getString("description"));
			product.setQuantity(resultSet.getInt("quantity"));				

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	@Override
	public Product findById(int id) {
		Product product = null;		
		try(Connection connection = getConnection()){			
			//Step2  :  PreparedStatement object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);			
			preparedStatement.setInt(1,id);			
			ResultSet resultSet = preparedStatement.executeQuery();			
			if(resultSet.next()) {
				product = toProduct(resultSet);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return product;
	}

	@Override
	public List<Product> findAll() {
		List<Product> productsList = new ArrayList<Product>();
		
		try(Connection connection = getConnection()){			
			Statement statement = connection.createStatement();			
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);			
			while(resultSet.next()) {
				Product product = new Product();
				product = toProduct(resultSet);
				productsList.add(product);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return productsList;
	}
	
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
    try (Connection connection = getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
			
			preparedStatement.setString(1,product.getName());
			preparedStatement.setFloat(2, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setInt(4,product.getQuantity());
			preparedStatement.setInt(5,product.getId());
			
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("Product was updated successfully!");
			}
		
       }catch (Exception e) {
	    e.printStackTrace();
    }
    }
	
	@Override
	public void delete(int id){
		// TODO Auto-generated method stub
		
try (Connection connection = getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
		
			preparedStatement.setInt(1,id);
			
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Product was deleted successfully!");
			}
	
       }catch (Exception e) {
	    e.printStackTrace();
    }
}	
	
}
	





