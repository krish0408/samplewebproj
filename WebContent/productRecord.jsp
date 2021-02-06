<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        
   
		<h2 align="center">Product Record</h2>
		<div align="center">
		<table border="2">
		<tr>
		<th>ProductId</th><th>Name</th><th>Price</th><th>Description</th>
		</tr>
		<tr>
		    <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
		    	  
	    </tr>
	   </table>
		</div>
</body>
</html>