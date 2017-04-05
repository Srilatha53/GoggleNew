<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminnavbar.jsp"%>
Edit product
<form:form action="reqEditProductToDb" commandName="productObj" enctype="multipart/form-data" method="POST">

<form:hidden path="productid"/>

<br>Product Name : <form:input path="productname"/>

<br>Product Desc : <form:textarea path="productdesc" rows="5" cols="100"/>

<br>
Is Available  :   
True <form:radiobutton path="isproductavailable" value="true" />         
False<form:radiobutton path="isproductavailable" value="false" />

<br>
Select Image : <form:input type="file" path="imagefile"/>
<br>
<form:button>Edit Product</form:button>
</form:form>
</body>
</html>