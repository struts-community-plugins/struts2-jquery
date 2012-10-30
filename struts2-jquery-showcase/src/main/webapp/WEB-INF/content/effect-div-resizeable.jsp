<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Resizeable Div</h2>

<p class="text">
	A resizeable Div.
</p>
<strong>Div :</strong>
<sj:div resizable="true" resizableAnimate="true" resizableGhost="true" resizableHandles="all"
        cssClass="ui-widget-content ui-corner-all" cssStyle="width: 250px; height: 180px; padding: 0.5em;">
	Resize me!<br/>
	Resize me!<br/>
	Resize me!<br/>
</sj:div>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;sj:div resizable=&quot;true&quot; resizableAnimate=&quot;true&quot; resizableGhost=&quot;true&quot; resizableHandles=&quot;all&quot; cssClass=&quot;ui-widget-content ui-corner-all&quot; cssStyle=&quot;width: 250px; height: 180px; padding: 0.5em;&quot;&gt;
        Resize me!&lt;br/&gt;
        Resize me!&lt;br/&gt;
        Resize me!&lt;br/&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>
