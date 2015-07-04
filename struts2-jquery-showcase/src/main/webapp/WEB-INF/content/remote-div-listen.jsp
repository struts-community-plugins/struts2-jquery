<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Div with Listen Topics</h2>

<p class="text">
	A remote div that load AJAX content triggered by listen topics from a struts2 action.
</p>
<s:url var="ajax1" value="/ajax1.action"/>
<s:url var="ajax2" value="/ajax2.action"/>
<strong>Div that listen to topic <i>loaddiv1</i>:</strong>
<sj:div
		id="resultdiv1"
		href="%{ajax1}"
		deferredLoading="true"
		indicator="indicator1"
		listenTopics="loaddiv1"
		effect="highlight"
		effectDuration="1000"
		cssClass="result ui-widget-content ui-corner-all"
>
	<img id="indicator1" src="images/indicator.gif" alt="Loading..." style="display:none"/>
</sj:div>

<sj:a
      id="listenanchor"
      indicator="indicator2"
      href="%{ajax2}"
      targets="resultdiv2"
      listenTopics="loaddiv2"
      effect="highlight"
      effectDuration="1000"
      button="true"
      buttonIcon="ui-icon-gear"
>
	Ajax link that trigger loaddiv2
</sj:a>
<img id="indicator2" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div id="resultdiv2" class="result ui-widget-content ui-corner-all">
	Result div for AJAX link.
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
	Result div for AJAX submit button.
</div>

<sj:a
		id="publishanchor"
		href="#"
		onClickTopics="loaddiv1,loaddiv2,loaddiv3"
		button="true"
		buttonIcon="ui-icon-gear"
>
	This link publish all three topics
</sj:a>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;s:url var=&quot;ajax1&quot; value=&quot;/ajax1.action&quot;/&gt;
&lt;s:url var=&quot;ajax2&quot; value=&quot;/ajax2.action&quot;/&gt;
&lt;strong&gt;Div that listen to topic &lt;i&gt;loaddiv1&lt;/i&gt;:&lt;/strong&gt;
&lt;sj:div
    id=&quot;resultdiv1&quot;
    href=&quot;%{ajax1}&quot;
    deferredLoading=&quot;true&quot;
    indicator=&quot;indicator1&quot;
    listenTopics=&quot;loaddiv1&quot;
    effect=&quot;highlight&quot;
    effectDuration=&quot;1000&quot;
    cssClass=&quot;result ui-widget-content ui-corner-all&quot;
&gt;
    &lt;img id=&quot;indicator1&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
&lt;/sj:div&gt;

&lt;sj:a
    id=&quot;listenanchor&quot;
    indicator=&quot;indicator2&quot;
    href=&quot;%{ajax2}&quot;
    targets=&quot;resultdiv2&quot;
    listenTopics=&quot;loaddiv2&quot;
    effect=&quot;highlight&quot;
    effectDuration=&quot;1000&quot;
    button=&quot;true&quot;
    buttonIcon=&quot;ui-icon-gear&quot;
&gt;
    Ajax link that trigger loaddiv2
&lt;/sj:a&gt;
&lt;img id=&quot;indicator2&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;

&lt;div id=&quot;resultdiv2&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;
    Result div for AJAX link.
&lt;/div&gt;

&lt;s:form id=&quot;listenTopicForm&quot; action=&quot;ajax3&quot;&gt;
&lt;sj:submit
    id=&quot;listensubmit&quot;
    indicator=&quot;indicator3&quot;
    targets=&quot;resultdiv3&quot;
    listenTopics=&quot;loaddiv3&quot;
    effect=&quot;highlight&quot;
    effectDuration=&quot;1000&quot;
    button=&quot;true&quot;
/&gt;
&lt;/s:form&gt;
&lt;img id=&quot;indicator3&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;

&lt;div id=&quot;resultdiv3&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;
    Result div for AJAX submit button.
&lt;/div&gt;

&lt;sj:a
    id=&quot;publishanchor&quot;
    href=&quot;#&quot;
    onClickTopics=&quot;loaddiv1,loaddiv2,loaddiv3&quot;
    button=&quot;true&quot;
    buttonIcon=&quot;ui-icon-gear&quot;
&gt;
    This link publish all three topics
&lt;/sj:a&gt;
            </code>
	  </pre>
</div>
