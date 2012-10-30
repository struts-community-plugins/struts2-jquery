<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Remote Link with JSON Result</h2>

<p class="text">
	A Remote Link that handle an JSON Result with an onSuccessTopic.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
<s:url var="jsonurl" action="jsonlanguages"/>

<sj:a id="ajaxjsonlink"
      href="%{jsonurl}"
      dataType="json"
      onSuccessTopics="handleJsonResult"
      indicator="indicator"
      button="true"
      buttonIcon="ui-icon-gear"
		>
	Run AJAX Action with JSON Result
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>JavaScript:</strong>
	  <pre>
    $.subscribe('handleJsonResult', function(event,data) {
        $('#result').html(&quot;&lt;ul id='languagesList'&gt;&lt;/ul&gt;&quot;);
        var list = $('#languagesList');
		$.each(event.originalEvent.data, function(index, value) {
			list.append('&lt;li&gt;'+value+'&lt;/li&gt;\n');
		});
    });
	  </pre>
	<strong>JSP Code:</strong>
	  <pre>
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
	&lt;s:url id=&quot;jsonurl&quot; action=&quot;jsonlanguages&quot;/&gt;

	&lt;sj:a id=&quot;ajaxjsonlink&quot;
		href=&quot;%{jsonurl}&quot;
		dataType=&quot;json&quot;
		onSuccessTopics=&quot;handleJsonResult&quot;
		indicator=&quot;indicator&quot;
		button=&quot;true&quot;
		buttonIcon=&quot;ui-icon-gear&quot;
	&gt;
	  	Run AJAX Action with JSON Rsult
	&lt;/sj:a&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
	  </pre>
</div>
