package com.mtc.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.dao.IProductDAO;
import com.mtc.dao.ProductDAO;
import com.mtc.vo.Product;

/**
 * Servlet implementation class AllProductsServlet
 */
@WebServlet("/allproducts")
public class AllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        IProductDAO productDAO = new ProductDAO();
		List<Product> products = productDAO.findAll();
	
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 align='center'>Product Record</h2>");
		out.println("<div align=center><table border=2>");	
		out.println("<tr>");
			out.print("<th>ProductId</th><th>Name</th><th>Price</th><th>Description</th>");
		out.println("</tr>");
		for (Product product : products) {
			out.println("<tr>");
			out.println("<td>"+product.getId()+"</td>");
			out.println("<td>"+product.getName()+"</td>");
			out.println("<td>"+product.getPrice()+"</td>");
			out.println("<td>"+product.getDescription()+"</td>");
		    out.println("</tr>");			
		}
		
		out.println("</table></div>");
		out.println("</body></html>");
		
	
	}

}
