<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
	<title>Ошибка</title>
</head>

<body>
	<div class="container">
		<h2>${product.name}</h2>		
		<table class="table table-bordered">
			<tbody>	       
	        	<tr>
			        <th>Описание</th>
			        <td>${product.description}</td>
	        	</tr>	
	        	<tr>
			        <th>Цена, руб.</th>
			        <td>${product.price}</td>
	        	</tr>	
	        	<tr>
			        <th>Количество, шт.</th>
			        <td>${product.quantity}</td>
	        	</tr>
	        	<tr>
			        <th>Скидка, %</th>
			        <td>${product.discount}</td>
	        	</tr>	
	        	<tr>
			        <th>Категория</th>
			        <td>${product.categoryName}</td>
	        	</tr>				    
		    </tbody>
	     </table>
     </div>
</body>
</html>