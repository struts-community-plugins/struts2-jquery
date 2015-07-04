<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link with Events</h2>

<p class="text">
	A remote link that raise events before and after the request.
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
	Run AJAX action
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
	Run AJAX error action
</sj:a>
<img id="indicator2" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<sj:tabbedpanel id="localtabs" cssClass="list">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="java" label="JavaScript"/>
	<div id="jsp">
	  <pre>
            <code class="html">
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
	Run AJAX action
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
Run AJAX error action
&lt;/sj:a&gt;
&lt;img id=&quot;indicator2&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
			</code>
	  </pre>
	</div>
	<div id="java">
	  <pre>
            <code class="javascript">
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
			</code>
	  </pre>
	</div>

</sj:tabbedpanel>
