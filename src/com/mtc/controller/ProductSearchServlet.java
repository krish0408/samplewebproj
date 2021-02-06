package com.mtc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.dao.ProductDAO;
import com.mtc.vo.Product;


/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/searchproduct")
public class ProductSearchServlet extends HttpServlet {

	private static final String SELECT_QUERY = "select * from test.product where id=?";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pid = Integer.parseInt(request.getParameter("productId"));
		
		try {
			
			ProductDAO productDAO = new ProductDAO();
			Product product = productDAO.findById(pid);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("productRecord.jsp");
			//adding data to the scope object                    
			                    // name     object ref
			request.setAttribute("product", product);
			requestDispatcher.forward(request, response);
		
		/*PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 align='center'>Product Record</h2>");
		out.println("<div align=center><table border=2>");
		out.println("<tr>");
			out.print("<th>ProductId</th><th>Name</th><th>Price</th><th>Description</th>");
		out.println("</tr>");
		out.println("<tr>");
			out.println("<td>"+product.getId()+"</td>");
			out.println("<td>"+product.getName()+"</td>");
			out.println("<td>"+product.getPrice()+"</td>");
			out.println("<td>"+product.getDescription()+"</td>");
		out.println("</tr>");
		out.println("</table></div>");
		out.println("</body></html>");*/
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public static Product findById(int id) throws ClassNotFoundException {
//
//		Product product = null;
//		
//		//load the drivers
//		Class.forName("com.mysql.cj.jdbc.Driver");
//	
//		
//		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root@123")){
//			
//			//Step2  :  PreparedStatement object
//			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
//			
//			preparedStatement.setInt(1,id);
//			
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				product = new Product();
//				product.setId(resultSet.getInt("id"));
//				product.setName(resultSet.getString("name"));
//				product.setPrice(resultSet.getFloat("price"));
//				product.setDescription(resultSet.getString("description"));
//				product.setQuantity(resultSet.getInt("quantity"));
//				
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return product;
//	}


}
