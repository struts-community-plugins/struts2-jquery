<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url var="urlremotelink" action="remote-link"/><sj:a id="remotesimplelink" href="%{urlremotelink}" targets="main">Remote Link</sj:a></li>
      <li><s:url var="urlremotelinktargets" action="remote-link-targets"/><sj:a id="remotetargetslink" href="%{urlremotelinktargets}" targets="main">Remote Link with 2 Targets</sj:a></li>
      <li><s:url var="urlremotelinkform" action="remote-link-form"/><sj:a id="remoteformlink" href="%{urlremotelinkform}" targets="main">Remote Link with Form submit</sj:a></li>
      <li><s:url var="urlremotelinkevent" action="remote-link-event"/><sj:a id="remoteeventlink" href="%{urlremotelinkevent}" targets="main">Remote Link with Event</sj:a></li>
      <li><s:url var="urlremotelinkhighlight" action="remote-link-highlight"/><sj:a id="remotehighlightlink" href="%{urlremotelinkhighlight}" targets="main">Remote Link Highlight Effect</sj:a></li>
      <li><s:url var="urlremotelinkbounce" action="remote-link-bounce"/><sj:a id="remotebouncelink" href="%{urlremotelinkbounce}" targets="main">Remote Link Bounce Effect</sj:a></li>
      <li><s:url var="urlremotelinkjson" action="remote-link-json"/><sj:a id="remotejsonlink" href="%{urlremotelinkjson}" targets="main">Remote Link with JSON Result</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Remote Link with Events</h2>
	<p class="text">
	    A Remote Link that raise Events befor and after request.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
    
	<s:url var="ajax" value="/ajax1.action"/>
	
	<sj:a 
		id="ajaxlink" 
		href="%{ajax}" 
		indicator="indicator" 
		targets="result" 
		onClickTopics="beforeLink" 
		onCompleteTopics="completeLink" 
		effect="pulsate" 
    	button="true" 
		buttonIcon="ui-icon-gear"
	>
	  Run AJAX Action
	</sj:a>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
    <br/>
    <br/>
    <sj:a 
    	id="ajaxlink2" 
    	href="file-does-not-exist.html" 
    	indicator="indicator2" 
    	targets="result" 
    	onClickTopics="beforeLink" 
    	onCompleteTopics="completeLink" 
    	onErrorTopics="errorStateLink" 
    	effect="pulsate" 
    	effectDuration="1500" 
    	button="true" 
		buttonIcon="ui-icon-gear"
    >
      Run AJAX Error Action
    </sj:a>
    <img id="indicator2" src="images/indicator.gif" alt="Loading..." style="display:none"/>    

	<div class="code ui-widget-content ui-corner-all">
      <strong>JavaScript functions:</strong>
      <pre>
       $.subscribe('beforeLink', function(event,data) {
           alert('Before request ');
           $('#result').html('Loading ...');
       });
       $.subscribe('completeLink', function(event,data) {
           $('#result').append('&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;Completed request '+event.originalEvent.request.statusText+' completed with '+event.originalEvent.status+ '.&lt;/strong&gt;&lt;br/&gt;Status: '+event.originalEvent.request.status);
       });
       $.subscribe('errorStateLink', function(event,data) {
           $('#result').html('&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;Error request '+event.originalEvent.request.statusText+' completed with '+event.originalEvent.status+ '.&lt;/strong&gt;&lt;br/&gt;Status: '+event.originalEvent.request.status);
       });
      </pre>
	  <strong>Code:</strong>
	  <pre>
	&lt;s:url id=&quot;ajax&quot; value=&quot;/ajax1.action&quot;/&gt;
	
	&lt;sj:a 
		id=&quot;ajaxlink&quot; 
		href=&quot;%{ajax}&quot; 
		indicator=&quot;indicator&quot; 
		targets=&quot;result&quot; 
		onClickTopics=&quot;before&quot; 
		onCompleteTopics=&quot;complete&quot; 
		effect=&quot;pulsate&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
	&gt;
	  Run AJAX Action
	&lt;/sj:a&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
    &lt;br/&gt;
    &lt;br/&gt;
    &lt;sj:a 
    	id=&quot;ajaxlink2&quot; 
    	href=&quot;file-does-not-exist.html&quot; 
    	indicator=&quot;indicator2&quot; 
    	targets=&quot;result&quot; 
    	onClickTopics=&quot;before&quot; 
    	onCompleteTopics=&quot;complete&quot; 
    	onErrorTopics=&quot;errorState&quot; 
    	effect=&quot;pulsate&quot; 
    	effectDuration=&quot;1500&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
    &gt;
      Run AJAX Error Action
    &lt;/sj:a&gt;
    &lt;img id=&quot;indicator2&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
      </pre>
    </div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>