<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<h2>Remote div</h2>

<p class="text">
	A simple remote div that load AJAX content from a struts2 action.
</p>
<strong>Remote div:</strong>
<s:url var="ajax" value="/ajax1.action"/>
<sj:div
		href="%{ajax}"
		indicator="indicator"
		cssClass="result ui-widget-content ui-corner-all"
>
	<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
</sj:div>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;s:url var=&quot;ajax&quot; value=&quot;/ajax1.action&quot;/&gt;
&lt;sj:div
	href=&quot;%{ajax}&quot;
	indicator=&quot;indicator&quot;
	cssClass=&quot;result ui-widget-content ui-corner-all&quot;
&gt;
	&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
&lt;/sj:div&gt;
			</code>
	  </pre>
</div>

