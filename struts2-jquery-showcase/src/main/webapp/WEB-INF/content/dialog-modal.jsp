<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Modal Dialog</h2>
    <p class="text">
        A modal Dialog with remote content.
    </p>
    <s:url var="ajax" value="/ajax2.action"/>
    <sj:dialog 
    	id="mymodaldialog" 
    	href="%{ajax}" 
    	modal="true"
    	title="Modal Dialog"
    	position="{
            my: 'right top',
            at: 'right-200 top+100'
        }"
    >
        <img id="indicator" src="images/indicator.gif" alt="Loading..."/>
    </sj:dialog>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
    <pre>
    <code class="html">
&lt;sj:dialog
    id=&quot;mymodaldialog&quot;
    href=&quot;%{ajax}&quot;
    modal=&quot;true&quot;
    title=&quot;Modal Dialog&quot;
    position=&quot;['right','top']&quot;
&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot;/&gt;
&lt;/sj:dialog&gt;
    </code>
    </pre>
</div>
