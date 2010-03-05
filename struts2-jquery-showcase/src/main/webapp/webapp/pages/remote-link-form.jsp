<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlremotelink" action="remote-link"/><sj:a id="remotesimplelink" href="%{urlremotelink}" targets="main">Remote Link</sj:a></li>
      <li><s:url id="urlremotelinktargets" action="remote-link-targets"/><sj:a id="remotetargetslink" href="%{urlremotelinktargets}" targets="main">Remote Link with 2 Targets</sj:a></li>
      <li><s:url id="urlremotelinkform" action="remote-link-form"/><sj:a id="remoteformlink" href="%{urlremotelinkform}" targets="main">Remote Link with Form submit</sj:a></li>
      <li><s:url id="urlremotelinkevent" action="remote-link-event"/><sj:a id="remoteeventlink" href="%{urlremotelinkevent}" targets="main">Remote Link with Event</sj:a></li>
      <li><s:url id="urlremotelinkhighlight" action="remote-link-highlight"/><sj:a id="remotehighlightlink" href="%{urlremotelinkhighlight}" targets="main">Remote Link Highlight Effect</sj:a></li>
      <li><s:url id="urlremotelinkbounce" action="remote-link-bounce"/><sj:a id="remotebouncelink" href="%{urlremotelinkbounce}" targets="main">Remote Link Bounce Effect</sj:a></li>
      <li><s:url id="urlremotelinkjson" action="remote-link-json"/><sj:a id="remotejsonlink" href="%{urlremotelinkjson}" targets="main">Remote Link with JSON Result</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Remote Link with form submission.</h2>
	<p>
	    A Remote Link that submit a form.
	</p>
    <strong>Result Div :</strong>
	<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="form" action="echo" theme="xhtml">
     Echo: <s:textfield id="echo" name="echo" value="Hello World!!!"/><br/>
    </s:form>

    <sj:a 
    	id="ajaxformlink" 
    	formIds="form" 
    	targets="formResult" 
    	indicator="indicator" 
    	button="true" 
		buttonIcon="ui-icon-gear"
    >
      Submit form here
    </sj:a>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
     Echo: &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; value=&quot;Hello World!!!&quot;/&gt;&lt;br/&gt;
    &lt;/s:form&gt;

    &lt;sj:a 
    	id=&quot;ajaxformlink&quot; 
    	formIds=&quot;form&quot; 
    	targets=&quot;formResult&quot; 
    	indicator=&quot;indicator&quot; 
    	button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-gear&quot;
    &gt;
      Submit form here
    &lt;/sj:a&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('.buttonlink').hover(
            function() { $(this).addClass('ui-state-hover'); }, 
            function() { $(this).removeClass('ui-state-hover'); }
    );
});
</script>
