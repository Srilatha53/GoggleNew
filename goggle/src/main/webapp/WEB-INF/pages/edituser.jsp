<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="links.jsp"%>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <script>
 $(function(){
$('input[name=dob]').datepicker({
	format:'YYYY-mm-dd'
});	
}); 
</script> -->
</head>
<body>
<%@ include file="usernavbar.jsp"%>
<h4 align="center">Edit Profile</h4>
<div class="col-sm-2" style="background: transparent; border: none"></div> 
<div class="col-sm-8" style="background:rgba(90,60,30,0.3)" align="justify"> 
<form:form class="form-horizontal" action="reqEditUserToDb" commandName="custObject"  method="POST" >
<%-- Name : <form:input path="firstname"/> <form:input path="lastname"/>
<br> --%>
<form:hidden path="customerid"/>

 <div class="form-group">
    <label for="custfname">Name:</label>
    <form:input type="text" class="form-control" path="custfname" placeholder="Enter Surname"/>
    <%-- <form:errors path="custfname"></form:errors> --%>
    <form:input type="text" class="form-control" path="custlname" placeholder="Enter Name"/>
</div>

<div class="form-group">
    <label for="email">Email:</label>
    <form:input type="text" class="form-control" path="custemailid" placeholder="Enter Email"/>
</div>
<div class="form-group">
    <label for="email">Mobile NO:</label>
    <form:input type="text" class="form-control" path="custmobileno" placeholder="Enter Mobile NO"/>
</div>
<label class="row">Gender:</label>
  <div class="form-group"> 
 	 
       		<form:radiobutton path="gender" value="M"/>Male
			<form:radiobutton path="gender" value="F"/>Female
<form:errors path="gender"></form:errors>
   </div> 

<br><b>AUTHENTICATION</b>
<div class="form-group">
    <label for="password">Password:</label>
    <form:input type="password" class="form-control" path="userDetails.password" placeholder="Enter Password"/>
</div>
<%-- <div class="form-group">
    <label class='input-group date' id='dob'>Date Of Birth:</label>
    <form:input type="text" class="form-control" path="dob" placeholder="Select Date of Birth"/>
</div>
<label class="row">Gender:</label>
  <div class="form-group"> 
       <form:radiobutton path="gender" value="M"/>Male
		<form:radiobutton path="gender" value="F"/>Female
   </div> --%>

<%-- Select Image : <form:input type="file" path="imagefile" placeholder="Select Image file"/>Press here to upload the file! --%>

<br><b>ADDRESS</b>
<div class="form-group">
    <label for="houseno">House NO:</label>
    <form:textarea type="text" class="form-control" path="shippingAddress.houseno" placeholder="Enter House NO"/>
</div>
<div class="form-group">
    <label for="street">Street:</label>
    <form:textarea type="text" class="form-control" path="shippingAddress.street" placeholder="Enter Street"/>
</div>
<div class="form-group">
    <label for="area">Area:</label>
    <form:textarea type="text" class="form-control" path="shippingAddress.area" placeholder="Enter Area"/>
</div>
<div class="form-group">
    <label for="city">City:</label>
    <form:input type="text" class="form-control" path="shippingAddress.city" placeholder="Enter City"/>
</div>
<div class="form-group">
    <label for="state">State:</label>
    <form:input type="text" class="form-control" path="shippingAddress.state" placeholder="Enter State"/>
</div>
<div class="form-group">
    <label for="country">Country:</label>
    <form:input type="text" class="form-control" path="shippingAddress.country" placeholder="Enter Country"/>
</div>
<div class="form-group">
    <label for="pincode">Pin Code:</label>
    <form:input type="text" class="form-control" path="shippingAddress.pincode" placeholder="Enter Pin Code"/>
</div> 
<form:button>Submit</form:button>
</form:form>

<%-- <form:hidden path="customerid"/>
<div class="form-group">
    <label for="firstname">Name:</label>
    <form:input type="text" class="form-control" path="firstname"/>
    <form:input type="text" class="form-control" path="lastname" />
</div>
<div class="form-group">
    <label for="password">Password:</label>
    <form:input type="password" class="form-control" path="password"/>
</div>
<div class="form-group">
    <label for="email">Email:</label>
    <form:input type="text" class="form-control" path="email"/>
</div>
<div class="form-group">
    <label for="dob" style="">Date Of Birth:</label>
    <form:input type="text" class="form-control" path="dob"/>
</div>
<label class="row">Gender:</label>
  <div class="form-group"> 
       <form:radiobutton path="gender" value="M"/>Male
		<form:radiobutton path="gender" value="F"/>Female
   </div>
<div class="form-group">
    <label for="contact">Mobile Number:</label>
    <form:input type="text" class="form-control" path="contact"/>
</div>
Select Image : <form:input type="file" path="imagefile" readonly="true"/>Press here to upload the file!
<div class="form-group">
    <label for="Address">Address:</label>
    <form:textarea type="text" class="form-control" path="Address"/>
</div>
<div class="form-group">
    <label for="city">City:</label>
    <form:input type="text" class="form-control" path="city"/>
</div>
<div class="form-group">
    <label for="state">State:</label>
    <form:input type="text" class="form-control" path="state"/>
</div>
<div class="form-group">
    <label for="country">Country:</label>
    <form:input type="text" class="form-control" path="country"/>
</div>
<div class="form-group">
    <label for="pincode">Pin Code:</label>
    <form:input type="text" class="form-control" path="pincode"/>
</div>
    <form:button>Edit</form:button>

</form:form> --%>
</div>
</body>
</html>