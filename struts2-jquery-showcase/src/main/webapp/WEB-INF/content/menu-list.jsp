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
    <h2>Menu from List</h2>
    <p class="text">
        A simple Menu generated from a List of Values.
    </p>

	  <s:url var="echourl" action="echo"/>
	  <sj:menu
		id="menu"
		href="%{echourl}"
		paramName="echo"
		targets="result"
		cssStyle="width:50%"
		list="#{'Java', 'JavaScript', 'Scala', 'JRuby'}"
	/>
	  <strong>Result Div :</strong>
	  <div id="result" class="result ui-widget-content ui-corner-all">Click on the AJAX Links above.</div>

	  <h2>Menu from Map</h2>
	  <p class="text">
		  A simple Menu generated from a Map of Values.
	  </p>
	  <sj:menu
			  id="menu2"
			  href="%{echourl}"
			  paramName="echo"
			  targets="result2"
			  cssStyle="width:50%"
			  list="#{'J':'Java', 'JS':'JavaScript', 'S':'Scala', 'JR':'JRuby'}"
			  />

	  <br/>
	  <strong>Result Div :</strong>
	  <div id="result2" class="result ui-widget-content ui-corner-all">Click on the AJAX Links above.</div>


	  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;h2&gt;Menu from List&lt;/h2&gt;
    &lt;p class=&quot;text&quot;&gt;
        A simple Menu generated from a List of Values.
    &lt;/p&gt;

	  &lt;s:url var=&quot;echourl&quot; action=&quot;echo&quot;/&gt;
	  &lt;sj:menu
		id=&quot;menu&quot;
		href=&quot;%{echourl}&quot;
		paramName=&quot;echo&quot;
		targets=&quot;result&quot;
		cssStyle=&quot;width:50%&quot;
		list=&quot;#{'Java', 'JavaScript', 'Scala', 'JRuby'}&quot;
	/&gt;
	  &lt;strong&gt;Result Div :&lt;/strong&gt;
	  &lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;

	  &lt;h2&gt;Menu from Map&lt;/h2&gt;
	  &lt;p class=&quot;text&quot;&gt;
		  A simple Menu generated from a Map of Values.
	  &lt;/p&gt;
	  &lt;sj:menu
			  id=&quot;menu2&quot;
			  href=&quot;%{echourl}&quot;
			  paramName=&quot;echo&quot;
			  targets=&quot;result2&quot;
			  cssStyle=&quot;width:50%&quot;
			  list=&quot;#{'J':'Java', 'JS':'JavaScript', 'S':'Scala', 'JR':'JRuby'}&quot;
			  /&gt;

	  &lt;br/&gt;
	  &lt;strong&gt;Result Div :&lt;/strong&gt;
	  &lt;div id=&quot;result2&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
  </div>
</div>
