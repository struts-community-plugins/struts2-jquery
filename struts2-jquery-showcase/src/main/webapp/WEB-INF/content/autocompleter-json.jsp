<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Autocompleter with JSON Result</h2>

<p class="text">
	A Autocompleter that handle a JSON Result with Topics.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
<strong>Topics Div :</strong>

<div id="topics" class="result ui-widget-content ui-corner-all"></div>

<s:form id="formAutocompleteJson" action="echo" theme="xhtml">
	<s:url var="jsonlanguages" action="jsonlanguages"/>
	<sj:autocompleter
			id="languages"
			name="echo"
			label="Handle a Array"
			href="%{jsonlanguages}"
			delay="50"
			loadMinimumCount="2"
			onChangeTopics="autocompleteChange"
			onFocusTopics="autocompleteFocus"
			onSelectTopics="autocompleteSelect"
			/>
	<s:url var="jsoncustomers" action="jsoncustomers"/>
	<sj:autocompleter
			id="customers"
			name="echo"
			label="Handle a List"
			href="%{jsoncustomers}"
			list="customers"
			listValue="name"
			listKey="id"
			listLabel="label"
			delay="50"
			loadMinimumCount="2"
			onChangeTopics="autocompleteChange"
			onFocusTopics="autocompleteFocus"
			onSelectTopics="autocompleteSelect"
			placeholder="Select a Customer"
			/>
	<sj:autocompleter
			id="customersMap"
			name="echo"
			label="Handle a Map"
			href="%{jsoncustomers}"
			list="customersMap"
			delay="50"
			loadMinimumCount="2"
			forceValidOption="false"
			onChangeTopics="autocompleteChange"
			onFocusTopics="autocompleteFocus"
			onSelectTopics="autocompleteSelect"
			/>
	<sj:submit
			id="submitFormAutocompleteJson"
			targets="result"
			button="true"
			value="Submit"
			indicator="indicator"
			/>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>


<h4>Source Code</h4>


<sj:tabbedpanel id="sourcecode">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript"/>
	<div id="jsp">
	  <pre>
            <code class="html">
&lt;strong&gt;Result Div :&lt;/strong&gt;
&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
&lt;strong&gt;Topics Div :&lt;/strong&gt;
&lt;div id=&quot;topics&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;&lt;/div&gt;

&lt;s:form id=&quot;formAutocompleteJson&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
	&lt;s:url id=&quot;jsonlanguages&quot; action=&quot;jsonlanguages&quot;/&gt;
	&lt;sj:autocompleter
		id=&quot;languages&quot;
		name=&quot;echo&quot;
		label=&quot;Handle a Array&quot;
		href=&quot;%{jsonlanguages}&quot;
		delay=&quot;50&quot;
		loadMinimumCount=&quot;2&quot;
		onChangeTopics=&quot;autocompleteChange&quot;
		onFocusTopics=&quot;autocompleteFocus&quot;
		onSelectTopics=&quot;autocompleteSelect&quot;
	/&gt;
	&lt;s:url id=&quot;jsoncustomers&quot; action=&quot;jsoncustomers&quot;/&gt;
	&lt;sj:autocompleter
		id=&quot;customers&quot;
		name=&quot;echo&quot;
		label=&quot;Handle a List&quot;
		href=&quot;%{jsoncustomers}&quot;
		list=&quot;customers&quot;
		listValue=&quot;name&quot;
		listKey=&quot;id&quot;
		listLabel=&quot;label&quot;
		delay=&quot;50&quot;
		loadMinimumCount=&quot;2&quot;
		onChangeTopics=&quot;autocompleteChange&quot;
		onFocusTopics=&quot;autocompleteFocus&quot;
		onSelectTopics=&quot;autocompleteSelect&quot;
		placeholder=&quot;Select a Customer&quot;
	/&gt;
	&lt;sj:autocompleter
		id=&quot;customersMap&quot;
		name=&quot;echo&quot;
		label=&quot;Handle a Map&quot;
		href=&quot;%{jsoncustomers}&quot;
		list=&quot;customersMap&quot;
		delay=&quot;50&quot;
		loadMinimumCount=&quot;2&quot;
		onChangeTopics=&quot;autocompleteChange&quot;
		onFocusTopics=&quot;autocompleteFocus&quot;
		onSelectTopics=&quot;autocompleteSelect&quot;
	/&gt;
	&lt;sj:submit
		id=&quot;submitFormAutocompleteJson&quot;
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
$.subscribe('autocompleteChange', function(event, data) {
	var ui = event.originalEvent.ui;
	var message = ui.item.value;
	if(ui.item.key) {
		message = '( '+ ui.item.key +' ) '+message;
	}
	$('#topics').html('&lt;b&gt;'+message+'&lt;/b&gt;');
});

$.subscribe('autocompleteFocus', function(event, data) {
	var ui = event.originalEvent.ui;
	var message = ui.item.value;
	if(ui.item.key) {
		message = '( '+ ui.item.key +' ) '+message;
	}
	$('#topics').html('&lt;u&gt;'+message+'&lt;/u&gt;');
});

$.subscribe('autocompleteSelect', function(event, data) {
	var ui = event.originalEvent.ui;
	var message = ui.item.value;
	if(ui.item.key) {
		message = '( '+ ui.item.key +' ) '+message;
	}
	$('#topics').html('&lt;i&gt;'+message+'&lt;/i&gt;');
});
		  </code>
	  </pre>
	</div>
</sj:tabbedpanel>

