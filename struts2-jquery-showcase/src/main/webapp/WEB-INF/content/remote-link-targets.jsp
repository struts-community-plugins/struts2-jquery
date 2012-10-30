<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link with two Targets</h2>

<p class="text">
	A Remote Link that updates two targets.
</p>
<strong>Result Div 1 :</strong>

<div id="result1" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<strong>Result Div 2 :</strong>

<div id="result2" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>

<s:url var="ajax" value="/ajax3.action"/>
<sj:a
		id="ajaxlink"
		href="%{ajax}"
		targets="result1,result2"
		button="true"
		buttonIcon="ui-icon-gear"
		buttonText="false"
		>
	Run AJAX Action
</sj:a>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;strong&gt;Result Div 1 :&lt;/strong&gt;
	&lt;div id=&quot;result1&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
    &lt;strong&gt;Result Div 2 :&lt;/strong&gt;
    &lt;div id=&quot;result2&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
    
	&lt;s:url id=&quot;ajax&quot; value=&quot;/ajax3.action&quot;/&gt;
    &lt;sj:a 
    	id=&quot;ajaxlink&quot; 
    	href=&quot;%{ajax}&quot; 
    	targets=&quot;result1,result2&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
		buttonText=&quot;false&quot;
    &gt;
      Run AJAX Action
    &lt;/sj:a&gt;
	  </pre>
</div>
