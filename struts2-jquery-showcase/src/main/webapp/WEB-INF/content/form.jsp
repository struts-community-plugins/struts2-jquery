<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with AJAX</h2>

<p class="text">
	Submit a form with AJAX.
</p>
<strong>Result Div :</strong>

<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="form" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:textfield id="echo" name="echo" value="Hello World!!!"/>
		</div>
		<div>
			<sj:submit
					id="formSubmit1"
					targets="formResult"
					value="AJAX Submit"
					indicator="indicator"
					button="true"
					/>
			<s:url var="simpleecho" value="/simpleecho.action"/>
			<sj:submit
					id="formSubmit2"
					href="%{simpleecho}"
					targets="formResult"
					value="AJAX Submit 2"
					indicator="indicator"
					button="true"
					/>
		</div>
	</fieldset>
</s:form>

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
	            &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
	            &lt;sj:submit 
	            	id=&quot;formSubmit1&quot;
	            	targets=&quot;formResult&quot; 
	            	value=&quot;AJAX Submit&quot; 
	            	indicator=&quot;indicator&quot;
	            	button=&quot;true&quot;
	            	/&gt;
				&lt;s:url id=&quot;simpleecho&quot; value=&quot;/simpleecho.action&quot;/&gt;
	            &lt;sj:submit 
	            	id=&quot;formSubmit2&quot;
	            	href=&quot;%{simpleecho}&quot; 
	            	targets=&quot;formResult&quot; 
	            	value=&quot;AJAX Submit 2&quot; 
	            	indicator=&quot;indicator&quot;
	            	button=&quot;true&quot;
	            	/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
	  </pre>
</div>
