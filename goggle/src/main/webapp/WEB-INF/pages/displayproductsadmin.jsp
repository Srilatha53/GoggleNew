 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
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
</head>
<body>
<%@ include file="adminnavbar.jsp" %>

<%-- Display products admin
 ${products}  --%>
<table border ="2" class="table table-stripped fixed_headers">
<thead>
<tr>
<th>Product Id</th>
<th>Image</th>
<th>Product Name</th>
<th>Product Desc</th>
<th>Is Available</th>
<th>Options</th>
</tr>
</thead>
<tbody>
<c:forEach var="prd" items="${products}">
<tr>
<td>${prd.productid}</td>
<td><img src="resources/images/products/${prd.productid}.jpg" height="200" width="200"/></td>
<td>${prd.productname}</td>
<td><pre>${prd.productdesc}</pre></td>
<td>${prd.isproductavailable}</td>
<td><a href="reqEditProductPage?pid=${prd.productid}"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;/
&nbsp;<a href="reqDeleteProduct?pid=${prd.productid}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>