<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
<%@ include file="usernavbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
		    <h3 class="text-center">Reset Password</h3>
		    <hr/>
		    <form:form action="reqEditPasswordtoDB" commandName="userObject"  method="POST">
		    <form:hidden path="userid"/>
		        <div class="form-group">
		            <label>Enter Old Password :</label>
		            <input type="password" class="form-control"/>
		        </div>
		             <div class="form-group">
		            <label>New Password :</label>
		            <input type="password" class="form-control"/>
		        </div>
		         <div class="form-group">
		            <label>Confirm Password :</label>
		            <input type="password" class="form-control"/>
		        </div>
		        <button class="btn btn-primary btn-sm center-block">
		            Submit
		        </button>
		    </form:form>
		</div>
	</div>
</div>
</body>
</html>