<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Div with Pulsate Effect</h2>

<p class="text">
	A Remote Div that load AJAX content after an delay of 3000 milliseconds. After loading the Pulsate effect is
	executed.
</p>
<strong>Remote Div :</strong>
<s:url var="ajax" value="/ajax1.action"/>
<sj:div
		id="pulsatingdiv"
		delay="3000"
		href="%{ajax}"
		indicator="indicatorpuls"
		effect="pulsate"
		effectDuration="1500"
		cssClass="result ui-widget-content ui-corner-all"
		>
	<img id="indicatorpuls" src="images/indicator.gif" alt="Loading..."/>
</sj:div>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="/ajax1.action"/&gt;
    &lt;sj:div
    	id=&quot;pulsatingdiv&quot;
    	delay=&quot;3000&quot; 
    	href=&quot;%{ajax}&quot; 
    	indicator=&quot;indicatorpuls&quot; 
    	effect=&quot;pulsate&quot; 
    	effectDuration=&quot;1500&quot; 
    	cssClass=&quot;result ui-widget-content ui-corner-all&quot;
    &gt;
        &lt;img id=&quot;indicatorpuls&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot;/&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>
