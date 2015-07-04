<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link with Bounce Effect</h2>

<p class="text">
	A remote link that load the result from a action to a specified div and execute a bounce effect after load on the  the target div.
</p>
<strong>Result div:</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>

<s:url var="ajax" value="/ajax1.action"/>

<sj:a
		id="ajaxlink"
		href="%{ajax}"
		indicator="indicator"
		targets="result"
		effect="bounce"
		effectDuration="2200"
		effectOptions="{}"
		button="true"
		buttonIcon="ui-icon-gear"
>
	Run AJAX action
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;s:url id=&quot;ajax&quot; value=&quot;/ajax1.action&quot;/&gt;

&lt;sj:a
	id=&quot;ajaxlink&quot;
	href=&quot;%{ajax}&quot;
	indicator=&quot;indicator&quot;
	targets=&quot;result&quot;
	effect=&quot;bounce&quot;
	effectDuration=&quot;2200&quot;
	button=&quot;true&quot;
	buttonIcon=&quot;ui-icon-gear&quot;
&gt;
  Run AJAX action
&lt;/sj:a&gt;
			</code>
	  </pre>
</div>
