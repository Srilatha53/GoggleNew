
<nav class="navbar navbar-inverse"  style="background-color: transparent">
  <div class="container-fluid">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Miwani</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
   <li class="dropdown">
  <a class="dropdown-toggle" data-toggle="dropdown" href="#"><img src="resources/images/users/ADM00001.jpg" class="img-circle" height="40" width="40"/>Welcome ${admin}<span class="caret"></span></a>
   <ul class="dropdown-menu">
    <li><a href="#">Edit Profile</a></li>
    <li><a href="reqchangepassword">Change Password</a></li>
    <li><a href="j_spring_security_logout">Logout</a></li>
  </ul>
  </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="reqDisplayProductsAdmin">Display Products</a></li>
          <li><a href="reqProductForm">Add Products</a></li>
         </ul>
      </li>
      

	
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Suppliers
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="reqDisplaySuppliersAdmin">Display Suppliers</a></li>
          <li><a href="reqSupplierForm">Add Suppliers</a></li>
         </ul>
      </li>

	
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product Suppliers
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="reqdisplayps">DisplayProduct Suppliers</a></li>
          <li><a href="reqPSForm">Add Product Suppliers</a></li>
         </ul>
      </li>


      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Users
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="reqDisplayUsers">Display Users</a></li>
        </ul>
      </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
<li><a href="#">About Us</a></li>
<li><a href="#">Contact Us</a></li>
</ul>
   </div>
  </div>
</nav>
