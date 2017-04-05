<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
/* var app = angular.module('myApp', []);

function MyController($scope, $http) {

	  $scope.sortType     = 'name'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchDeviceName   = '';     // set the default search/filter term

        $scope.getCartItems = function() {
                $http({
                        method : 'GET',
                        url : 'getCartItemsData?cartid=${cartid}'
                }).success(function(data, status, headers, config) {
                        $scope.cartitems = data; alert(data);
                }).error(function(data, status, headers, config) {
                        
                });

        };
}; */

</script>
</head>
<body>
<%@ include file="usernavbar.jsp"%>

<div class="container">
<div class="row" align="right">
 <div class="col-xs-6 col-md-12"> 

 <b>Order Total : ${grandtotal}</b>
 <br>
 <%-- <c:if test="${cartsi==0}">
  Cart is Empty
  </c:if>
  <c:if test="${cartsi>=1}"> --%>
<%--   <b>Order Total : ${grandtotal}</b> --%>
 <c:url value="/order/${customer.cart.cartid}" var="checkout"></c:url>
 <a href="${checkout}" style="color:skyblue" class="btn btn-warning btn-large">Check Out</a>
<%--  </c:if> --%>
 </div>
 </div>
 </div>
 
<div class ="container">
 
 	<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Product</th>
<th style="text-align:center">Supplier</th>
<th style="text-align:center">Quantity</th>
<th style="text-align:center">Price</th>
<th style="text-align:center">Item wise Total</th>
<th style="text-align:center">Option</th>
</tr>
</thead>

<tbody>
<c:forEach var="cartitem" items="${cartitems}">
<tr style="text-align:center;background:rgba(90,90,30,0.7)">

<td style="vertical-align: middle;font-weight:bold;color:yellow">
<c:url value="/resources/images/products/${cartitem.xPS.productid}.jpg" var="a"></c:url>
<img style="border-radius:15px" src="${a}" height="120" width="150" /></td>

<td style="vertical-align: middle;font-weight:bold;color:yellow">
<c:url value="/resources/images/suppliers/${cartitem.xPS.supplierid}.jpg" var="b"></c:url>
<img style="border-radius:15px" src="${b}" height="120" width="150" /></td>

<td style="vertical-align: middle;font-weight:bold;color:yellow">${cartitem.quantity}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${cartitem.xPS.psprice}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${cartitem.itemwisetotal}</td>
<td style="vertical-align: middle;"> 
 <c:url value="/reqDeleteCartItem/${cartitem.cartitemid}" var="url"></c:url>
<a href="${url}" style="color:yellow;font-weight:bold" class="btn btn-warning btn-large">Delete</a>

</td>
</tr>
</c:forEach>
<tr style="text-align:center;background:rgba(90,40,30,0.7)">
<td colspan="4" style="vertical-align: middle;font-weight:bold;color:yellow;font-size: x-large;">Grand Total</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${grandtotal}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow"></td>
</tr>
</tbody>


</table>
 <div class="container">
 <div class="row" align="left">
 <div class="col-xs-6 col-md-12"> 
 
 <c:url value="/reqDeleteCartItems/${customerid}" var="m"></c:url>
 <a href="${m}" style="color:yellow" class="btn btn-warning btn-large">Clear Cart</a>
 </div>
 </div>
 
 </div>
 
 
 </div>
</body>
</html>