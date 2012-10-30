<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link</h2>

<p class="text">
	A simple Remote Link with indicator.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<s:url var="ajax" value="/ajax1.action"/>

<sj:a id="ajaxlink"
      href="%{ajax}"
      targets="result"
      indicator="indicator"
      button="true"
      buttonIcon="ui-icon-refresh"
		>
	Run AJAX Action
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="ajax1.action"/&gt;
    
	&lt;sj:a id=&quot;ajaxlink&quot; 
		href=&quot;%{ajax}&quot; 
		targets=&quot;result&quot; 
		indicator=&quot;indicator&quot; 
		button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-refresh&quot;
	&gt;
	  	Run AJAX Action
	&lt;/sj:a&gt;
	  </pre>
</div>