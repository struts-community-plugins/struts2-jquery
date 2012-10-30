<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<h2>Remote Div</h2>

<p class="text">
	A simple Remote Div that load AJAX content.
</p>
<strong>Remote Div :</strong>
<s:url var="ajax" value="/ajax1.action"/>
<sj:div href="%{ajax}" indicator="indicator" cssClass="result ui-widget-content ui-corner-all">
	<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
</sj:div>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="/ajax1.action"/&gt;
    &lt;sj:div href="%{ajax}" indicator="indicator"&gt;
        &lt;img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>

