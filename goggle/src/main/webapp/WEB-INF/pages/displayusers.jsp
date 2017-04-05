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
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>
<tr style="background:rgba(30,60,30,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">User Id</th>
<th style="text-align:center">Enabled Status</th>
<th style="text-align:center">Action</th>
</tr>
</thead>

<tbody>
<c:forEach var="usr" items="${userdata}">
<tr style="text-align:center;background:rgba(90,90,30,0.7)">
<td style="vertical-align: middle;font-weight:bold;color:yellow">${usr.userid}</td>

<td style="align:center"> 
 	<c:if test="${usr.enabled == true}">
		 		<b  style="color:yellow"><br>Enabled</b>
	 </c:if>
<c:if test="${usr.enabled == false}">
		 		<b style="color:yellow"><br>Disabled</b>
	 </c:if>
</td>




<td style="align:center"> 
 	<c:if test="${usr.enabled == true}">
		 		<a href="reqDisableUser?uid=${usr.userid}" style="color:yellow"><br>Disable</a>
	 </c:if>
<c:if test="${usr.enabled == false}">
		 		<a href="reqEnableUser?uid=${usr.userid}" style="color:yellow"><br>Enable</a>
	 </c:if>
</td>


</tr>
</c:forEach>
</tbody>


</table>

<!-- <div class="container">
  <h2>Table</h2>
  <p>The .table-responsive class creates a responsive table which will scroll horizontally on small devices (under 768px). When viewing on anything larger than 768px wide, there is no difference:</p>                                                                                      
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>#</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Age</th>
        <th>City</th>
        <th>Country</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Anna</td>
        <td>Pitt</td>
        <td>35</td>
        <td>New York</td>
        <td>USA</td>
      </tr>
    </tbody>
  </table>
  </div>
</div> -->
</body>
</html>