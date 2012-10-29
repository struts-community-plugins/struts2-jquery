<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
	    <li><s:url var="urlmenu" action="menu"/><sj:a href="%{urlmenu}" targets="main">Menu with Items</sj:a></li>
	    <li><s:url var="urlmenulist" action="menu-list"/><sj:a href="%{urlmenulist}" targets="main">Menu from List</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Menu with Items</h2>
    <p class="text">
        A Menu with Menu Items and Submenus.
    </p>

	<sj:menu id="menuWithItems" cssStyle="width:50%">
		<sj:menuItem title="Struts2" href="http://struts.apache.org/2.x/index.html"/>
		<sj:menuItem title="Struts2 jQuery News" href="http://www.jgeppert.com/category/java/struts2-jquery/"/>
		<sj:menuItem title="Struts2 Plugins">
			<sj:menu id="subMenuPlugins">
				<sj:menuItem title="Struts2 Plugins" href="https://cwiki.apache.org/S2PLUGINS/home.html"/>
				<sj:menuItem title="Struts2 jQuery Plugin" href="http://code.google.com/p/struts2-jquery/"/>
				<sj:menuItem title="Struts2 Bootstrap Plugin" href="http://code.google.com/p/struts2-jquery/"/>
			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="Struts2 @ Social Media">
			<sj:menu id="subMenuSocialMedia">
				<sj:menuItem title="Struts2 @ Twitter" href="https://twitter.com/TheApacheStruts"/>
				<sj:menuItem title="Struts2 @ Google+" href="https://www.google.com/+ApacheStruts"/>
				<sj:menuItem title="Struts2 @ Facebook" href="http://www.facebook.com/struts2"/>
			</sj:menu>
		</sj:menuItem>

		<sj:menuItem title="AJAX">
			<sj:menu id="subMenuAjax">
				<s:url var="ajax1" value="/ajax1.action"/>
				<sj:menuItem title="Ajax 1" href="%{ajax1}" targets="result"/>
				<s:url var="ajax2" value="/ajax2.action"/>
				<sj:menuItem title="Ajax 2" href="%{ajax2}" targets="result" effect="highlight" effectDuration="2500"/>
				<s:url var="ajax3" value="/ajax3.action"/>
				<sj:menuItem title="Ajax 3" href="%{ajax3}" targets="result" onBeforeTopics="beforeLink" onCompleteTopics="completeLink"/>
				<s:url var="ajax4" value="/ajax4.action"/>
				<sj:menuItem title="Ajax 4" href="%{ajax4}" targets="result" effect="bounce" effectDuration="1000"/>
			</sj:menu>
		</sj:menuItem>
	</sj:menu>

	<br/>
	<strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Click on the AJAX Links above.</div>


	<div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
	&lt;sj:menu id=&quot;menuWithItems&quot; cssStyle=&quot;width:50%&quot;&gt;
		&lt;sj:menuItem title=&quot;Struts2&quot; href=&quot;http://struts.apache.org/2.x/index.html&quot;/&gt;
		&lt;sj:menuItem title=&quot;Struts2 jQuery News&quot; href=&quot;http://www.jgeppert.com/category/java/struts2-jquery/&quot;/&gt;
		&lt;sj:menuItem title=&quot;Struts2 Plugins&quot;&gt;
			&lt;sj:menu id=&quot;subMenuPlugins&quot;&gt;
				&lt;sj:menuItem title=&quot;Struts2 Plugins&quot; href=&quot;https://cwiki.apache.org/S2PLUGINS/home.html&quot;/&gt;
				&lt;sj:menuItem title=&quot;Struts2 jQuery Plugin&quot; href=&quot;http://code.google.com/p/struts2-jquery/&quot;/&gt;
				&lt;sj:menuItem title=&quot;Struts2 Bootstrap Plugin&quot; href=&quot;http://code.google.com/p/struts2-jquery/&quot;/&gt;
			&lt;/sj:menu&gt;
		&lt;/sj:menuItem&gt;

		&lt;sj:menuItem title=&quot;Struts2 @ Social Media&quot;&gt;
			&lt;sj:menu id=&quot;subMenuSocialMedia&quot;&gt;
				&lt;sj:menuItem title=&quot;Struts2 @ Twitter&quot; href=&quot;https://twitter.com/TheApacheStruts&quot;/&gt;
				&lt;sj:menuItem title=&quot;Struts2 @ Google+&quot; href=&quot;https://www.google.com/+ApacheStruts&quot;/&gt;
				&lt;sj:menuItem title=&quot;Struts2 @ Facebook&quot; href=&quot;http://www.facebook.com/struts2&quot;/&gt;
			&lt;/sj:menu&gt;
		&lt;/sj:menuItem&gt;

		&lt;sj:menuItem title=&quot;AJAX&quot;&gt;
			&lt;sj:menu id=&quot;subMenuAjax&quot;&gt;
				&lt;s:url var=&quot;ajax1&quot; value=&quot;/ajax1.action&quot;/&gt;
				&lt;sj:menuItem title=&quot;Ajax 1&quot; href=&quot;%{ajax1}&quot; targets=&quot;result&quot;/&gt;
				&lt;s:url var=&quot;ajax2&quot; value=&quot;/ajax2.action&quot;/&gt;
				&lt;sj:menuItem title=&quot;Ajax 2&quot; href=&quot;%{ajax2}&quot; targets=&quot;result&quot; effect=&quot;highlight&quot; effectDuration=&quot;2500&quot;/&gt;
				&lt;s:url var=&quot;ajax3&quot; value=&quot;/ajax3.action&quot;/&gt;
				&lt;sj:menuItem title=&quot;Ajax 3&quot; href=&quot;%{ajax3}&quot; targets=&quot;result&quot; onBeforeTopics=&quot;beforeLink&quot; onCompleteTopics=&quot;completeLink&quot;/&gt;
				&lt;s:url var=&quot;ajax4&quot; value=&quot;/ajax4.action&quot;/&gt;
				&lt;sj:menuItem title=&quot;Ajax 4&quot; href=&quot;%{ajax4}&quot; targets=&quot;result&quot; effect=&quot;bounce&quot; effectDuration=&quot;1000&quot;/&gt;
			&lt;/sj:menu&gt;
		&lt;/sj:menuItem&gt;
	&lt;/sj:menu&gt;

	&lt;br/&gt;
	&lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;
    </pre>
    </div>
	</div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
