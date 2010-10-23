<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlremotelink" action="remote-link"/><sj:a id="remotesimplelink" href="%{urlremotelink}" targets="main">Remote Link</sj:a></li>
      <li><s:url id="urlremotelinktargets" action="remote-link-targets"/><sj:a id="remotetargetslink" href="%{urlremotelinktargets}" targets="main">Remote Link with 2 Targets</sj:a></li>
      <li><s:url id="urlremotelinkform" action="remote-link-form"/><sj:a id="remoteformlink" href="%{urlremotelinkform}" targets="main">Remote Link with Form submit</sj:a></li>
      <li><s:url id="urlremotelinkevent" action="remote-link-event"/><sj:a id="remoteeventlink" href="%{urlremotelinkevent}" targets="main">Remote Link with Event</sj:a></li>
      <li><s:url id="urlremotelinkhighlight" action="remote-link-highlight"/><sj:a id="remotehighlightlink" href="%{urlremotelinkhighlight}" targets="main">Remote Link Highlight Effect</sj:a></li>
      <li><s:url id="urlremotelinkbounce" action="remote-link-bounce"/><sj:a id="remotebouncelink" href="%{urlremotelinkbounce}" targets="main">Remote Link Bounce Effect</sj:a></li>
      <li><s:url id="urlremotelinkjson" action="remote-link-json"/><sj:a id="remotejsonlink" href="%{urlremotelinkjson}" targets="main">Remote Link with JSON Result</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Remote Link with JSON Result</h2>
	<p class="text">
	    A Remote Link that handle an JSON Result with an onSuccessTopic.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
	<s:url id="jsonurl" action="jsonlanguages"/>

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
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
