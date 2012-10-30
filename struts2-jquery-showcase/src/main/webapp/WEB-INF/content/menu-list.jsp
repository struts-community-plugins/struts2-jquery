<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Menu from List</h2>

<p class="text">
	A simple Menu generated from a List of Values.
</p>

<s:url var="echourl" action="echo"/>
<sj:menu
		id="menuStringList"
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
		id="menuMap"
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
		id=&quot;menuStringList&quot;
		href=&quot;%{echourl}&quot;
		paramName=&quot;echo&quot;
		targets=&quot;result&quot;
		cssStyle=&quot;width:50%&quot;
		list=&quot;\#{'Java', 'JavaScript', 'Scala', 'JRuby'}&quot;
		/&gt;
&lt;strong&gt;Result Div :&lt;/strong&gt;

&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;

&lt;h2&gt;Menu from Map&lt;/h2&gt;

&lt;p class=&quot;text&quot;&gt;
	A simple Menu generated from a Map of Values.
&lt;/p&gt;
&lt;sj:menu
		id=&quot;menuMap&quot;
		href=&quot;%{echourl}&quot;
		paramName=&quot;echo&quot;
		targets=&quot;result2&quot;
		cssStyle=&quot;width:50%&quot;
		list=&quot;\#{'J':'Java', 'JS':'JavaScript', 'S':'Scala', 'JR':'JRuby'}&quot;
		/&gt;

&lt;br/&gt;
&lt;strong&gt;Result Div :&lt;/strong&gt;

&lt;div id=&quot;result2&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;
    </pre>
</div>
