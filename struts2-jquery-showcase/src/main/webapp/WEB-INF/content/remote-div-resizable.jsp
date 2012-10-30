<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>A resizeable Remote Div</h2>

<p class="text">
	A Remote Div that load AJAX content and is resizeable.
</p>
<strong>Remote Div :</strong>
<s:url var="ajax" value="/ajax3.action"/>
<sj:div href="%{ajax}" indicator="indicator" resizable="true" resizableAnimate="true" resizableGhost="true"
        resizableHelper="ui-state-highlight" resizableAspectRatio="true" cssStyle="width: 250px; height: 180px;"
        cssClass="ui-widget-content ui-corner-all">
	<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
</sj:div>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="/ajax3.action"/&gt;
    &lt;sj:div href="%{ajax}" indicator="indicator" <strong>resizable="true" resizableAnimate="true"
		  resizableGhost="true" resizableHelper="ui-state-highlight" resizableAspectRatio="true"</strong> cssStyle="width: 250px; height: 180px;" cssClass="ui-widget-content ui-corner-all"&gt;
        &lt;img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>
