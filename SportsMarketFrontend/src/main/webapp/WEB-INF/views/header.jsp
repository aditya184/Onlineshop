<div class="header">
        <div class="top-header">
            <div class="container">
    <div class="logo">
					<a href="${contextRoot}/home"><h1>sporty</h1></a>
				</div>
                </div>
        </div>  
    </div>
    
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
    
      <li id="home"><a href="${contextRoot}/home">Home</a></li>
            <li id="listProducts">
            <a href="${contextRoot}/show/all/products">Products</a>
            </li>
            
        <%@include file="dropdown.jsp" %>
           
           <li id="manageProducts">
        <a href="${contextRoot}/manage/products">Manage Products</a></li>             
        <li id="contact">
        <a href="${contextRoot}/contact">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li id="register"><a href="${contextRoot}/register"><span class="glyphicon glyphicon-user"></span>Register</a></li>
      <li id="login"><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


    

    