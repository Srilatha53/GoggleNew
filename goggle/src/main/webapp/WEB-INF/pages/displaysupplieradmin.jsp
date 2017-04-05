<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
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

Display supplier Admin
<%--  ${suppliers}  --%>
<table border ="2" class="table table-stripped fixed_headers">
<thead>
<tr>
<th>Supplier Id</th>
<th>Image</th>
<th>Supplier Name</th>
<th>Supplier Desc</th>
<th>Is Available</th>
<th>Options</th>
</tr>
</thead>
<tbody>
<c:forEach var="sup" items="${suppliers}">
<tr>
<td>${sup.supplierid}</td>
<td><img src="resources/images/suppliers/${sup.supplierid}.jpg" height="200" width="200"/></td>
<td>${sup.suppliername}</td>
<td>${sup.supplierdesc}</td>
<td>${sup.issupplieravailable}</td>
<td><a href="reqEditSupplierPage?sid=${sup.supplierid}"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp; /
 <a href="reqDeleteSupplier?sid=${sup.supplierid}"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</tbody>

</table>
</body>
</html>