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
	color: #fff;
}
.box-form{
	width: 320px;
	height: 320px;
	top: 0px;
	left:40%;
	position:absolute;
	padding: 80px 30px;
	color: #FFFFFF;
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
	border-bottom: 1px solid #ffffff;
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
<form action="importWaifu" method="get">
<div class="box-form">
 <h3> Import Waifuu  </h3>
 		<input type="text" name="wName" placeholder="Enter Waifu Name">
 		<input type="text" name="wAge" placeholder="Enter Waifu Age">
 		<input type="text" name="wType" placeholder="Enter Waifu Type">
 		<input type="text" name="wPrice" placeholder="Enter Waifu Price">
 		<input type="text" name="wImage" placeholder="Enter Waifu Image URL">
   	<button type="submit"> Save </button>  
   </div>
   </form>
</body>
</html>	