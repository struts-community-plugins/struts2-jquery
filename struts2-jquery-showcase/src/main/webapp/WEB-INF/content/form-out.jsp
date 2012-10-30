<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with AJAX outside the Form</h2>

<p class="text">
	Submit a form with AJAX from outside the Form.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="formOutside" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form with Button outside</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:textfield id="echo" name="echo" value="Hello World!!!"/><br/>
		</div>
	</fieldset>
</s:form>

<sj:submit
		formIds="formOutside"
		targets="result"
		effect="pulsate"
		value="Submit outside the Form"
		indicator="indicator"
		button="true"
		/>

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formOutside&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form with Button outside&lt;/legend&gt;
            &lt;div class=&quot;type-text&quot;&gt;
                &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
                &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;&lt;br/&gt;
            &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;

    &lt;sj:submit 
    	formIds=&quot;formOutside&quot; 
    	targets=&quot;result&quot; 
    	effect=&quot;pulsate&quot; 
    	value=&quot;Submit outside the Form&quot; 
    	indicator=&quot;indicator&quot; 
    	button=&quot;true&quot;
    /&gt;
	  </pre>
</div>

