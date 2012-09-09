<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>My Company - Struts2 jQuery Grid</title>
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
						<li class="active"><s:a href="%{index_url}">Home</s:a></li>
						<s:url var="contact_url" action="contact" />
						<li><s:a href="%{contact_url}">Contact</s:a></li>
						<s:url var="about_url" action="about" />
						<li><s:a href="%{about_url}">About</s:a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<h1>Struts2 jQuery Grid with Bootstrap starter template</h1>
		<p>Use this Struts2 jQuery Grid archetype as a way to quick start any new project.</p>

		<s:url var="customers_data_provider_url" action="customers-data-provider" namespace="/data"/>
		<sjg:grid 
			id="customersGrid" 
			width="900"
			caption="Customers Examples" 
			dataType="json"
			href="%{customers_data_provider_url}" 
			pager="true" 
			gridModel="gridModel"
			rowList="10,15,20" 
			rowNum="15" 
			rownumbers="true" 
		>
			<sjg:gridColumn name="id" index="id" title="ID" width="30" formatter="integer" sortable="false" />
			<sjg:gridColumn name="name" index="name" title="Name" width="250" sortable="false" />
			<sjg:gridColumn name="country" index="country" title="Country" sortable="false" />
			<sjg:gridColumn name="city" index="city" title="City" sortable="false" />
			<sjg:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" align="right" formatter="currency" sortable="false" />
		</sjg:grid>


	</div>
	<!-- /container -->

	<footer class="footer container well" style="margin-top: 30px;">
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			Created by <a href="#" target="_blank">My Company</a>.
		</p>
	</footer>

	</div>
	<!-- /container -->
</body>
</html>
