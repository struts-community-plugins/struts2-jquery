<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjhb" uri="/struts-jquery-handlebarsjs-tags" %>

<h2>Local Handlebars Template</h2>

<p class="text">
	A remote link that handle an JSON result from a AJAX action call within an onSuccessTopic, using a local Handlebars.js template.
</p>
<strong>Result div:</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<s:url var="jsonurl" action="jsonlanguages"/>

<sj:a
	  id="ajaxjsonlink"
      href="%{jsonurl}"
      dataType="json"
      onSuccessTopics="runTemplate"
      indicator="indicator"
      button="true"
      buttonIcon="ui-icon-gear"
>
	Call AJAX action with JSON result
</sj:a>
<sjhb:handlebars listenTopics="runTemplate" templateName="test" targets="result" >
Hello from Handlebar.js template !
<ul>
{{#each this}}
<li>{{this}}</li>
{{/each}}
</ul>
<li></li>
</sjhb:handlebars>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<div id="jsp">
	  <pre>
            <code class="html">
&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
&lt;s:url var=&quot;jsonurl&quot; action=&quot;jsonlanguages&quot;/&gt;

&lt;sj:a
	id=&quot;ajaxjsonlink&quot;
	href=&quot;%{jsonurl}&quot;
	dataType=&quot;json&quot;
	onSuccessTopics=&quot;runTemplate&quot;
	indicator=&quot;indicator&quot;
	button=&quot;true&quot;
	buttonIcon=&quot;ui-icon-gear&quot;
&gt;
	Call AJAX action with JSON result
&lt;/sj:a&gt;
&lt;sjhb:handlebars listenTopics=&quot;runTemplate&quot; templateName=&quot;test&quot; targets=&quot;result&quot; &lt
Hello from Handlebar.js template !
&lt;ul&gt;
{{#each this}}
&lt;li>{{this}}&lt;/li&gt;
{{/each}}
&lt;/ul&gt;
&lt;li>&lt;/li&gt;
&lt/sjhb:handlebars&gt;
&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
			</code>
	  </pre>
	</div>
</sj:tabbedpanel>
