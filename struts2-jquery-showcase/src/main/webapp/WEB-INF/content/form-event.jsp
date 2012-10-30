<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with AJAX</h2>

<p class="text">
	Submit a form with AJAX.
</p>
<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<s:form id="formevent" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:textfield id="echo" name="echo" value="Hello World!!!"/>
		</div>
		<div class="type-button">
			<sj:submit
					targets="result"
					value="AJAX Submit"
					timeout="2500"
					indicator="indicator"
					onBeforeTopics="beforeForm"
					onCompleteTopics="completeForm"
					onErrorTopics="errorStateForm"
					button="true"
					/>
		</div>
	</fieldset>
</s:form>

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<s:form id="formeventerror" action="file-does-not-exist.html" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form with Error Result</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:textfield id="echo" name="echo" value="Hello World!!!"/>
		</div>
		<div class="type-button">
			<sj:submit
					targets="result"
					value="AJAX Submit with Error"
					timeout="2500"
					indicator="indicator"
					onBeforeTopics="beforeForm"
					onCompleteTopics="completeForm"
					onErrorTopics="errorStateForm"
					button="true"
					/>
		</div>
	</fieldset>
</s:form>

<div class="code ui-widget-content ui-corner-all">
	<strong>JavaScript functions:</strong>
      <pre>
    $.subscribe('beforeForm', function(event,data) {
     var fData = event.originalEvent.formData;
	 alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout );
     var form = event.originalEvent.form[0]; 
     if (form.echo.value.length  &lt; 2) { 
         alert('Please enter a value with min 2 characters'); 
         event.originalEvent.options.submit = false; 
     } 
    });
    $.subscribe('completeForm', function(event,data) {
   	 alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText + 
     '\n\nThe output div should have already been updated with the responseText.');
    });
    $.subscribe('errorStateForm', function(event,data) {
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status);
    });
      </pre>
	<strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formevent&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
	            &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
	            &lt;sj:submit 
	            	targets=&quot;result&quot; 
	            	value=&quot;AJAX Submit&quot; 
	            	timeout=&quot;2500&quot; 
	            	indicator=&quot;indicator&quot; 
	            	onBeforeTopics=&quot;before&quot; 
	            	onCompleteTopics=&quot;complete&quot; 
	            	onErrorTopics=&quot;errorState&quot; 
	            	button=&quot;true&quot;
	            /&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;

    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
    
    &lt;s:form id=&quot;formeventerror&quot; action=&quot;file-does-not-exist.html&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form with Error Result&lt;/legend&gt;
            &lt;div class=&quot;type-text&quot;&gt;
                &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
                &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;
            &lt;/div&gt;
            &lt;div class=&quot;type-button&quot;&gt;
                &lt;sj:submit 
                	targets=&quot;result&quot; 
                	value=&quot;AJAX Submit with Error&quot; 
                	timeout=&quot;2500&quot; 
                	indicator=&quot;indicator&quot; 
                	onBeforeTopics=&quot;before&quot; 
                	onCompleteTopics=&quot;complete&quot; 
                	onErrorTopics=&quot;errorState&quot;
	            	button=&quot;true&quot;
                /&gt;
            &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
	  </pre>
</div>
