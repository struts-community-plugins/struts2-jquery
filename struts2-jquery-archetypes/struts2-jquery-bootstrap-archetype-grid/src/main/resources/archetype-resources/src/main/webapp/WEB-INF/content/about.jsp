<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />

	<title>My Company - About</title>

	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
	<s:url var="js" value="js/html5.js"/>
	<s:script src="%{js}"/>
	<![endif]-->

	<!--  Struts2 Taglib Resources -->
	<sb:head />
	<s:url var="styles" value="/styles/content.css"/>
	<s:link href="%{styles}" rel="stylesheet" type="text/css" />
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">My Company</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<s:url var="index_url" action="index" />
				<li><s:a href="%{index_url}"><span class="glyphicon glyphicon-th"></span> Home</s:a></li>
				<s:url var="contact_url" action="contact" />
				<li><s:a href="%{contact_url}"><span class="glyphicon glyphicon-envelope"></span> Contact</s:a></li>
				<s:url var="about_url" action="about" />
				<li class="active"><s:a href="%{about_url}"><span class="glyphicon glyphicon-info-sign"></span> About</s:a></li>
			</ul>
		</div><!--/.nav-collapse -->
	</div>
</nav>

<div class="container">
	<div class="row">
		<div class="col-md-12">

			<h1>About this Archetype</h1>

			<h2>Projects</h2>
			<ul>
				<li><a href="http://struts.apache.org">Struts2</a></li>
				<li><a href="https://github.com/struts-community-plugins/struts2-jquery">Struts2 jQuery Plugin</a></li>
				<li><a href="https://github.com/struts-community-plugins/struts2-bootstrap">Struts2 Bootstrap Plugin</a></li>
			</ul>

			<h2>Developer</h2>
			<ul>
				<li><a href="https://www.jgeppert.com">Developer Homepage and Contact</a></li>
				<li><a href="http://twitter.com/jogep">Twitter News</a></li>
			</ul>

		</div>
	</div>
</div>
<!-- /container -->

<footer class="footer well" style="margin-top: 30px;">
	<p class="pull-right">
		<a href="#">Back to top</a>
	</p>
	<p>
		Created by <a href="#" target="_blank">My Company</a>.
	</p>
</footer>

</body>
</html>
