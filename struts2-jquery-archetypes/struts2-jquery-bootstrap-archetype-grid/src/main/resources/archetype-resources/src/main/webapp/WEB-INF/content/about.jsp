<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>My Company - Struts2 jQuery Grid -About </title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />

	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
    	<script src="js/html5.js"></script>
    <![endif]-->

	<!--  Struts2 Taglib Resources -->
	<sj:head loadAtOnce="true" jquerytheme="cupertino"/>
	<sb:head />
	<link href="${pageContext.request.contextPath}/styles/content.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
					<span class="i-bar"></span> 
					<span class="i-bar"></span> 
					<span class="i-bar"></span> 
				</a> 
				<a class="brand" href="#">My Company</a>

				<div class="nav-collapse">
					<ul class="nav">
						<s:url var="index_url" action="index" />
						<li><s:a href="%{index_url}">Home</s:a></li>
						<s:url var="contact_url" action="contact" />
						<li><s:a href="%{contact_url}">Contact</s:a></li>
						<s:url var="about_url" action="about" />
						<li class="active"><s:a href="%{about_url}">About</s:a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

	    <h1>About this Archetype</h1>
	
	    <h2>Projects</h2>
	    <ul>
	        <li><a href="http://struts.apache.org">Struts2</a></li>
	        <li><a href="http://code.google.com/p/struts2-jquery/">Struts2 jQuery Plugin</a></li>
	        <li><a href="http://code.google.com/p/struts2-bootstrap/">Struts2 Bootstrap Plugin</a></li>
	    </ul>

	    <h2>Developer</h2>
	    <ul>
	        <li><a href="http://www.jgeppert.com">Developer Homepage and Contact</a></li>
	        <li><a href="http://twitter.com/jogep">Twitter News</a></li>
	    </ul>

	</div>
	<!-- /container -->

	<footer class="footer">
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			Created by <a href="#" target="_blank">My Company</a>.
		</p>
	</footer>
</body>
</html>
