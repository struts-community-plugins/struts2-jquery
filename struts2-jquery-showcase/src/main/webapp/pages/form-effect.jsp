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
      <li><s:url id="urlformbuttonsetcheckbox" action="form-buttonset-checkbox"/><sj:a id="remoteformbuttonsetcheckboxes" href="%{urlformbuttonsetcheckbox}" targets="main">Buttonset / Checkboxes</sj:a></li>
      <li><s:url id="urlformbuttonsetradio" action="form-buttonset-radio"/><sj:a id="remoteformbuttonsetradio" href="%{urlformbuttonsetradio}" targets="main">Buttonset / Radio Buttons</sj:a></li>
      <li><s:url id="urlformselect" action="form-select"/><sj:a id="remoteformselectlink" href="%{urlformselect}" targets="main">AJAX Select</sj:a></li>
      <li><s:url id="urlformdoubleselect" action="form-doubleselect"/><sj:a id="remoteformdoubleselectlink" href="%{urlformdoubleselect}" targets="main">AJAX Select (Doubleselect)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Form submission with AJAX with Effect</h2>
	<p>
	    Submit a form with AJAX and run a slide effect.
	</p>
    <s:form id="formEffect" action="echo" theme="xhtml">
                <s:textfield id="echo" name="echo" label="Echo" value="Hello World!!!"/><br/>
                <sj:submit 
                	targets="result" 
                	effect="blind" 
                	effectMode="show"
                	onEffectCompleteTopics="hideTarget"
                	value="AJAX Submit" 
                	indicator="indicator" 
                	button="true"
                />
    </s:form>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    

    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all" style="display: none;">Submit form bellow.</div>
    

    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>JavaScript Code:</strong>
	  <pre>
	$.subscribe('hideTarget', function(event, data) {
		$('#'+event.originalEvent.targets).delay(2000).hide("blind", 2500);
	});
	  </pre>
	  
	  <strong>JSP Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formEffect&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
                &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; label=&quot;Echo&quot; value=&quot;Hello World!!!&quot;/&gt;&lt;br/&gt;
                &lt;sj:submit 
                	targets=&quot;result&quot; 
                	effect=&quot;slide&quot; 
                	effectMode=&quot;blind&quot;
                	onEffectCompleteTopics=&quot;hideTarget&quot;
                	value=&quot;AJAX Submit&quot; 
                	indicator=&quot;indicator&quot; 
                	button=&quot;true&quot;
                /&gt;
    &lt;/s:form&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
