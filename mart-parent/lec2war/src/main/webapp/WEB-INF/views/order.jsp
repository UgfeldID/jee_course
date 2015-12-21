<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
	<title>Заказ</title>
</head>

<body>
	<div class="container">
		<h2>Заказ № ${order.id}</h2>
		<table class="table table-bordered">
			<tbody>
				
			    <tr>		      	
				    <th>Номер</th>
				    <th>Название товара</th>
				    <th>Количество</th>
			        <th>Цена</th>
		           	<th>Скидка</th>
			    </tr>
			      
			    <c:forEach var="item" items="${order.orderItems}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.quantity}</td>
						<td>${item.price}</td>
						<td>${item.discount}</td>
					</tr>			      
			    </c:forEach>
	    	</tbody>
		</table>
	</div>
</body>
</html>