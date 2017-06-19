<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url var="css" value="resources/css"/>
<spring:url var="font" value="resources/fonts"/>
<spring:url var="js" value="resources/js"/>
<spring:url var="img" value="resources/images"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>Sport Shop -${title}</title>

<script>
window.menu='${title}';
</script>

<link href="${css}/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

    <script src="${js}/bootstrap.js"></script>
    
    <script src="${js}/myapp.js"></script>
<!-- Custom Theme files -->
<link href="${css}/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
     <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Dancing+Script:400,700' rel='stylesheet' type='text/css'>
<script src="${js}/jquery.easydropdown.js"></script>
<script src="${js}/responsiveslides.min.js"></script>
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
    <!-- header-section-starts -->
    <%@include file="header.jsp" %>
    <!-- content-section-starts -->
	<c:if test="${userClickHome==true }">
	<%@include file="home.jsp" %>
	</c:if>
	<c:if test="${userClickLogin==true }">
	<%@include file="login.jsp" %>
	</c:if>
	<c:if test="${userClickRegister==true }">
	<%@include file="register.jsp" %>
	</c:if>	
	<c:if test="${userClickContact==true }">
	<%@include file="contact.jsp" %>
	</c:if>	
	<c:if test="${userClickProduct==true }">
	<%@include file="products.jsp" %>
	</c:if>
	<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
	<%@include file="listproducts.jsp" %>
	</c:if>	
		
	<!-- footer-section-starts -->
	<%@include file="footer.jsp" %>

</body>
</html>