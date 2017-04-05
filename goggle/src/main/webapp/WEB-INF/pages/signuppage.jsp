<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
 <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up Form</title>
<script>
/* $(function(){
$('input[name=dob]').datepicker({
	format:'YYYY-mm-dd'
});	
});  */

/* $(function () {
    $('#dob').datetimepicker({
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            up: "fa fa-arrow-up",
            down: "fa fa-arrow-down"
        }
    });
}); */
</script>
</head>
<body>
<%@ include file="homenavbar.jsp" %>
<!-- <nav class="navbar navbar-inverse">

<div class="navbar-header">
      <a class="navbar-brand"  class="active" href="#">Miwani</a>
    </div>
<div class="container">
<ul class="nav navbar-nav">
<li class="active"><a href="home"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
<li><a href="#">ABOUT US</a></li>
<li><a href="#">CONTACT US</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
<li class="active"><a href="reqForSignupPage"><span class="glyphicon glyphicon-user"></span>SIGN UP</a></li>
<li><a href="reqForLoginPage"><span class="glyphicon glyphicon-Login"></span>LOGIN</a></li>
</ul>
</div>
</nav> -->
<div align="center">
<h4>Create An Account</h4>
<div class="col-sm-2" style="background: transparent; border: none"></div> 
<div class="col-sm-8" style="background:rgba(90,60,30,0.3)" align="justify"> 
<form:form class="form-horizontal" action="reqSendSignUpData" commandName="customerObject" enctype="multipart/form-data" method="POST">

<form:hidden path="customerid"/>

 <div class="form-group">
    <label for="custfname">Name:</label>
    <form:input type="text" class="form-control" path="custfname" placeholder="Enter Surname"/>
    <form:errors path="custfname"></form:errors>
    <form:input type="text" class="form-control" path="custlname" placeholder="Enter Name"/>
    <form:errors path="custlname"></form:errors>
</div>

<div class="form-group">
    <label for="email">Email:</label>
    <form:input type="text" class="form-control" path="custemailid" placeholder="Enter Email"/>
    <form:errors path="custemailid"></form:errors>
</div>
<div class="form-group">
    <label for="email">Mobile NO:</label>
    <form:input type="text" class="form-control" path="custmobileno" placeholder="Enter Mobile NO"/>
    <form:errors path="custmobileno"></form:errors>
</div>

<label class="row">Gender:</label>
  <div class="form-group"> 
       <form:radiobutton path="gender" value="M"/>Male
		<form:radiobutton path="gender" value="F"/>Female
<form:errors path="gender"></form:errors>


   </div> <div class="form-group">
    <label for="email">Select Image :</label>
 <form:input type="file" path="imagefile" placeholder="Select Image file"/>Press here to upload the file!
</div>

<br><b>AUTHENTICATION</b>
<div class="form-group">
    <label for="password">Password:</label>
    <form:input type="password" class="form-control" path="userDetails.password" placeholder="Enter Password"/>
</div>
<%-- <div class="form-group">
    <label class='input-group date' id='dob'>Date Of Birth:</label>
    <form:input type="text" class="form-control" path="dob" placeholder="Select Date of Birth"/>
</div>--%>

<%-- Select Image : <form:input type="file" path="imagefile" placeholder="Select Image file"/>Press here to upload the file! --%>

<br><b>ADDRESS</b>
<div class="form-group">
    <label for="houseno">House NO:</label>
    <form:input type="text" class="form-control" path="shippingAddress.houseno" placeholder="Enter House NO"/>
</div>
<div class="form-group">
    <label for="street">Street:</label>
    <form:input type="text" class="form-control" path="shippingAddress.street" placeholder="Enter Street"/>
</div>
<div class="form-group">
    <label for="area">Area:</label>
    <form:input type="text" class="form-control" path="shippingAddress.area" placeholder="Enter Area"/>
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
<div class="form-group" align="center" style="size: 30">
    <form:button>Submit</form:button>
 </div>   

</form:form>
</div>
</div>
<%-- Password : <form:password path="password"/>
<br>
Email Id: <form:input path="email"/>
<br>
Gender :	
			<form:radiobutton path="gender"/>Female
			<form:radiobutton path="gender"/>Male
<br>
Date Of Birth : <form:input path="dob"/>
<br>
Select Image : <form:input type="file" path="userimagefile"/>
<br>
Mobile Number: <form:input path="contact"/>
<br>
Address: <form:textarea rows="5" path="Address"/>
<br>
City: <form:input path="city"/>
<br>
State: <form:input path="state"/>
<br>
Country: <form:input path="country"/>
<br>
Pin Code: <form:input path="pincode"/>
<br>
<form:button>Sign-Up</form:button>
<br> --%>
</body>
</html>