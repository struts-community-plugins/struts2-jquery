<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Remote Link with Highlight Effect</h2>

<p class="text">
	A Remote Link that highlight the target.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>

<s:url var="ajax" value="/ajax1.action"/>

<sj:a
		id="ajaxlink"
		href="%{ajax}"
		targets="result"
		effect="highlight"
		effectOptions="{ color : '#222222' }"
		effectDuration="3000"
		button="true"
		buttonIcon="ui-icon-gear"
		>
	Run AJAX Action
</sj:a>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
	&lt;s:url id=&quot;ajax&quot; value=&quot;/ajax1.action&quot;/&gt;
	
	&lt;sj:a 
		id=&quot;ajaxlink&quot; 
		href=&quot;%{ajax}&quot; 
		targets=&quot;result&quot; 
		effect=&quot;highlight&quot; 
		effectOptions=&quot;{ color : '#222222' }&quot; 
		effectDuration=&quot;3000&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
	&gt;
	  Run AJAX Action
	&lt;/sj:a&gt;
	  </pre>
</div>
</div>
