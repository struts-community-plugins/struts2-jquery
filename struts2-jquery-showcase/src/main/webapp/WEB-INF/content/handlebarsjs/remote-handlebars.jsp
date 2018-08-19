<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjhb" uri="/struts-jquery-handlebarsjs-tags" %>

<h2>Remote Handlebars Template</h2>

<p class="text">
	A remote link that handle an JSON result from a AJAX action call within an onSuccessTopic, using a remote Handlebars.js template.
</p>
<strong>Result div:</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<s:url var="jsonurl" action="jsonlanguages"/>

<sj:a
	  id="ajaxjsonlink"
      href="%{jsonurl}"
      dataType="json"
      onSuccessTopics="runRemoteTemplate"
      indicator="indicator"
      button="true"
      buttonIcon="ui-icon-gear"
>
	Call AJAX action with JSON result
</sj:a>
<s:url value="/handlebarsjs/simple-template.hbs"   var="templateurl" />
<sjhb:handlebars listenTopics="runRemoteTemplate" templateName="test-remote" href="%{templateurl}" 
type="template"  targets="result" />

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="hbs" label="HandleBars"/>
	<div id="jsp">
	  <pre>
            <code class="html">
&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
&lt;s:url var=&quot;jsonurl&quot; action=&quot;jsonlanguages&quot;/&gt;

&lt;sj:a
	id=&quot;ajaxjsonlink&quot;
	href=&quot;%{jsonurl}&quot;
	dataType=&quot;json&quot;
	onSuccessTopics=&quot;runRemoteTemplate&quot;
	indicator=&quot;indicator&quot;
	button=&quot;true&quot;
	buttonIcon=&quot;ui-icon-gear&quot;
&gt;
	Call AJAX action with JSON result
&lt;/sj:a&gt;
&lt;s:url value=&quot;/handlebarsjs/simple-template.hbs&quot;   var=&quot;templateurl&quot; /&gt;
&lt;sjhb:handlebars listenTopics=&quot;runRemoteTemplate&quot; templateName=&quot;test-remote&quot; href=&quot;%{templateurl}&quot; 
type=&quot;template&quot;  targets=&quot;result&quot; /&gt;
&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
			</code>
	  </pre>
	</div>
	<div id="hbs">
	  <pre>
            <code class="html">
Hello from a remote Handlebar.js template !
&lt;ul&gt;
{{#each this}}
&lt;li&gt;{{this}}&lt;/li&gt;
{{/each}}
&lt;/ul&gt;
			</code>
	  </pre>
	</div>

</sj:tabbedpanel>
