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

<b><u>Add Supplier</u></b>
<form:form action="addSupplierToDB" commandName="supplierObj" enctype="multipart/form-data" method="POST">
<form:hidden path="supplierid"/>
<br>Supplier Name : 
<br><form:input path="suppliername"/>
<form:errors path="suppliername" cssStyle="color:red"></form:errors>

<br>Supplier Desc : 
<br><form:textarea path="supplierdesc" rows="5" cols="100"/>
<form:errors path="supplierdesc" cssStyle="color:red"></form:errors>
<br>
Is Available  :   
True <form:radiobutton path="issupplieravailable" value="True" />         
False<form:radiobutton path="issupplieravailable" value="False" />
<form:errors path="issupplieravailable" cssStyle="color:red"></form:errors>

<br>
Select Image : <form:input type="file" path="supimagefile"/>
<br>
<form:button>Add Supplier</form:button>


</form:form>
</body>
</html>