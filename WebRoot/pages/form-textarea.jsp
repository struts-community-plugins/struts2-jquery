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
      <li><s:url id="urlformtextarea" action="form-textarea"/><sj:a href="%{urlformtextarea}" targets="main">AJAX Textarea</sj:a></li>
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
		<s:url id="remoteurl" action="ajax1"/>
		<sj:textarea href="%{remoteurl}" id="echo" name="echo" label="Echo" rows="10" cols="80" effect="highlight" effectDuration="1500" loadingText="Loading content of textarea ..."/>
		<sj:submit targets="result" effect="slide" value="AJAX Submit" indicator="indicator"/>
    </s:form>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    

    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    

    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formEffect&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
		&lt;s:url id=&quot;remoteurl&quot; action=&quot;ajax1&quot;/&gt;
		&lt;sj:textarea href=&quot;%{remoteurl}&quot; id=&quot;echo&quot; name=&quot;echo&quot; label=&quot;Echo&quot; rows=&quot;10&quot; cols=&quot;80&quot; effect=&quot;highlight&quot; effectDuration=&quot;1500&quot; loadingText=&quot;Loading content of textarea ...&quot;/&gt;
		&lt;sj:submit targets=&quot;result&quot; effect=&quot;slide&quot; value=&quot;AJAX Submit&quot; indicator=&quot;indicator&quot;/&gt;
    &lt;/s:form&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
