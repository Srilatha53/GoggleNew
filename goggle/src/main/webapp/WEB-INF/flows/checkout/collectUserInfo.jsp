<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../../pages/links.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../pages/usernavbar.jsp" %>
<br>
<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h1>Customer</h1>


<p class="lead">Customer Details:</p>
</div>

<form:form commandName="order" class="form-horizontal">

<h3>Basic Info:</h3>

<div class="form-group">
<label for="name">First Name</label>
<form:input path="cart.customer.custfname" id="custfname" class="form-Control" />
<form:input path="cart.customer.custlname" id="custlname" class="form-Control" />
</div>


<div class="form-group">
<label for="email">Email</label>
<form:input path="cart.customer.custemailid" id="custemailid" class="form-Control" />
</div>

<div class="form-group">
<label for="phone">Phone</label>
<form:input path="cart.customer.custmobileno" id="custmobileno" class="form-Control" />
</div>

<br/>

<h3>Billing Address:</h3>

<div class="form-group">
<label for="billingStreet">Street Name</label>
<form:input path="cart.customer.billingAddress.street" id="billingStreet" class="form-Control" />
</div>


<div class="form-group">
<label for="billingApartmentNumber">House No.</label>
<form:input path="cart.customer.billingAddress.houseno" id="billingHouseno" class="form-Control" />
</div>

<div class="form-group">
<label for="billingApartmentNumber">Area</label>
<form:input path="cart.customer.billingAddress.area" id="billingArea" class="form-Control" />
</div>

<div class="form-group">
<label for="billingCity">City</label>
<form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-Control" />
</div>

<div class="form-group">
<label for="billingState">State</label>
<form:input path="cart.customer.billingAddress.state" id="billingState" class="form-Control" />
</div>

<div class="form-group">
<label for="billingCountry">Country</label>
<form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control" />
</div>

<div class="form-group">
<label for="billingZip">Zipcode</label>
<form:input path="cart.customer.billingAddress.pincode" id="billingPincode" class="form-Control" />
</div>

<input type="hidden" name="_flowExecutionKey" />

<br/><br/>

<input type="submit" value="Next" class="btn btn-default" name="_eventId_collectedUserInfo" />

<button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</form:form>
</div>
</div>

</body>
</html>