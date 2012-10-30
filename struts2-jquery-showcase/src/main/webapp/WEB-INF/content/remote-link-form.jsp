<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Remote Link with form submission.</h2>

<p class="text">
	A Remote Link that submit a form.
</p>
<strong>Result Div :</strong>

<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="form" action="echo" theme="xhtml">
	Echo: <s:textfield id="echo" name="echo" value="Hello World!!!"/><br/>
</s:form>

<sj:a
		id="ajaxformlink"
		formIds="form"
		clearForm="true"
		targets="formResult"
		indicator="indicator"
		button="true"
		buttonIcon="ui-icon-gear"
		>
	Submit form here
</sj:a>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
     Echo: &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;&lt;br/&gt;
    &lt;/s:form&gt;

    &lt;sj:a 
    	id=&quot;ajaxformlink&quot; 
    	formIds=&quot;form&quot; 
    	targets=&quot;formResult&quot; 
    	indicator=&quot;indicator&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
    &gt;
      Submit form here
    &lt;/sj:a&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
</div>

