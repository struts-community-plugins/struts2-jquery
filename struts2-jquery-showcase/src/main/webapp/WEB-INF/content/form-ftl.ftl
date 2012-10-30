<h2>AJAX Forms with Freemarker</h2>
<p class="text">
	Submit a form with AJAX and Freemarker templates.<br/>
	Clear field after successful submit.
</p>
<strong>Result Div :</strong>
<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>




<@s.form id="form" action="echo" theme="simple" cssClass="yform">
<fieldset>
	<legend>AJAX Form</legend>
	<div class="type-text">
		<label for="echo">Echo: </label>
		<@s.textfield id="echo" name="echo" value="Hello World!!!"/><br/>
	</div>
	<div class="type-button">
		<@sj.submit
                	clearForm="true"
		targets="result"
		value="AJAX Submit"
		indicator="indicator"
		button="true"
                />
	</div>
</fieldset>
</@s.form>

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;@s.form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
            &lt;div class=&quot;type-text&quot;&gt;
                &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
                &lt;@s.textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;&lt;br/&gt;
            &lt;/div&gt;
            &lt;div class=&quot;type-button&quot;&gt;
                &lt;@sj.submit 
                	clearForm=&quot;true&quot; 
                	targets=&quot;result&quot; 
                	value=&quot;AJAX Submit&quot; 
                	indicator=&quot;indicator&quot; 
                	button=&quot;true&quot;
                /&gt;
            &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/@s.form&gt;
	  </pre>
</div>
