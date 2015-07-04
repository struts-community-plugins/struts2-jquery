<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Remote Link with JSON Result</h2>

<p class="text">
	A remote link that handle an JSON result from a AJAX action call within an onSuccessTopic.
</p>
<strong>Result div:</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<s:url var="jsonurl" action="jsonlanguages"/>

<sj:a
	  id="ajaxjsonlink"
      href="%{jsonurl}"
      dataType="json"
      onSuccessTopics="handleJsonResult"
      indicator="indicator"
      button="true"
      buttonIcon="ui-icon-gear"
>
	Call AJAX action with JSON result
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="java" label="JavaScript"/>
	<div id="jsp">
	  <pre>
            <code class="html">
&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
&lt;s:url var=&quot;jsonurl&quot; action=&quot;jsonlanguages&quot;/&gt;

&lt;sj:a
	id=&quot;ajaxjsonlink&quot;
	href=&quot;%{jsonurl}&quot;
	dataType=&quot;json&quot;
	onSuccessTopics=&quot;handleJsonResult&quot;
	indicator=&quot;indicator&quot;
	button=&quot;true&quot;
	buttonIcon=&quot;ui-icon-gear&quot;
&gt;
	Call AJAX action with JSON result
&lt;/sj:a&gt;
&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
			</code>
	  </pre>
	</div>
	<div id="java">
	  <pre>
            <code class="javascript">
$.subscribe('handleJsonResult', function(event,data) {
	$('#result').html(&quot;&lt;ul id='languagesList'&gt;&lt;/ul&gt;&quot;);
	var list = $('#languagesList');
	$.each(event.originalEvent.data, function(index, value) {
		list.append('&lt;li&gt;'+value+'&lt;/li&gt;\n');
	});
});

			</code>
	  </pre>
	</div>

</sj:tabbedpanel>
