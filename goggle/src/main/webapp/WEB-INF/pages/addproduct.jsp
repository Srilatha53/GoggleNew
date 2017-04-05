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

<b><u>Add Product</u></b>
<form:form action="addProductToDB" commandName="productObj" enctype="multipart/form-data" method="POST">
<form:hidden path="productid"/>
<br>Product Name : 
<br><form:input path="productname"/>
<form:errors path="productname" cssStyle="color:red"></form:errors>

<br>Product Desc : 
<br><form:textarea path="productdesc" rows="5" cols="100" />
<form:errors path="productdesc" cssStyle="color:red"></form:errors>
<br>
Is Available  :   
True <form:radiobutton path="isproductavailable" value="True"/>         
False<form:radiobutton path="isproductavailable" value="False"/>
<form:errors path="isproductavailable" cssStyle="color:red"></form:errors>
<br>
Select Image : <form:input type="file" path="imagefile"/>
<form:errors path="imagefile" cssStyle="color:red"></form:errors>
<br>
<form:button>Add Product</form:button>
</form:form>

</body>
</html>