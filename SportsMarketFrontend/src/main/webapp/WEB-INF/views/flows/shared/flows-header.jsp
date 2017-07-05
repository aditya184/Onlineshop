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

 <script src="${js}/jquery.dataTables.js"></script>
<link href="${css}/myapp.css" rel='stylesheet' type='text/css' />  


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
     
         <%@include file="flows-navbar.jsp" %>
              
           <div class="content">