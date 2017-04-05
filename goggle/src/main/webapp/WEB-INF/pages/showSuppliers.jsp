<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
    <%@ include file="links.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});

</script>
<style>

body { 
    background-size: contain;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;
    background-size: 100% 100%;    
}

</style>
</head>
<body background="resources/images/backgrounds/background${imagenum}.jpg">
<%@ include file="usernavbar.jsp" %>

<br><br><br><br>

<div class="container style="style="background:rgba(60,60,90,0)">
<div class="row">
<div class="col-sm-2" style="background-color:transparent; border-style:none" ></div>
<div class="col-sm-5"  style="background-color:transparent; border-style:none;word-wrap: break-word;background:rgba(60,60,90,0);color:yellow">

<img src="resources/images/products/${productid}.jpg" height="400" width="450" style="border-radius:15px"/>

</div>
<div class="col-sm-3"  style="background:rgba(60,60,90,0);color:yellow; border-style:none;vertical-align:middle;word-wrap: break-word" >
<b style="font-size:20px; font-style:bold">
${productname}</b> </div>

<div class="col-sm-2" style="background-color:transparent; border-style:none" ></div>

</div>


<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>
<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Supplier Name</th>
<th style="text-align:center">Price</th>
<th style="text-align:center">Stock</th>
<th></th>
</tr>
</thead>
<tbody>

<c:forEach var="prd" items="${products}">
<tr style="text-align:center;background:rgba(90,90,30,0.7)">
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.suppliername}</td>
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.psprice}</td>
 <c:if test="${prd.psstock >= 5}">
<td style="vertical-align: middle;font-weight:bold;color:yellow">${prd.psstock}</td>
</c:if>
<c:if test="${prd.psstock < 5}">
<td style="vertical-align: middle;font-weight:bold;color:yellow">Out of Stock</td>
</c:if>

 <c:if test="${prd.psstock >= 5}">
 <td>
  <form action="reqAddItemToCart/${prd.psid}">
		  <select name="qty" id="qty"  style="color:red">
      	<option value="1" style="color:red">1</option>
      	<option value="2" style="color:red">2</option>
      	<option value="3" style="color:red">3</option>
      	<option value="4" style="color:red">4</option>
      	<option value="5" style="color:red">5</option>
      		
      	</select>
		<button type="submit" class="btn btn-warning btn-large"> 
         <span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
         </button>  
		  </form>
 </td>
 </c:if>
 
 <c:if test="${prd.psstock < 5}">
 <td style="font-weight:bold;color:yellow">Will be available soon</td>
 </c:if>
 


</tr>
</c:forEach>
</tbody>
</table>

</div>

</div>
</body>
</html>