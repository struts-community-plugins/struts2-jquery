<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Div with Listen Topics</h2>

<p class="text">
	A Remote Div that load AJAX content with Listen Topics.
</p>
<s:url var="ajax1" value="/ajax1.action"/>
<s:url var="ajax2" value="/ajax2.action"/>
<strong>Div with listen Topics:</strong>
<sj:div
		id="resultdiv1"
		href="%{ajax1}"
		deferredLoading="true"
		indicator="indicator1"
		listenTopics="loaddiv1"
		effect="highlight"
		effectDuration="1000"
		cssClass="result ui-widget-content ui-corner-all">
	<img id="indicator1" src="images/indicator.gif" alt="Loading..." style="display:none"/>
</sj:div>

<sj:a id="listenanchor"
      indicator="indicator2"
      href="%{ajax2}"
      targets="resultdiv2"
      listenTopics="loaddiv2"
      effect="highlight"
      effectDuration="1000"
      button="true"
      buttonIcon="ui-icon-gear"
		>
	Ajax Link
</sj:a>
<img id="indicator2" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div id="resultdiv2" class="result ui-widget-content ui-corner-all">
	Result of Ajax Link.
</div>
<s:form id="listenTopicForm" action="ajax3">
	<sj:submit id="listensubmit"
	           indicator="indicator3"
	           targets="resultdiv3"
	           listenTopics="loaddiv3"
	           effect="highlight"
	           effectDuration="1000"
	           button="true"
			/>
</s:form>
<img id="indicator3" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div id="resultdiv3" class="result ui-widget-content ui-corner-all">
	Result of Ajax Submit.
</div>

<sj:a
		id="publishanchor"
		href="#"
		onClickTopics="loaddiv1,loaddiv2,loaddiv3"
		button="true"
		buttonIcon="ui-icon-gear"
		>
	This Link publishs the Topics
</sj:a>

<div class="code ui-widget-content ui-corner-all">
      <pre>
    &lt;s:url id=&quot;ajax1&quot; value=&quot;/ajax1.action&quot;/&gt;
    &lt;s:url id=&quot;ajax2&quot; value=&quot;/ajax2.action&quot;/&gt;
    &lt;strong&gt;Div with listen Topics:&lt;/strong&gt;
    &lt;sj:div 
    	id=&quot;resultdiv1&quot; 
    	href=&quot;%{ajax2}&quot; 
    	indicator=&quot;indicator1&quot; 
    	listenTopics=&quot;loaddiv1&quot; 
    	effect=&quot;highlight&quot; 
    	effectDuration=&quot;1000&quot; 
    	cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
        &lt;img id=&quot;indicator1&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
    &lt;/sj:div&gt;

    &lt;sj:a id=&quot;listenanchor&quot; 
	    indicator=&quot;indicator2&quot; 
	    href=&quot;%{ajax1}&quot; 
	    targets=&quot;resultdiv2&quot; 
	    listenTopics=&quot;loaddiv2&quot; 
	    effect=&quot;highlight&quot; 
	    effectDuration=&quot;1000&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
	&gt;
    	Ajax Link
    &lt;/sj:a&gt;
    &lt;div id=&quot;resultdiv2&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;
    	Result of Ajax Link.
        &lt;img id=&quot;indicator2&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
    &lt;/div&gt;
    
    &lt;sj:a 
    	id=&quot;publishanchor&quot; 
    	href=&quot;#&quot; 
    	onClickTopics=&quot;loaddiv1,loaddiv2&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
    	&gt;
    	This Link publishs the Topics
    &lt;/sj:a&gt;
	  </pre>
</div>
