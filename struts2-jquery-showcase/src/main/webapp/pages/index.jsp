<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Struts2 jQuery Plugin Showcase - <s:text name="showcase.version"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="struts2, jquery, jquery-ui, plugin, showcase, jqgrid" />
	<meta http-equiv="description" content="A Showcase for the Struts2 jQuery Plugin" />
	<link href="styles/layout.css" rel="stylesheet" type="text/css" />
	<!--[if lte IE 7]>
	<link href="styles/patch_layout.css" rel="stylesheet" type="text/css" />
	<![endif]-->

<link rel="stylesheet" href="http://static.jquery.com/ui/css/demo-docs-theme/ui.theme.css" type="text/css" media="all" />


	<!-- This files are needed for AJAX Validation of XHTML Forms -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>

  <s:if test="%{theme == 'showcase' || theme == null}">
      <sj:head debug="true" compressed="false" jquerytheme="showcase" customBasepath="themes" loadFromGoogle="%{google}" ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator" defaultLoadingText="Please wait ..."/>
  </s:if>
  <s:else>
      <sj:head debug="true" compressed="false" jquerytheme="%{theme}" loadFromGoogle="%{google}" ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator" defaultLoadingText="Please wait ..."/>
  </s:else>

	<!-- This file includes necessary functions/topics for validation and all topic examples -->
	<script type="text/javascript" src="js/showcase.js"></script>
	<!-- Extend the Struts2 jQuery Plugin with an richtext editor -->
	<script type="text/javascript" src="js/extendplugin.js"></script>
</head>
<body>
  <div class="page_margins">
    <div class="page">
      <div id="header" class="ui-widget-header">
        <div id="themebox">
            <s:form id="themeform" action="index" theme="simple">
                <div>
	                <s:select id="selected_theme" name="theme" list="themes" emptyOption="true" onchange="changeTheme(this.value);"/><br/>
	                <s:checkbox id="google" name="google" onclick="$.publish('themeformTopic');"/><label for="google" style="padding: 3px;">Load jQuery from Google CDN</label><br/>
	                <s:checkbox id="ajaxhistory" name="ajaxhistory" onclick="$.publish('themeformTopic');"/><label for="ajaxhistory" style="padding: 3px;">Use Ajaxhistory (BETA)</label><br/>
					<sj:submit id="submitThemeform" formIds="themeform" listenTopics="themeformTopic" cssStyle="display: none;"/>
                </div>
            </s:form>
        </div>
        <div id="headline">
	        <h1 class="ui-state-default" style="background: none; border: none;">Struts2 jQuery Plugin Showcase</h1>
	        <h4 class="ui-state-default" style="background: none; border: none;">Version <s:text name="showcase.version"/></h4>
        	<img id="myDefaultIndicator" src="images/ajax-loader.gif" alt="Loading..." style="display:none"/>
        </div>
      </div>
      <div id="nav">
        <div class="hlist ui-widget-header">
          <ul>
            <li class="ui-widget-header ui-state-active"><s:url var="urlremotelink" action="remote-link"/><sj:a id="remotelink" href="%{urlremotelink}" targets="main">Ajax Link</sj:a></li>
            <li class="ui-widget-header"><s:url var="urlform" action="form"/><sj:a id="formlink" href="%{urlform}" targets="main">Ajax Forms</sj:a></li>
            <li class="ui-widget-header"><s:url var="urlremotediv" action="remote-div"/><sj:a id="ajaxdivlink" href="%{urlremotediv}" targets="main">Ajax Div</sj:a></li>
            <li class="ui-widget-header"><s:url var="urltabs" action="tabs-local"/><sj:a id="tabslink" href="%{urltabs}" targets="main">Tabs</sj:a></li>
            <li class="ui-widget-header"><s:url var="urldatepicker" action="datepicker"/><sj:a id="dplink" href="%{urldatepicker}" targets="main">Datepicker</sj:a></li>
            <li class="ui-widget-header"><s:url var="urldialog" action="dialog"/><sj:a id="dialink" href="%{urldialog}" targets="main">Dialog</sj:a></li>
            <li class="ui-widget-header"><s:url var="urlaccordion" action="accordion"/><sj:a id="accordionlink" href="%{urlaccordion}" targets="main">Accordion</sj:a></li>
            <li class="ui-widget-header"><s:url var="urlautocompleter" action="autocompleter"/><sj:a id="autocompleterlink" href="%{urlautocompleter}" targets="main">Autocompleter</sj:a></li>
            <li class="ui-widget-header"><s:url var="urlslider" action="slider"/><sj:a id="sliderlink" href="%{urlslider}" targets="main">More Widgets</sj:a></li>
            <li class="ui-widget-header"><s:url var="urlgrid" action="grid"/><sj:a id="gridlink" href="%{urlgrid}" targets="main">Grid</sj:a></li>
            <li class="ui-widget-header"><s:url var="urleffectdiv" action="effect-div"/><sj:a id="interactionlink" href="%{urleffectdiv}" targets="main">Effects/Interactions</sj:a></li>
            <li class="ui-widget-header"><a href="http://code.google.com/p/struts2-jquery/downloads/list">Download</a></li>
            <li class="ui-widget-header"><a href="http://code.google.com/p/struts2-jquery/w/list">Wiki</a></li>
          </ul>
        </div>
      </div>
      <sj:div id="main" href="%{urlremotelink}">
        <img id="indicator" src="images/indicator.gif" alt="Loading..."/>
      </sj:div>
      <!-- begin: #footer -->
      <div id="footer">
        Written by  <a href="http://www.jgeppert.com" title="Java Developer Blog">Johannes Geppert</a><br/>
        Hosted by  <a href="http://www.weinfreund.de" title="Wein vom Weingut, Weinforum, Wein Community">weinfreund.de</a><br/>
        Layout based on <a href="http://www.yaml.de/" title="OpenSource CSS Layout">YAML</a>
      </div>
    </div>
  </div>
  <script type="text/javascript">
  //Make it possible to link to an specific site in the Showcase
  //e.g. and link to index.action?ajaxhistory=true#main=_sj_action_accordionlink
  //opens now the accordion examples
  jQuery(document).ready(function() {
  	 if (jQuery.struts2_jquery.ajaxhistory) {
  		 var topic = $.bbq.getState( 'main' );
  		 if(topic !== undefined && topic != '') {
  			 jQuery.publish(topic);
  		 }
  	 }
  });
  </script>
</body>
</html>
