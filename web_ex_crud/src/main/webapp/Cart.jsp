<%@page import="net.java.dao.WaifuDAO"%>
<%@page import="net.java.model.waifu"%>
<%@page import="net.java.model.BillDetail"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map"%>   
  <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://use.fontawesome.com/b32121c496.js"></script>
  
<title>Insert title here</title>


<style type="text/css">
.card{
 	width: 100%;
    height: 275px;
    object-fit: cover;  
}
.form-inline{
	width: 100%;
    height: 75px;
}
.container{
	text-align: center;
}
.cart-page img {
    width: 100px;
    height: 55px;
    object-fit: cover;
}

.nav-cart{
	margin-left: 705px;
}
.badge {
  padding-left: 9px;
  padding-right: 9px;
  -webkit-border-radius: 9px;
  -moz-border-radius: 9px;
  border-radius: 9px;
}

.label-warning[href],
.badge-warning[href] {
  background-color: #8acfec;
}
#lblCartCount {
    font-size: 12px;
    background: #785ef8;
    color: #fff;
    padding: 0 5px;
    vertical-align: top;
    margin-left: -10px; 
}


.cart-page{
margin: 80px auto;
}
.table{
	width: 75%;
	margin-left: 193px	;
	margin-top: 20px;
	border-collapse: collapse;
	border-spacing: 10px 20px;
}
.top-table{
	text-align: left;
	padding: 5px;
	color: #fff;
	background-color: rgb(80, 80, 80);
	font-weight: normal;	
}
.total-price{
	display: flex;
	justify-content: flex-end;
	margin-right: 190px;
	
}
.total-price table{
	border-top: 3px solid rgb(80, 80, 80);
	width: 100%;
	max-width: 410px;
	max-height: 120px;
}
td:nth-child(2) {
    padding-left: 160px;
}
.btn-checkout{
	color: #fff;
    padding: 10px 25px;
    background :  rgb(80, 80, 80);
    border: 2px rgb(80, 80, 80);
    border-radius: 20px;
    outline: none;
    cursor: pointer;
    margin-left: 1145px;
  	margin-bottom: 50px;
   
}​
</style>
</head>

<body>

		<% 
		 @SuppressWarnings("unchecked")
		Map<Integer, BillDetail> map3 = (Map<Integer, BillDetail>) request.getSession().getAttribute("cart");
		session.setAttribute("w1", map3);
	
		%> 
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <form class="form-inline" method="get">
  <a class="navbar-brand" href="#">
    <img src="data:image/jpeg;base64,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" alt="logo" style="width:40px;">
  </a>	
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="listwaifu" onclick="MovePage()">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="manage" onclick="MovePage()">Manage</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" onclick="MovePage()">Contact</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="login" onclick="MovePage()">Login</a>
    </li>
    <li class="nav-search">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
    </li>
    <li  class="nav-cart">
   <span onclick="cart_click()"> <i class="fa fa-shopping-cart"  style="font-size: 2.75em" aria-hidden="true"></i> </span>
    <a  class='badge badge-warning' id="lblCartCount"> </a>
    </li>
    </ul>
  </form>
</nav>	
	<div class="small-container cart-page">
	<c:set var="total" value="${0}"/>
	<c:set var="trainsportCost" value="${35}"/>
	 <table class="table table-hover w-1250">
			<tr class="top-table">
			<td>Waifu </td>
			<td>Price</td>
			<td>Quantity</td>
			<td>Into Price</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${sessionScope.w1}" var="x">
			<tr>
				
				<td>
				
				 <img src="${x.value.waifu.image}" width="100" />
				 <c:out value="${x.value.waifu.name}"/>
				</td>
				<td>
				<fmt:setLocale value = "en_US"/>
				<fmt:formatNumber value = "${x.value.unitPrice }" type = "currency"/>
				</td>
				<td>
			
	 		 <span  id="QuantiTymiNus" onclick="quantityMinus(${x.key})" > <i class="fa fa-minus"  aria-hidden="true"></i>  </span> 
				<c:out  value="${x.value.quantity }"/>
			 <span  id="QuantiTypLus" onclick="quantityPlus(${x.key})" > <i class="fa fa-plus" aria-hidden="true"> </i> </span>
				</td>
				<td>
				<fmt:setLocale value = "en_US"/>
				<fmt:formatNumber value = "${x.value.quantity * x.value.unitPrice}" type = "currency"/>
				</td>
				<td><a href="DeleteProductFromCart?id=<c:out value='${x.key}'/>" onclick="DeleteProductFromCart_js(${x.value.quantity})">Delete</a></td>
				 <c:set var="total" value="${total + x.value.quantity * x.value.unitPrice}" />
			</tr>
		</c:forEach>
	</table>
	
	
	<div class="total-price">
	<table>
		<tr>
			<td> Subtotal </td>
			
			<td>
				<fmt:setLocale value = "en_US"/>
				<fmt:formatNumber value = "${total}" type = "currency"/>
			 </td>
		</tr>
		<tr>
			<td> VAT tax </td>
			<td> 
			<fmt:setLocale value = "en_US"/>
			<fmt:formatNumber value = "${total*5/100}" type = "currency"/>
			</td>
		</tr>		
		<tr>
			<td> Total </td>
			<td>
			<fmt:setLocale value = "en_US"/>
			<fmt:formatNumber  value = "${total*5/100+total}" type = "currency"/>
			 </td>
		</tr>
	</table>	
	<c:set var="totalOrder" value="${total*5/100+total}" scope="session"/>
	</div>
</div>
		<a href="fCartCheckOut" onclick="btn_checkOut()" class="btn-checkout"> Proceed to checkout</a>
</body>

<script type="text/javascript">

document.getElementById('lblCartCount').innerHTML= localStorage.getItem("CountProductOnCart");

function MovePage() {
	localStorage.setItem("typeOfW", "all");
	localStorage.setItem("typeOfS", "priceUp");
}

function DeleteProductFromCart_js(quantity) {
	var count = localStorage.getItem("CountProductOnCart");
	count =count-quantity;
	localStorage.setItem("CountProductOnCart",count);
}
function quantityMinus(id) {
	var count = localStorage.getItem("CountProductOnCart");
	count =count-1;
	localStorage.setItem("CountProductOnCart",count);
	window.location.href='QuantityMinusFromCart?wID='+id;
	 
}
function quantityPlus(id) {
	var count = localStorage.getItem("CountProductOnCart");
	count++;
	localStorage.setItem("CountProductOnCart",count);
	window.location.href='QuantityPlusFromCart?wID='+id;
	 
}
function btn_checkOut() {
	var total = '${total*5/100+total}';
	localStorage.setItem("totalStorage",total);
}
function cart_click() {
	window.location.href='Cart';
}

</script>















</html>=