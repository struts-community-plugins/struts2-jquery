<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link with Bounce Effect</h2>

<p class="text">
	A Remote Link that bounce the target.
</p>
<strong>Result Div :</strong>

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
	Run AJAX Action
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
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
	  Run AJAX Action
	&lt;/sj:a&gt;
	  </pre>
</div>
