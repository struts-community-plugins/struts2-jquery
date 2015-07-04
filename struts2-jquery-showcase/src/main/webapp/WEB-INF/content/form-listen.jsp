<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with Listen Topics</h2>

<p class="text">
	Submit a form with AJAX and publish Listen Topics.
</p>

<h3>Form One</h3>

<div>
	Form Submit with AJAX form Button.
	<s:form id="listenForm1" action="ajax1">
		<sj:submit
				id="submit1"
				value="Submit Button"
				onClickTopics="listenOnClick1"
				targets="result1"
				effect="highlight"
				button="true"
				/>
	</s:form>
</div>
<div id="result1" class="ui-widget-content ui-corner-all">Result Div for Form One</div>
<br/>

<h3>Form Two</h3>

<div>
	Following Form Submit Button is Listen on Submit Button in Form One.
	<s:form id="listenForm2">
		<s:url var="formurl1" action="ajax2" namespace="/"/>
		<sj:submit
				id="submit2"
				href="%{formurl1}"
				value="Listen/Submit Button"
				formIds="listenForm2"
				targets="result2"
				effect="highlight"
				listenTopics="listenOnClick1"
				button="true"
				/>
	</s:form>
</div>
<div id="result2" class="ui-widget-content ui-corner-all">Result Div for Form Two</div>
<br/>

<h3>Form Three</h3>

<div>
	Form Submit with AJAX form Button with specified href attribute.
	<s:form id="listenForm3">
		<s:url var="formurl3" action="ajax3" namespace="/"/>
		<sj:submit
				id="submit3"
				value="Submit Button"
				onClickTopics="listenOnClick2"
				targets="result3"
				effect="highlight"
				href="%{formurl3}"
				button="true"
				/>
	</s:form>
</div>
<div id="result3" class="ui-widget-content ui-corner-all">Result Div for Form Three</div>
<br/>

<h3>Form Four</h3>

<div>
	Following Form Submit Button is Listen on Submit Button in Form Three.
	<s:form id="listenForm4">
		<s:url var="formurl4" action="ajax4" namespace="/"/>
		<sj:submit
				id="submit4"
				href="%{formurl4}"
				value="Listen/Submit Button"
				formIds="listenForm4"
				targets="result4"
				effect="highlight"
				listenTopics="listenOnClick2"
				button="true"
				/>
	</s:form>
</div>
<div id="result4" class="ui-widget-content ui-corner-all">Result Div for Form Four</div>
<br/>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	  <pre>
            <code class="html">
&lt;h3&gt;Form One&lt;/h3&gt;

&lt;div&gt;
	Form Submit with AJAX form Button.
	&lt;s:form id=&quot;listenForm1&quot; action=&quot;ajax1&quot;&gt;
		&lt;sj:submit
			id=&quot;submit1&quot;
			value=&quot;Submit Button&quot;
			onClickTopics=&quot;listenOnClick1&quot;
			targets=&quot;result1&quot;
			effect=&quot;highlight&quot;
			button=&quot;true&quot;
		/&gt;
	&lt;/s:form&gt;
&lt;/div&gt;
&lt;div id=&quot;result1&quot; class=&quot;ui-widget-content ui-corner-all&quot;&gt;Result Div for Form One&lt;/div&gt;
&lt;br/&gt;

&lt;h3&gt;Form Two&lt;/h3&gt;

&lt;div&gt;
	Following Form Submit Button is Listen on Submit Button in Form One.
	&lt;s:form id=&quot;listenForm2&quot;&gt;
		&lt;s:url var=&quot;formurl1&quot; action=&quot;ajax2&quot; namespace=&quot;/&quot;/&gt;
		&lt;sj:submit
			id=&quot;submit2&quot;
			href=&quot;%{formurl1}&quot;
			value=&quot;Listen/Submit Button&quot;
			formIds=&quot;listenForm2&quot;
			targets=&quot;result2&quot;
			effect=&quot;highlight&quot;
			listenTopics=&quot;listenOnClick1&quot;
			button=&quot;true&quot;
		/&gt;
	&lt;/s:form&gt;
&lt;/div&gt;
&lt;div id=&quot;result2&quot; class=&quot;ui-widget-content ui-corner-all&quot;&gt;Result Div for Form Two&lt;/div&gt;
&lt;br/&gt;

&lt;h3&gt;Form Three&lt;/h3&gt;

&lt;div&gt;
	Form Submit with AJAX form Button with specified href attribute.
	&lt;s:form id=&quot;listenForm3&quot;&gt;
		&lt;s:url var=&quot;formurl3&quot; action=&quot;ajax3&quot; namespace=&quot;/&quot;/&gt;
		&lt;sj:submit
			id=&quot;submit3&quot;
			value=&quot;Submit Button&quot;
			onClickTopics=&quot;listenOnClick2&quot;
			targets=&quot;result3&quot;
			effect=&quot;highlight&quot;
			href=&quot;%{formurl3}&quot;
			button=&quot;true&quot;
		/&gt;
	&lt;/s:form&gt;
&lt;/div&gt;
&lt;div id=&quot;result3&quot; class=&quot;ui-widget-content ui-corner-all&quot;&gt;Result Div for Form Three&lt;/div&gt;
&lt;br/&gt;

&lt;h3&gt;Form Four&lt;/h3&gt;

&lt;div&gt;
	Following Form Submit Button is Listen on Submit Button in Form Three.
	&lt;s:form id=&quot;listenForm4&quot;&gt;
		&lt;s:url var=&quot;formurl4&quot; action=&quot;ajax4&quot; namespace=&quot;/&quot;/&gt;
		&lt;sj:submit
			id=&quot;submit4&quot;
			href=&quot;%{formurl4}&quot;
			value=&quot;Listen/Submit Button&quot;
			formIds=&quot;listenForm4&quot;
			targets=&quot;result4&quot;
			effect=&quot;highlight&quot;
			listenTopics=&quot;listenOnClick2&quot;
			button=&quot;true&quot;
		/&gt;
	&lt;/s:form&gt;
&lt;/div&gt;
&lt;div id=&quot;result4&quot; class=&quot;ui-widget-content ui-corner-all&quot;&gt;Result Div for Form Four&lt;/div&gt;
			</code>
	  </pre>
</div>
