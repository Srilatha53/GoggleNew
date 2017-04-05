<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="usernavbar.jsp" %>

<c:forEach items="${ordrs}" var="order">

<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold;">
<tr style="background:rgba(60,60,40,1);color:pink;table-layout: fixed;">
<td style="text-align:center">Order Id : ${order.orderid}</td>
<td style="text-align:center">Order Date : ${order.orderDate}</td>
<td style="text-align:center">Shipped Address : ${order.shippedaddress}</td>

</tr>
</table>
</div>
<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold">
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Product</th>
<th style="text-align:center">Supplier</th>
<th style="text-align:center">Price</th>
<th style="text-align:center">Quantity</th>
<th style="text-align:center">Review</th>

</tr>
</thead>
<c:forEach items="${order.userOrdersHistory}" var="orderhistory">
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<c:url value="/resources/images/products/${orderhistory.productid}.jpg" var="url"></c:url>
<td style="text-align:center;vertical-align: middle;font-weight:bold;color:yellow"><img src="${url}" height="70" width="100" style="border-radius:15px"/> </td>
<c:url value="/resources/images/suppliers/${orderhistory.supplierid}.jpg" var="url"></c:url>
<td style="text-align:center;vertical-align: middle;font-weight:bold;color:yellow"> <img src="${url}" height="70" width="100" style="border-radius:15px"/></td>
<td style="text-align:center;vertical-align: middle;font-weight:bold;color:yellow"> ${orderhistory.price} </td>
<td style="text-align:center;vertical-align: middle;font-weight:bold;color:yellow"> ${orderhistory.quantity} </td>
	<c:if test="${orderhistory.reviewgiven==false}">
		<td style="text-align:center;vertical-align: middle;font-weight:bold;color:yellow"> 
		Rate product
		<c:url value="reqAddProductRating/${orderhistory.productid}" var="url"></c:url>
		<form action="${url}">
			 <select name="rating" id="qty"  style="color:red">
      	<option value="1" style="color:red">1</option>
      	<option value="2" style="color:red">2</option>
      	<option value="3" style="color:red">3</option>
      	<option value="4" style="color:red">4</option>
      	<option value="5" style="color:red">5</option>
      		
      	</select>
    <input type="submit" value="Rate">
		</form> 
		</td>
	</c:if>
	<c:if test="${orderhistory.reviewgiven==true}">
		<td style="text-align:center;vertical-align: middle;font-weight:bold;color:yellow"> Already rated </td>
	</c:if>


</tr>


</c:forEach>


</table>

</div>


</c:forEach>

</body>
</html>