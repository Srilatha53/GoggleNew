<%-- <%@ include file="links.jsp"%> --%>
<nav class="navbar navbar-inverse" style="background-color: transparent">
	<div class="container-fluid">
	 <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
		<a class="navbar-brand" href="#">MIWANI</a>
 </div>
 <div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">
				<c:url value="/resources/images/users/${loginid}.jpg" var="ur"></c:url>
				<img src="${ur}" class="img-circle"
					height="40" width="40" />Welcome ${loginname}<span class="caret"></span></a>
				<ul class="dropdown-menu">
				<c:url value="/reqEditUser?cid=${loginid}" var="edit"></c:url>
					<li><a href="${edit}">Edit Profile</a></li>
				<c:url value="/reqchangepassword" var="change"></c:url>	
					<li><a href="${change}">Change Password</a></li>
				<c:url value="j_spring_security_logout" var="loout"></c:url>	
					<li><a href="${loout}">Logout</a></li>
				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
				<ul class="dropdown-menu">
				<c:url value="/reqDisplayProductsUser" var="z"></c:url>
					<li><a href="${z}">Display Products</a></li>
					<li><a href="#">Wish List</a></li>
				</ul></li>

				<c:url value="/reqShowCustOrderHistory?uid=${loginid}" var="y"></c:url>
			<li><a href="${y}">Orders </a></li>

			<c:url value="/reqShowCart" var="url"></c:url>
			<li><a href="${url}"> <span
					class="glyphicon glyphicon-shopping-cart"></span>
					<span class="badge">${cartsi}</span></a></li>
			<!--      <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li> -->
		</ul>




		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">About Us</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
</div>
	</div>
</nav>
