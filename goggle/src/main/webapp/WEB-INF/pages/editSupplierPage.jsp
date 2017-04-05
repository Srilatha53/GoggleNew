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
Add Supplier
<form:form action="reqEditSupplierToDb" commandName="supplierObj" enctype="multipart/form-data" method="POST">
<form:hidden path="supplierid"/>
<br>Supplier Name : <form:input path="suppliername"/>

<br>Supplier Desc : <form:textarea path="supplierdesc" rows="7" cols="20"/>

<br>
Is Available  :   
True <form:radiobutton path="issupplieravailable" value="true" />         
False<form:radiobutton path="issupplieravailable" value="false" />

<br>
Select Image : <form:input type="file" path="supimagefile"/>
<br>
<form:button>Edit Supplier</form:button>


</form:form>
</body>
</html>