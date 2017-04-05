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

<%-- ${xpsdata} --%>

<table border="2" class="table table-stripped fixed_headers">
<thead>
<tr>
<th>Product Image</th>
<th>Product Name</th>
<th>Supplier Image</th>
<th>Supplier Name</th>
<th>XPS ID</th>
<th>Price</th>
<th>Stock</th>
<th>Is Available</th>
<th>Options</th>
</tr>
</thead>
<tbody>
<c:forEach var="xps" items="${xpsdata}">
<tr>
<td><img src="resources/images/products/${xps.productid}.jpg" height="200" width="200"></td>


<td style="vertical-align: middle;font-weight:bold;color:yellow">
<c:forEach var="prd" items="${products}">
<c:if test = "${prd.productid==xps.productid}">
   ${prd.productname}
</c:if>
</c:forEach>
</td>
<td><img src="resources/images/suppliers/${xps.supplierid}.jpg" height="200" width="200"></td>
<td>
<c:forEach var="sup" items="${suppliers}">
<c:if test = "${sup.supplierid==xps.supplierid}">
   ${sup.suppliername}
</c:if>
</c:forEach></td>
<td>${xps.psid}</td>
<td>${xps.psprice}</td>
<td>${xps.psstock}</td>
<td>${xps.ispsavailable}</td>
<td><a href="reqEditProdSuppPage?psid=${xps.psid}"><span class="glyphicon glyphicon-pencil"></span> </a> / <a href="reqDeleteProdSupp?psid=${xps.psid}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>