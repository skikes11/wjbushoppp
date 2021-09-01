<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style>
body{
	background-image :url("https://wallpaperaccess.com/full/2109.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	font-family: sans-serif;
}
.box-form{
	width: 320px;
	height: 320px;
	top: 0px;
	left:40%;
	position:absolute;
	padding: 80px 30px;
	color: #fff;
	box-sizing: border-box;
}
h3{
	text-align: center;
	margin-bottom: 40px;
	color: #fff;
}


.box-form input {
	width: 100%;
	margin-bottom: 20px;
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
}
.box-form button {
	color: #fbfcfd;
    padding: 10px 25px;
    background : transparent;
    border: 2px solid #fff;
    border-radius: 20px;
    outline: none;
    cursor: pointer;
    margin:  7px;
   	margin-left: 155px;
}

</style>
<title>Insert title here</title>
</head>
<body>
<form action="updateWaifu" method="get">
<div class="box-form">
<table style="with: 100%">
 <h3> Update Waifuu  </h3>
 	<tr>
     <td>ID: &nbsp;&nbsp;</td>
     <td>
     <input type="text" name="wId" value="${w.id}" readonly >
     </td>
    </tr>
    <tr>
     <td>Name: &nbsp;&nbsp;</td>
     <td>
     <input type="text" name="wName" value="${w.name}"  >
     </td>
    </tr>
    <tr>
     <td>Age: &nbsp;&nbsp;</td>
     <td>
     <input type="text" name="wAge" value="${w.age}" >
     </td>
    </tr>
     <td>Type: &nbsp;&nbsp;</td>
     <td>
     <input type="text" name="wType" value="${w.type}" >
     </td>
    </tr>
    <tr>
     <td>Price: &nbsp;&nbsp;</td>
     <td>
     <input type="text" name="wPrice" value="${w.price}" >
     </td>
    </tr>
    <tr>
     <td>URL Image: &nbsp;&nbsp;</td>
     <td>
     <input type="text" name="wImage" value="${w.image}" >
     </td>
    </tr> 
    </table>
   	<button type="submit"> Save </button>  
   </form>
</body>
</html>	