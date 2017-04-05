<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../../pages/links.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="../../pages/usernavbar.jsp" %>
<br>
<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h1>Cutomer</h1>


<p class="lead">Customer Details:</p>
</div>

<form:form commandName="order" class="form-horizontal">

<h3>Shipping Address:</h3>

<div class="form-group">
<label for="shippingApartmentNumber">House No.</label>
<form:input path="cart.customer.shippingAddress.houseno" id="shippingHouseNumber" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingStreet">Street Name</label>
<form:input path="cart.customer.shippingAddress.street" id="shippingStreet" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingStreet">Area</label>
<form:input path="cart.customer.shippingAddress.area" id="shippingArea" class="form-Control" />
</div>


<div class="form-group">
<label for="shippingCity">City</label>
<form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingState">State</label>
<form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingCountry">Country</label>
<form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-Control" />
</div>

<div class="form-group">
<label for="shippingZip">Zipcode</label>
<form:input path="cart.customer.shippingAddress.pincode" id="shippingPincode" class="form-Control" />
</div>

<input type="hidden" name="_flowExecutionKey" />

<br/><br/>

<button class="btn btn-default" name="_eventId_backTocollectShippingAddr">Back</button>

<input type="submit" value="Next" class="btn btn-default" name="_eventId_collectedShippingAddr" />

<button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</form:form>
</div>
</div>

</body>
</html>