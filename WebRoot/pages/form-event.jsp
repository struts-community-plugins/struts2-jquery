<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlform" action="form"/><sj:a href="%{urlform}" targets="main">AJAX Forms</sj:a></li>
      <li><s:url id="urlformeffect" action="form-effect"/><sj:a href="%{urlformeffect}" targets="main">AJAX Forms with Effects</sj:a></li>
      <li><s:url id="urlformout" action="form-out"/><sj:a href="%{urlformout}" targets="main">AJAX Forms with Outside Button</sj:a></li>
      <li><s:url id="urlformftl" action="form-ftl"/><sj:a href="%{urlformftl}" targets="main">AJAX Forms with Freemarker</sj:a></li>
      <li><s:url id="urlformevent" action="form-event"/><sj:a href="%{urlformevent}" targets="main">AJAX Forms with Events</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
     function before(data, form, options){
    	 var queryString = $.param(data);
    	 alert('About to submit: \n\n' + queryString);
     }
     function completed(response, status){
    	 alert('status: ' + status + '\n\nresponseText: \n' + response + 
         '\n\nThe output div should have already been updated with the responseText.');
     }
     function errorState(request, status){
         alert('status: ' + status + '\n\nrequest status: ' + request.status);
     }
    </script>        
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
	            <sj:submit targets="result" value="AJAX Submit" indicator="indicator" beforeSend="before" complete="completed" error="errorState"/>
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
                <sj:submit targets="result" value="AJAX Submit with Error" indicator="indicator" beforeSend="before" complete="completed" error="errorState"/>
            </div>
        </fieldset>
    </s:form>

	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:form id="form" action="echo" theme="simple"&gt;
     Echo: &lt;s:textfield id="echo" name="echo" value="Hello World!!!"/>
     &lt;sj:submit targets="result" value="AJAX Submit" indicator="indicator"/&gt;
    &lt;/s:form&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
