<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="struts2,jquery,hibernate,spring,plugin,showcase,grid"/>
	<meta http-equiv="description"
		  content="Showcase for Struts2 jQuery Grid Plugin with hibernate and spring integration"/>

	<title>Struts2 jQuery Grid Plugin Showcase - <s:text name="showcase.version"/></title>

	<link href="<s:url value="/styles/flexible-grids.css" />" rel="stylesheet" type="text/css" />
	<!--[if lte IE 7]>
	<link href="<s:url value="/yaml/core/iehacks.min.css" />" rel="stylesheet" type="text/css" />
	<![endif]-->

	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<sj:head
    	loadAtOnce="true"
    	compressed="true"
    	jquerytheme="showcase"
    	customBasepath="themes"
    	loadFromCdn="false"
    	debug="true"
    />

	<s:url var="empurl" action="employees-detail" />
	<script type="text/javascript">
		var employee_detail_url = '<s:property value="empurl"/>';
	</script>
  <script type="text/javascript" src="<s:url value="/js/showcase.js" />"></script>
</head>
<body>

<header class="ui-widget-header">
	<div class="ym-wrapper">
		<div class="ym-wbox" style="padding: 5px 0 0 0;">
			<div>
				<h1 class="ui-state-default" style="background: none; border: none; margin: 0;">Showcase for Struts2
					jQuery Grid Plugin</h1>
				<h4 class="ui-state-default" style="background: none; border: none;">Struts2 jQuery Plugin - Version
					<s:text name="showcase.version"/></h4>
			</div>
		</div>
	</div>
</header>

<nav id="nav" class="ui-widget-header">
	<div class="ym-wrapper">
		<div class="ym-hlist">
			<ul id="navlist">
				<li><s:url var="urlgrid" action="grid" /><sj:a id="gridlink" href="%{urlgrid}" targets="main_content">Grid (Editable)</sj:a></li>
				<li><s:url var="urlgridsubgrid" action="grid-subgrid" /><sj:a id="gridsubgridlink" href="%{urlgridsubgrid}" targets="main_content">Grid with Subgrid</sj:a></li>
				<li><s:url var="urlgriddnd" action="grid-dnd" /><sj:a id="griddndlink" href="%{urlgriddnd}" targets="main_content">Grid with Drag and Drop</sj:a></li>
				<li><a href="https://github.com/struts-community-plugins/struts2-jquery/">Struts2 jQuery Plugin</a></li>
			</ul>
		</div>
	</div>
</nav>


<div id="main">
	<div class="ym-wrapper">
		<sj:div id="main_content" href="%{urlgrid}" cssClass="ym-wbox">
			<img id="indicator" src="images/indicator.gif" alt="Loading..."/>
		</sj:div>
	</div>
</div>

<footer>
	<div class="ym-wrapper">
		<div class="ym-wbox">
			<p style="text-align: center;">
				Written by <a href="http://www.jgeppert.com" title="Java Developer Blog">Johannes Geppert</a><br/>
				Layout based on <a href="http://www.yaml.de/" title="OpenSource CSS Layout">YAML</a>
			</p>
		</div>
	</div>
</footer>

</body>
</html>
