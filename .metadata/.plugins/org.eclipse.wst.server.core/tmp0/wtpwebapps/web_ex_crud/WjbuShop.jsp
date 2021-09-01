<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>List Account</title>
</head>
<body>
	<form action=list method="get">
	<div class="container p-3 my-3 bg-dark text-white">
  		<h1>List Account</h1>
  		<h3> This is the list of account </h3>
	</div>
	<table class="table table-hover">
	<thead>
	<tr>
		<th> ID </th>
		<th> UserName </th>
		<th> PassWord </th>
		<th> Action </th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${listAcc}" var="x">
	<tr>
		<td> ${x.id} </td>
		<td> ${x.taikhoan} </td>
		<td> ${x.matkhau} </td>
	<td> 
		<a href="update?id=<c:out value='${x.id}' />"> Update </a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="delete?id=<c:out value='${x.id}' />"> Delete </a>
	 </td>
	</tr>
	</c:forEach>
	</tbody>
	<a href="wjbu" type="button" class="btn btn-info"> Wjbu Shop</a>
	</table>
	</form>
</body>
</html>