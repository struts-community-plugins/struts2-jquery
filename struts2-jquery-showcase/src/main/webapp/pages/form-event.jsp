<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlform" action="form"/><sj:a id="remoteformlink" href="%{urlform}" targets="main">AJAX Forms</sj:a></li>
      <li><s:url id="urlformeffect" action="form-effect"/><sj:a id="remoteformeffectlink" href="%{urlformeffect}" targets="main">AJAX Forms with Effects</sj:a></li>
      <li><s:url id="urlformout" action="form-out"/><sj:a id="remoteformoutlink" href="%{urlformout}" targets="main">AJAX Forms with Outside Button</sj:a></li>
      <li><s:url id="urlformftl" action="form-ftl"/><sj:a id="remoteformftllink" href="%{urlformftl}" targets="main">AJAX Forms with Freemarker</sj:a></li>
      <li><s:url id="urlformvel" action="form-velocity"/><sj:a id="remoteformvellink" href="%{urlformvel}" targets="main">AJAX Forms with Velocity</sj:a></li>
      <li><s:url id="urlformevent" action="form-event"/><sj:a id="remoteformeventlink" href="%{urlformevent}" targets="main">AJAX Forms with Events</sj:a></li>
      <li><s:url id="urlformvalidation" action="form-validation"/><sj:a id="remoteformvalidationlink" href="%{urlformvalidation}" targets="main">AJAX Forms with Validation</sj:a></li>
      <li><s:url id="urlformvalidationcust" action="form-validation-custome"/><sj:a id="remoteformvalidationcustlink" href="%{urlformvalidationcust}" targets="main">AJAX Forms with Custome Validation</sj:a></li>
      <li><s:url id="urlformtextarea" action="form-textarea"/><sj:a id="remoteformtextarealink" href="%{urlformtextarea}" targets="main">AJAX Textarea</sj:a></li>
      <li><s:url id="urlformtextarearesize" action="form-textarea-resizeable"/><sj:a id="remoteformtextarearesizelink" href="%{urlformtextarearesize}" targets="main">AJAX Textarea / Resizable</sj:a></li>
      <li><s:url id="urlformtextfieldresize" action="form-textfield-resizeable"/><sj:a id="remoteformtextfieldresizelink" href="%{urlformtextfieldresize}" targets="main">AJAX Textfield / Resizable</sj:a></li>
      <li><s:url id="urlformselect" action="form-select"/><sj:a id="remoteformselectlink" href="%{urlformselect}" targets="main">AJAX Select</sj:a></li>
      <li><s:url id="urlformdoubleselect" action="form-doubleselect"/><sj:a id="remoteformdoubleselectlink" href="%{urlformdoubleselect}" targets="main">AJAX Select (Doubleselect)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Form submission with AJAX</h2>
	<p>
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
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
