<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><@s.url id="urlform" action="form"/><@sj.a href="%{urlform}" targets="main">AJAX Forms</@sj.a></li>
      <li><@s.url id="urlformeffect" action="form-effect"/><@sj.a href="%{urlformeffect}" targets="main">AJAX Forms with Effects</@sj.a></li>
      <li><@s.url id="urlformout" action="form-out"/><@sj.a href="%{urlformout}" targets="main">AJAX Forms with Outside Button</@sj.a></li>
      <li><@s.url id="urlformftl" action="form-ftl"/><@sj.a href="%{urlformftl}" targets="main">AJAX Forms with Freemarker</@sj.a></li>
      <li><@s.url id="urlformevent" action="form-event"/><@sj.a href="%{urlformevent}" targets="main">AJAX Forms with Events</@sj.a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>AJAX Forms with Freemarker</h2>
	<p>
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
                <@sj.submit clearForm="true" targets="result" value="AJAX Submit" indicator="indicator"/>
            </div>
        </fieldset>
    </@s.form>

    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;@s.form id="form" action="echo" theme="simple" cssClass="yform"&gt
     Echo: &lt;@s.textfield id="echo" name="echo" value="Hello World!!!"/&gt&lt;br/&gt;
     &lt;@sj.submit <strong>clearForm="true"</strong> targets="result" value="AJAX Submit" indicator="indicator"/&gt;
    &lt;/s:form&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
