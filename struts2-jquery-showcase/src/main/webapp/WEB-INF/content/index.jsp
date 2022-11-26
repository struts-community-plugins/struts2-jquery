<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="struts2, jquery, jquery-ui, plugin, showcase, jqgrid, datatables"/>
    <meta http-equiv="description" content="A Showcase for the Struts2 jQuery Plugin"/>

    <title>Struts2 jQuery Plugin Showcase - <s:text name="showcase.version"/></title>

    <s:if test="%{jqTheme == 'showcase' || jqTheme == null}">
        <sj:head debug="false" compressed="true" jquerytheme="showcase" customBasepath="themes"
                 loadFromCdn="%{cdn}" ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator"
                 defaultLoadingText="Please wait ..."/>
    </s:if>
    <s:else>
        <sj:head debug="false" compressed="true" jquerytheme="%{jqTheme}" loadFromCdn="%{cdn}"
                 ajaxhistory="%{ajaxhistory}" defaultIndicator="myDefaultIndicator"
                 defaultLoadingText="Please wait ..."/>
    </s:else>
    <s:url var="stylesBaseUrl" value="/styles"/>
    <s:link href="%{stylesBaseUrl}/flexible-grids.css" rel="stylesheet" type="text/css"/>
    <!--[if lte IE 7]>
    <s:link href="%{stylesBaseUrl}/yaml/core/iehacks.min.css" rel="stylesheet" type="text/css"/>
    <![endif]-->

    <s:url var="staticBaseUrl" value="/static"/>
    <!-- These files are needed for AJAX Validation of XHTML Forms -->
    <s:script type="text/javascript" src="%{staticBaseUrl}/utils.js"/>
    <s:script type="text/javascript" src="%{staticBaseUrl}/xhtml/validation.js"/>

    <s:url var="jsBaseUrl" value="/js"/>
    <!-- This file includes necessary functions/topics for validation and all topic examples -->
    <s:script type="text/javascript" src="%{jsBaseUrl}/showcase.js"/>
    <!-- Extend the Struts2 jQuery Plugin with a rich text editor -->
    <s:script type="text/javascript" src="%{jsBaseUrl}/extendplugin.js"/>

    <!-- source code formatting with highlight.js -->
    <s:link rel="stylesheet" type="text/css" href="%{stylesBaseUrl}/github-gist.css"/>
    <s:script type="text/javascript" src="%{jsBaseUrl}/highlight.pack.js"/>
</head>
<body>

<header class="ui-widget-header">
    <div class="ym-wrapper">
        <div class="ym-wbox">
            <div class="ym-grid linearize-level-1">
                <div class="ym-g75 ym-gl">
                    <h1 class="ui-state-default" style="background: none; border: none; margin: 0;">Struts2 jQuery
                        Plugin Showcase</h1>
                    <h4 class="ui-state-default" style="background: none; border: none;">Version <s:text
                            name="showcase.version"/></h4>
                </div>
                <div id="themebox" class="ym-g25 ym-gr">
                    <s:form id="themeform" action="index" theme="simple">
                        <div>
                            <s:select id="selected_theme" name="theme" list="themes" emptyOption="true"
                                      onchange="changeTheme(this.value);"/><br/>
                            <s:checkbox id="cdn" name="cdn" onclick="$.publish('themeformTopic');"/><label
                                for="cdn" style="padding: 3px;">Load jQuery from JQuery CDN</label><br/>
                            <s:checkbox id="ajaxhistory" name="ajaxhistory"
                                        onclick="$.publish('themeformTopic');"/><label for="ajaxhistory"
                                                                                       style="padding: 3px;">Use
                            Ajaxhistory (BETA)</label><br/>
                            <sj:submit id="submitThemeform" formIds="themeform" listenTopics="themeformTopic"
                                       cssStyle="display: none;"/>
                        </div>
                    </s:form>
                    <img id="myDefaultIndicator" src="images/ajax-loader.gif" alt="Loading..." style="display:none"/>
                </div>
            </div>
        </div>
    </div>
</header>

<nav id="nav" class="ui-widget-header">
    <div class="ym-wrapper">
        <div class="ym-hlist ui-widget-header">
            <ul id="navlist">
                <li><s:url var="menuurl" action="showcase-menu-ajax" namespace="/"/><sj:a id="ajaxmenulink"
                                                                                          href="%{menuurl}"
                                                                                          targets="menu">Ajax</sj:a></li>
                <li><s:url var="widgetsurl" action="showcase-menu-widgets" namespace="/"/><sj:a id="widgetsmenulink"
                                                                                                href="%{widgetsurl}"
                                                                                                targets="menu">Widgets</sj:a></li>
                <li><s:url var="effectsurl" action="showcase-menu-effects" namespace="/"/><sj:a id="effectsmenulink"
                                                                                                href="%{effectsurl}"
                                                                                                targets="menu">Effects / Interactions</sj:a></li>
                <li><a href="https://oss.sonatype.org/content/groups/staging/com/jgeppert/struts2/jquery/">Download</a></li>
                <li><a href="http://code.google.com/p/struts2-jquery/w/list">Wiki</a></li>
            </ul>
        </div>
    </div>
</nav>


<main id="main">
    <div class="ym-wrapper">
        <div class="ym-wbox">
            <section class="ym-grid">
                <aside class="ym-g25 ym-gl">
                    <s:url var="menuurl" action="showcase-menu-ajax" namespace="/"/>
                    <sj:div id="menu" href="%{menuurl}" cssClass="">
                    </sj:div>
                </aside>
                <article class="ym-g75 ym-gr">
                    <s:url var="remotelinkurl" action="remote-link" namespace="/"/>
                    <sj:div id="content" href="%{remotelinkurl}" cssClass="ym-wbox">
                    </sj:div>
                </article>
            </section>
        </div>
    </div>
</main>
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
