<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});
</script>
<style>
body{
		background-size:contain;
		background-repeat:no-repeat;
		background-attachment:fixed;
		background-size:100% 100%;
}
#boxshadow {
    position: relative;
    -moz-box-shadow: 1px 2px 4px rgba(0, 0, 0,0.5);
    -webkit-box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);
    box-shadow: 10px 20px 10px rgba(0, 0, 0, .5);
    padding: 1px;
    /* background: white; */
}
#boxshadow img {
    width: 100%;
    border: 1px solid #8a4419;
    border-style: inset;
}


#boxshadow::after {
    content: '';
    position: absolute;
    z-index: -1; /* hide shadow behind image */
    -webkit-box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);
    -moz-box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);
    box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);                
    width: 70%; 
    left: 15%; /* one half of the remaining 30% */
    height: 100px;
    bottom: 0;
}
.zoom-effect-container {
  /*  float: left;
    position: relative; 
    width: 640px;
    height: 360px;
    margin: 0 auto;
    overflow: hidden;  */
}

.image-card {
 
  top: 0;
  left: 0;
}

.image-card img {
  -webkit-transition: 0.8s ease;
  transition: 0.8s ease;
}

.zoom-effect-container:hover .image-card img {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}


</style>
</head>
<body background="resources/images/backgroundu.jpg">
<%@ include file="usernavbar.jsp" %>

<%-- ${psdata} --%>

${cartmessage}
<div class="container-fluid">
<div class="row" >

<c:forEach var="ps" items="${psdata}">
<div class="col-sm-3 zoom-effect-container" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div  class="thumbnail image-card" style="height: 370px;background-color:transparent;border:3px solid green; border-radius:8px; padding:5px; border-style: none; text-align:center; font-size:15px; font-style:bold">
		<c:url value="/resources/images/products/${ps.productid}.jpg" var="url"></c:url>
		 <img id="boxshadow" src="${url}" style="width:200px; height:200px;" class="img-rounded"/>
		<b><br>Name : ${ps.productname} 
		 <br>Supplier : ${ps.suppliername}
		 <br>Price : ${ps.psprice}</b>
		  <c:if test="${ps.psstock >=5 }">
		 		<b><br>Stock : ${ps.psstock}</b>
		  </c:if>  
		   <c:if test="${ps.psstock < 5}">
		 		<b style="color:yellow"><br>Out of stock</b>
		  </c:if>  
		  
		 <br> 
		 <c:url value="/reqAllSuppProducts?pid=${ps.productid}" var="abcd"></c:url>
		 <a href="${abcd}">All Suppliers</a>
		   <c:if test="${ps.psstock >= 5}">
		  
		 <c:url value="/reqAddItemToCart/${ps.psid}" var="a"></c:url>
		 <form action="${a}">
		  <select name="qty" id="qty">
      	<option value="1">1</option>
      	<option value="2">2</option>
      	<option value="3">3</option>
      	<option value="4">4</option>
      	<option value="5">5</option>
      		
      	</select>
		<button type="submit" class="btn btn-warning btn-large"> 
         <span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
         </button>  
		  </form>
		  
		 </c:if>
		 	
		</div>
		
		</div>
		 
		
</c:forEach>

</div> <!--  row closing -->

</div> <!--  container closing -->

</body>
</html>