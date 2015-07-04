<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Autocompleter</h2>

<p class="text">
	A Autocompleter that handle a String Array from Action.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="formAutocomplete" action="echo" theme="xhtml">
	<sj:autocompleter
			id="languages"
			name="echo"
			list="%{languages}"
			label="Select Languages"
			/>
	<sj:submit
			id="submitFormAutocomplete"
			targets="result"
			button="true"
			value="Submit"
			indicator="indicator"
			/>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>


<h4>Source Code</h4>


<div class="code ui-widget-content ui-corner-all">
	<strong>Code in JSP:</strong>
    <pre>
    <code class="html">
&lt;strong&gt;Result Div :&lt;/strong&gt;
&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;

&lt;s:form id=&quot;formAutocomplete&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
	&lt;sj:autocompleter
		id=&quot;languages&quot;
		name=&quot;echo&quot;
		list=&quot;%{languages}&quot;
		label=&quot;Select Languages&quot;
	/&gt;
	&lt;sj:submit
		id=&quot;submitFormAutocomplete&quot;
		targets=&quot;result&quot;
		button=&quot;true&quot;
		validate=&quot;true&quot;
		value=&quot;Submit&quot;
		indicator=&quot;indicator&quot;
		/&gt;
&lt;/s:form&gt;
&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
    </code>
    </pre>
</div>
