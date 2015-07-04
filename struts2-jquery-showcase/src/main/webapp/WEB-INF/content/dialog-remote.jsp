<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Remote Dialog</h2>
    <p class="text">
        A Dialog with remote content.
    </p>
    <s:url var="ajax" value="/ajax1.action"/>
    <sj:dialog id="myremotedialog" href="%{ajax}" title="Dialog with remote content">
        <img id="indicator" src="images/indicator.gif" alt="Loading..."/>
    </sj:dialog>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
    <pre>
    <code class="html">
&lt;s:url id="ajax" value="/ajax1.action"/&gt;
&lt;sj:dialog id="myremotedialog" href="%{ajax}" title="Dialog with remote content"&gt;
    &lt;img id="indicator" src="images/indicator.gif" alt="Loading..."/&gt;
&lt;/sj:dialog&gt;
    </code>
    </pre>
</div>
