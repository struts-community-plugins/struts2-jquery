<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Inline Datepicker</h2>

<sj:datepicker id="dpinline" inline="true" onChangeTopics="onDpClose"/>


<h2>Inline Datepicker inside of an form</h2>

<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="form" action="echo" theme="xhtml">
	<sj:datepicker
			id="dpinlineform"
			inline="true"
			name="echo"
			label="Inline Datepicker"
			onCompleteTopics="onDpClose"
			numberOfMonths="[2,2]"
			/>
	<sj:submit
			targets="result"
			button="true"
			value="Submit"
			indicator="indicator"
			/>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<h4>Source Code</h4>

<sj:tabbedpanel id="codesamples">
	<sj:tab id="tab1" target="jsp" label="JSP Code" disabled="true"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript"/>
	<div id="jsp">
		<pre>
			<code class="html">
&lt;h2&gt;Inline Datepicker&lt;/h2&gt;

&lt;sj:datepicker id=&quot;dpinline&quot; inline=&quot;true&quot; onChangeTopics=&quot;onDpClose&quot;/&gt;


&lt;h2&gt;Inline Datepicker inside of an form&lt;/h2&gt;

&lt;strong&gt;Result Div :&lt;/strong&gt;
&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;

&lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
	&lt;sj:datepicker
		id=&quot;dpinlineform&quot;
		inline=&quot;true&quot;
		name=&quot;echo&quot;
		label=&quot;Inline Datepicker&quot;
		onCompleteTopics=&quot;onDpClose&quot;
		numberOfMonths=&quot;[2,2]&quot;
	/&gt;
	&lt;sj:submit
		targets=&quot;result&quot;
		button=&quot;true&quot;
		value=&quot;Submit&quot;
		indicator=&quot;indicator&quot;
	/&gt;
&lt;/s:form&gt;
&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
				</code>
	       	</pre>
	</div>
	<div id="javascript">
		<pre>
    			<code class="javascript">
$.subscribe('onDpClose', function(event,data) {
	alert('Selected Date : '+event.originalEvent.dateText);
});
				</code>
		</pre>
	</div>
</sj:tabbedpanel>
