<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
	<title>Товары</title>
</head>

<body>
	<div class="container">
		<h2>Список товаров</h2>		
		<table class="table table-bordered">
			<tbody>
		      <tr>		      	
			      <th>Номер</th>
			      <th>Название</th>
			      <th>Категория</th>
		          <th>Действия</th>
		      </tr>
		    
			 	<c:forEach var="product" items="${products}">
			 		<tr>
			        	<td>${product.id}</td>	
			         	<td>${product.name}</td>
		          		<td>${product.categoryName}</td>
		          		<td>
			          		<button type="button" class="btn btn-success" onclick="location.href=location.href+'/${product.id}'">
			          			Подробнее 
			          		</button>
		          		</td>	       
			       </tr>
			     </c:forEach>
		     </tbody>
	     </table>
     </div>
</body>
</html>