<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="gUpdate" method="get">
	<h1> Update  </h1>
 	<table style="with: 100%">
 	<tr>
     <td>ID</td>
     <td><input type="text" name="id" value="${acc.id}" readonly  ></td>
    </tr>
 	<tr>
     <td>UserName</td>
     <td><input type="text" name="username" value="${acc.taikhoan}"  ></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password"  name="password" value="${acc.matkhau}"  ></td>
    </tr>
   </table>
   	<input type="submit" class="btn btn-success" value="Save" />
   </form>
   
</body>
</html>