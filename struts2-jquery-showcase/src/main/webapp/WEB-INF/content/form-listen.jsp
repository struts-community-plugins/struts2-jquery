<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url var="urlform" action="form"/><sj:a id="remoteformlink" href="%{urlform}" targets="main">AJAX Forms</sj:a></li>
      <li><s:url var="urlformeffect" action="form-effect"/><sj:a id="remoteformeffectlink" href="%{urlformeffect}" targets="main">AJAX Forms with Effects</sj:a></li>
      <li><s:url var="urlformout" action="form-out"/><sj:a id="remoteformoutlink" href="%{urlformout}" targets="main">AJAX Forms with Outside Button</sj:a></li>
      <li><s:url var="urlformftl" action="form-ftl"/><sj:a id="remoteformftllink" href="%{urlformftl}" targets="main">AJAX Forms with Freemarker</sj:a></li>
      <li><s:url var="urlformvel" action="form-velocity"/><sj:a id="remoteformvellink" href="%{urlformvel}" targets="main">AJAX Forms with Velocity</sj:a></li>
      <li><s:url var="urlformevent" action="form-event"/><sj:a id="remoteformeventlink" href="%{urlformevent}" targets="main">AJAX Forms with Events</sj:a></li>
      <li><s:url var="urlformlisten" action="form-listen"/><sj:a id="remoteformlistenlink" href="%{urlformlisten}" targets="main">AJAX Forms with Listen Topics</sj:a></li>
      <li><s:url var="urlformvalidation" action="form-validation"/><sj:a id="remoteformvalidationlink" href="%{urlformvalidation}" targets="main">AJAX Forms with Validation</sj:a></li>
      <li><s:url var="urlformvalidationcust" action="form-validation-custome"/><sj:a id="remoteformvalidationcustlink" href="%{urlformvalidationcust}" targets="main">AJAX Forms with Custome Validation</sj:a></li>
      <li><s:url var="urlformtextarea" action="form-textarea"/><sj:a id="remoteformtextarealink" href="%{urlformtextarea}" targets="main">AJAX Textarea</sj:a></li>
      <li><s:url var="urlformtextarearesize" action="form-textarea-resizeable"/><sj:a id="remoteformtextarearesizelink" href="%{urlformtextarearesize}" targets="main">AJAX Textarea / Resizable</sj:a></li>
      <li><s:url var="urlformtextfieldresize" action="form-textfield-resizeable"/><sj:a id="remoteformtextfieldresizelink" href="%{urlformtextfieldresize}" targets="main">AJAX Textfield / Resizable</sj:a></li>
      <li><s:url var="urlformbuttonsetcheckbox" action="form-buttonset-checkbox"/><sj:a id="remoteformbuttonsetcheckboxes" href="%{urlformbuttonsetcheckbox}" targets="main">Buttonset / Checkboxes</sj:a></li>
      <li><s:url var="urlformbuttonsetradio" action="form-buttonset-radio"/><sj:a id="remoteformbuttonsetradio" href="%{urlformbuttonsetradio}" targets="main">Buttonset / Radio Buttons</sj:a></li>
      <li><s:url var="urlformselect" action="form-select"/><sj:a id="remoteformselectlink" href="%{urlformselect}" targets="main">AJAX Select</sj:a></li>
      <li><s:url var="urlformdoubleselect" action="form-doubleselect"/><sj:a id="remoteformdoubleselectlink" href="%{urlformdoubleselect}" targets="main">AJAX Select (Doubleselect)</sj:a></li>
	    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Form submission with Listen Topics</h2>
	<p class="text">
	    Submit a form with AJAX and publish Listen Topics.
	</p>
	
<h3>Form One</h3>
<div>
Form Submit with AJAX form Button.
	<s:form id="listenForm1" action="ajax1">
		<sj:submit 
				id="submit1" 
				value="Submit Button"
				onClickTopics="listenOnClick1"
				targets="result1" 
				effect="highlight"
				button="true"
		/>
	</s:form>
</div>
<div id="result1" class="ui-widget-content ui-corner-all">Result Div for Form One</div>
<br/>
<h3>Form Two</h3>
<div>
Following Form Submit Button is Listen on Submit Button in Form One.
	<s:form id="listenForm2">
		<s:url var="formurl1" action="ajax2" namespace="/" />
		<sj:submit 
				id="submit2" 
				href="%{formurl1}" 
				value="Listen/Submit Button" 
				formIds="listenForm2"
				targets="result2" 
				effect="highlight"
				listenTopics="listenOnClick1" 
				button="true"
		/>
	</s:form>
</div>
<div id="result2" class="ui-widget-content ui-corner-all">Result Div for Form Two</div>
<br/>

<h3>Form Three</h3>
<div>
Form Submit with AJAX form Button with specified href attribute.
	<s:form id="listenForm3">
		<s:url var="formurl3" action="ajax3" namespace="/" />
		<sj:submit 
				id="submit3" 
				value="Submit Button"
				onClickTopics="listenOnClick2" 
				targets="result3" 
				effect="highlight"
				href="%{formurl3}" 
				button="true"
		/>
	</s:form>
</div>
<div id="result3" class="ui-widget-content ui-corner-all">Result Div for Form Three</div>
<br/>

<h3>Form Four</h3>
<div>
Following Form Submit Button is Listen on Submit Button in Form Three.
	<s:form id="listenForm4">
		<s:url var="formurl4" action="ajax4" namespace="/" />
		<sj:submit 
				id="submit4" 
				href="%{formurl4}" 
				value="Listen/Submit Button" 
				formIds="listenForm4"
				targets="result4" 
				effect="highlight"
				listenTopics="listenOnClick2"
				button="true"
		 />
	</s:form>
</div>
<div id="result4" class="ui-widget-content ui-corner-all">Result Div for Form Four</div>
<br/>

    
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
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
