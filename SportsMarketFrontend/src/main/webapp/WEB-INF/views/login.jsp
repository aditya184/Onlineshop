<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url var="css" value="/resources/css"/>
<spring:url var="font" value="/resources/fonts"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="img" value="/resources/images"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>Sport Shop -${title}</title>

<script>
window.menu='${title}';

window.contextRoot='${contextRoot}';
</script>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->    
<script src="${js}/bootstrap.js"></script>

<!-- Custom Theme files -->


<link href="${css}/bootstrap-readable-theme.css" rel='stylesheet' type='text/css' />  
	
<link href="${css}/bootstrap.css" rel='stylesheet' type='text/css' />


<link href="${css}/dataTables.bootstrap.css" rel='stylesheet' type='text/css' />



<!-- Custom Theme files -->
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  
  <script src="${js}/responsiveslides.min.js"></script>
  
<script src="${js}/jquery.easydropdown.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="${js}/jquery.validate.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="${css}/myapp.css" rel='stylesheet' type='text/css' />  

<script src="${js}/myapp.js"></script>
 
	 
  
  
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Dancing+Script:400,700' rel='stylesheet' type='text/css'>
  


<script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
</script>
<script src="${js}/easyResponsiveTabs.js" type="text/javascript"></script>
		    <script type="text/javascript">
			    $(document).ready(function () {
			        $('#horizontalTab').easyResponsiveTabs({
			            type: 'default', //Types: default, vertical, accordion           
			            width: 'auto', //auto or any width like 600px
			            fit: true   // 100% fit in a container
			        });
			    });
</script>
    <script language="JavaScript" type="text/javascript">
  $(document).ready(function(){
    $('.carousel').carousel({
      interval: 2000
    })
  });
        
</script>
<script type="text/javascript" src="${js}/easing.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
			});
		</script>


</head>
<body>
<div class="wrapper">
    <!-- header-section-starts -->
    	<nav class="navbar navbar-inverse" role="navigation">
           <div class="container">
                 <div class="navbar-header">
                 <a class="navbar-brand" href="${flowExecutionUrl}home">Home</a> 
                </div>
            </div>   
            </nav>
            
     <div class="content">    
	   <div class="container">
	   
	   <c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-danger">${message}</div>
			</div>
		</div>
	  </c:if>
      
      <c:if test="${not empty logout}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-success">${logout}</div>
			</div>
		</div>
	</c:if>    
       <div class="row">
     
        <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       <div class="panel-body">
        <form action="${contextRoot}/login" method="POST" class="form-horizontal"
         id="loginForm"
        >
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
           <input type="submit" value="Login" class="btn btn-primary"/>
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          </div>
         </div>
        </form>
       
       </div>
       <div class="panel-footer">
       	<div class="text-right">
       		New User - <a href="${contextRoot}/register">Register Here</a>
       	</div>
       </div>
      
      </div> 
    
     </div>
     
    </div>    
   
   </div>
	</div>
	<!-- footer-section-starts -->
	<%@include file="footer.jsp" %>
</div>
</body>



</html>