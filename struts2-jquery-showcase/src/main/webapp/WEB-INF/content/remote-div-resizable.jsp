<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>A resizeable Remote Div</h2>

<p class="text">
	A remote div that load AJAX content from struts2 action and which is resizeable.
</p>
<strong>Remote div:</strong>
<s:url var="ajax" value="/ajax3.action"/>
<sj:div
        href="%{ajax}"
        indicator="indicator"
        resizable="true"
        resizableAnimate="true"
        resizableGhost="true"
        resizableHelper="ui-state-highlight"
        resizableAspectRatio="true"
        cssStyle="width: 250px; height: 180px;"
        cssClass="ui-widget-content ui-corner-all"
>
	<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
</sj:div>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;s:url var=&quot;ajax&quot; value=&quot;/ajax3.action&quot;/&gt;
&lt;sj:div
    href=&quot;%{ajax}&quot;
    indicator=&quot;indicator&quot;
    resizable=&quot;true&quot;
    resizableAnimate=&quot;true&quot;
    resizableGhost=&quot;true&quot;
    resizableHelper=&quot;ui-state-highlight&quot;
    resizableAspectRatio=&quot;true&quot;
    cssStyle=&quot;width: 250px; height: 180px;&quot;
    cssClass=&quot;ui-widget-content ui-corner-all&quot;
&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
&lt;/sj:div&gt;ode>
            </code>
	  </pre>
</div>
