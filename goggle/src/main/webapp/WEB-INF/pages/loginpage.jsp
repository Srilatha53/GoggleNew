<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loginpage</title>
<style>
form {
    border: 2px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 20%;
    padding: 8px 12px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 5px 8px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 20%;
}

.cancelbtn {
    width: auto;
    padding: 3px 5px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 10%;
    border-radius: 8%;
}

.container {
    padding: 8px;
}

span.psw {
    float: right;
    padding-top: 14px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 100px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>
<%@ include file="homenavbar.jsp" %>
Login page
<br>
${error}
${logout}
${message}
<br>
<%-- <div class="container-wrapper">
<div class="container">

<form:form commandName="userObject" action="reqLoginCheck">

 <div class="form-group">
     <label for="userid">
	 User ID</label><form:input path="userid" class="form-control" id="userid" placeholder="Enter User ID"/>
	 </div>
	 
	 <div class="form-group">
     <label for="password">
	 Password</label><form:password path="password" class="form-control" id="password" placeholder="Enter Password"/>
	 </div>

<form:button  class="btn btn-primary btn-lg active">Login</form:button>

</form:form> --%>



<br>
 <div class="container" align="center">
 
<form action="j_spring_security_check" method="post">
<div class="imgcontainer">
  <img src="resources/images/icon.jpg" class="img-circle" alt="adm1" width="230" height="210">
  </div>
 
<label for="userid" style="color: green" >Enter User ID</label>
<div class="form-group"> <input type="text" name="j_userid" style="background-color:silver" placeholder="Enter UserId"/></div>
<br>
<label for="password" style="color: green">Enter password</label>
<div class="form-group"> <input type="password" name="j_password" style="background-color:silver" placeholder="Enter Password"/></div>
<br>
<button type="submit">Login</button>
<br>
<input type="checkbox" checked="checked"> Remember me
    
</form>
</div>
 <br>   
     
		<p style="background-color:#f1f1f1" align="center">
    	 <button type="button" class="cancelbtn">Cancel</button>
    <!-- <span class="psw"> -->Forgot <a href="#">password?</a><!-- </span> -->
  </p>
   


</body>
</html>