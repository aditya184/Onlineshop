<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
           
         <security:authorize access="hasAuthority('ADMIN')">  
           <li id="manageProducts">
        <a href="${contextRoot}/manage/products">Manage Products</a></li>             
        </security:authorize>
        
        <li id="contact">
        <a href="${contextRoot}/contact">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <security:authorize access="isAnonymous()">
      <li id="register"><a href="${contextRoot}/register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      
      <li id="login"><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </security:authorize>
      
      <security:authorize access="isAuthenticated()">
      <li class="dropdown">
         
          <a href="javascript:void(0)"
           class="dropdown-toggle"
           id="dropdownMenu1"
           data-toggle="dropdown">
           
              ${userModel.fullName}
              <span class="caret"></span>
           
           </a>
           <ul class="dropdown-menu">
              <security:authorize access="hasAuthority('USER')">
               <li>
                 <a href="${contextRoot}/cart/${userModel.cart.id}/show">
                     <span class="glyphicon glyphicon-shopping-cart"></span>
                     <span class="badge">${userModel.cart.cartLines}</span>
					 - &#8377; ${userModel.cart.grandTotal}	
                 </a>
                </li>
                <li class="divider" role="separator"></li>
                </security:authorize>
                <li>
                    <a href="${contextRoot}/perform-logout">Logout</a>
                </li>
           
           </ul>
      
      
      
      
      
      </li>
      </security:authorize>
    </ul>
  </div>
</nav>

<<script>
  
  window.userRole = '${userModel.role}';

</script>

    

    