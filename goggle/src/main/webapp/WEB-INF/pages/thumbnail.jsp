<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>
</head>
<body>

<div class='row'>
    <div class='col-md-12'>
        <div class="carousel slide media-carousel" id="media">
            <div class="carousel-inner">
               
                   <c:forEach var="ps" items="${psdata}">
                    <c:if test="psdata.size() >= 6">
                  
                    
                        <div class="row">
                       		 <c:forEach var="ps" items="${psdata}">
                            
                              <li>  <div class="col-md-2">
                                    <a class="thumbnail" href="#"><img src="resources/images/products/${ps.productid}.jpg" width="100" height="100"></a>
                                </div></li>
                                </c:forEach>
                        </div>
                </c:if> 
                </c:forEach>
                    
                      </div>
            <a data-slide="prev" href="#media" class="left carousel-control">‹</a>
            <a data-slide="next" href="#media" class="right carousel-control">›</a>
        </div>
    </div>
</div>


</body>
</html>