<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.lang.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@ include file="links.jsp" %>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
      height: 500px;
  }
	 .carousel-control.left, .carousel-control.right {
  background-image: transparent; opacity:0.3;left: auto;
} 
.carouser{
	margin-top:0;
}
.navbar {
    margin-bottom: 0;
    
}
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

#bxSlider{
  minSlides: 3;
  maxSlides: 4;
  slideWidth: 170;
  slideMargin: 10;
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
   /* float: left;
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

.multi-item-carousel{
  .carousel-inner{
    > .item{
      transition: 500ms ease-in-out left;
    }
    .active{
      &.left{
        left:-33%;
      }
      &.right{
        left:33%;
      }
    }
    .next{
      left: 33%;
    }
    .prev{
      left: -33%;
    }
    @media all and (transform-3d), (-webkit-transform-3d) {
      > .item{
        // use your favourite prefixer here
        transition: 500ms ease-in-out left;
        transition: 500ms ease-in-out all;
        backface-visibility: visible;
        transform: none!important;
      }
    }
  }
  .carouse-control{
    &.left, &.right{
      background-image: none;
    }
  }
}

// non-related styling:
body{
  background: #333;
  color: #ddd;
}
h1{
  color: white;
  font-size: 2.25em;
  text-align: center;
  margin-top: 1em;
  margin-bottom: 2em;
  text-shadow: 0px 2px 0px rgba(0, 0, 0, 1);
}

video#bgvid { 
    position: fixed;
    top: 50%;
    left: 50%;
    min-width: 100%;
    min-height: 100%;
    width: auto;
    height: auto;
    z-index: -100;
    -ms-transform: translateX(-50%) translateY(-50%);
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
    background: url(clothing.jpg) no-repeat;
    background-size: cover; 
    opacity:0.5;
}

/* #rotating-item-wrapper {
    position: relative;
    width: 980px;
    height: 347px;
}
.rotating-item {
    display: none;
    position: absolute;
    top: 0;
    left: 0;
} */

</style>
  
</head>
<body background="background.jpg">
<%@ include file="homenavbar.jsp" %> 
<video autoplay loop muted poster="ba.jpg" id="bgvid">
    <source src="resources/images/video2.webm" type="video/webm">
</video>
${logout}
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12" style="background: rgba(76, 70, 80, 0.2)">

 <!--  coraousel starts -->
<!-- <div class="container"> -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!--   Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
    </ol>

 <!--    Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="resources/images/carousel/kid5.jpg" alt="kid5" width="250" height="250" >
        <div class="carousel-caption">
          <h3>KIDS</h3>
          <p>Specially for Kids</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/images/carousel/kid6.jpg" alt="kid6" width="250" height="250">
        <div class="carousel-caption">
          <h3>Kids Styles</h3>
          <p>Different Styles</p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources/images/carousel/women1.jpg" alt="women1" width="250" height="250">
        <div class="carousel-caption">
          <h3>Women</h3>
          <p>Made for Women</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/images/carousel/women3.jpg" alt="women3" width="250" height="250">
        <div class="carousel-caption">
          <h3>Styles</h3>
          <p>Different Styles</p>
        </div>
      </div>
  	  
  	  <div class="item">
        <img src="resources/images/carousel/men1.jpg" alt="men1" width="250" height="250">
        <div class="carousel-caption">
          <h3>Men</h3>
          <p>Made for Men</p>
        </div>
      </div>
		<div class="item">
        <img src="resources/images/carousel/men3.jpg" alt="men3" width="250" height="250">
        <div class="carousel-caption">
          <h3>Men</h3>
          <p>Different Styles</p>
        </div>
      </div>
  </div>
   <!--  Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div>
</div>
<%-- 
<div class="container">
  <div class="carousel slide multi-item-carousel" id="theCarousel">
       
    	 <div class="carousel-inner">

<div class="row" >

<c:forEach var="ps" items="${psdata}" >

<c:forTokens items="ps" delims=""></c:forTokens>
 <c:if test="${rowCounter.count % 2 <= 6}">

	<div  class="col-sm-2 zoom-effect-container" style="background-color:transparent; border-style:none; left-padding:5px;">
		<div  class="thumbnail image-card" style="height: 370px;background-color:transparent;border:3px solid green; border-radius:8px; padding:5px; border-style: none; text-align:center; font-size:15px; font-style:bold">
		<c:url value="/resources/images/products/${ps.productid}.jpg" var="n"></c:url>
		 <img id="boxshadow" src="${n}" style="width:220px; height:200px;" class="img-circle"/>
		 <br>
		 <b><br>Name : ${ps.productname} 
		 <br>Price : ${ps.psprice}</b>
		</div>
		</div>
	
	    </c:if>
	    
	   
	  
	    
		</c:forEach>
		
		<a class="left carousel-control" href="#theCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span><span class="sr-only">Previous</span></a>
        <a class="right carousel-control" href="#theCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><span class="sr-only">Next</span></a>
		</div>

 </div>
</div>
	</div> --%>
	
	
<div class="container-fluid">
    <div class="col-sm-12">
        <div class="carousel slide media-carousel" id="media">
         
  <!--   Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#media" data-slide-to="0" class="active"></li>
      <li data-target="#media" data-slide-to="1"></li>
      </ol>
         <div class="carousel-inner" role="listbox">
           
               
                  <%--  <c:forEach var="ps" items="${psdata}"  begin="1" end="11"> --%>
            <div class="item active" class="clearfix visible-xs-block">
                 
                        <div class="row">
                         
                         <c:forEach var="ps" items="${psdata}"  begin="0" end="5">
                       		                  <%  for(int i=0;i<1;i++){%>         
                               <div class="col-sm-2">
                                 <div class="thumbnail equalize">
                                    <a class="thumbnail" href="#media">
                                    <c:url value="/resources/images/products/${ps.productid}.jpg" var="n"></c:url>
                                    <img id="boxshadow" src="${n}" width="100" height="100" class="img-circle"/></a>
                                <b><br>Name : ${ps.productname} 
								 <br>Supplier : ${ps.suppliername}
								 <br>Price : ${ps.psprice}</b>
								 
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
		</div>
                                </div>
                                <% } %>
                              </c:forEach>  
                              
                              </div>
                              </div>
                              
                              
                               <div class="item">
                      <div class="row">
                         <c:forEach var="ps" items="${psdata}"  begin="6" end="12">
                       		       <%  for(int i=0;i<1;i++){%>                    
                               <div class="col-sm-2">
                                 <div class="thumbnail equalize">
                                    <a class="thumbnail" href="#media">
                                    <c:url value="/resources/images/products/${ps.productid}.jpg" var="n"></c:url>
                                    <img id="boxshadow" src="${n}" width="100" height="100" class="img-circle"/>
                                    </a>
                                 <b><br>Name : ${ps.productname} 
								 <br>Supplier : ${ps.suppliername}
								 <br>Price : ${ps.psprice}</b>
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
                                </div>
                                </div>
                                  <% } %>
                              </c:forEach>  
                            
                        </div>
                 </div>
                <%-- </c:forEach> --%>
                    
                      </div>
                          
 
           <a class="left carousel-control" href="#media" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span><span class="sr-only">Previous</span></a>
        <a class="right carousel-control" href="#media" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span><span class="sr-only">Next</span></a>
  </div> 
  </div>
     </div>


<%@ include file="footer.jsp"%>

</body>
</html>