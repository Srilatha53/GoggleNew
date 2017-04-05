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
<%@ include file="adminnavbar.jsp" %>
<b><u>Add PRODUCT_SUPPLIER</u></b>
<form:form action="addPStoDB" commandName="xmapObj"  method="POST">

<br>PRODUCT Name :
<form:select path="productid">
<c:forEach var="prd" items="${products}">
<option value="${prd.productid}"> ${prd.productname}</option>
</c:forEach>
</form:select>

<br>SUPPLIER Name :
 <form:select path="supplierid">
<c:forEach var="sup" items="${suppliers}">
<option value="${sup.supplierid}"> ${sup.suppliername}</option>
</c:forEach>
</form:select>
<br>
<br>
Price : <form:input path="psprice"/>
<form:errors path="psprice"></form:errors>
Stock : <form:input path="psstock"/>
<form:errors path="psstock"></form:errors>

Is Available  :   
True <form:radiobutton path="ispsavailable" value="True"/>         
False<form:radiobutton path="ispsavailable" value="False"/>
<br>
<form:button>Add Record</form:button>


</form:form>


</body>
</html>