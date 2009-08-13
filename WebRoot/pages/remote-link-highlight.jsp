<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlremotelink" action="remote-link"/><sj:a href="%{urlremotelink}" targets="main">Remote Link</sj:a></li>
      <li><s:url id="urlremotelinktargets" action="remote-link-targets"/><sj:a href="%{urlremotelinktargets}" targets="main">Remote Link with 2 Targets</sj:a></li>
      <li><s:url id="urlremotelinkform" action="remote-link-form"/><sj:a href="%{urlremotelinkform}" targets="main">Remote Link with Form submit</sj:a></li>
      <li><s:url id="urlremotelinkevent" action="remote-link-event"/><sj:a href="%{urlremotelinkevent}" targets="main">Remote Link with Event</sj:a></li>
      <li><s:url id="urlremotelinkhighlight" action="remote-link-highlight"/><sj:a href="%{urlremotelinkhighlight}" targets="main">Remote Link Highlight Effect</sj:a></li>
      <li><s:url id="urlremotelinkbounce" action="remote-link-bounce"/><sj:a href="%{urlremotelinkbounce}" targets="main">Remote Link Bounce Effect</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Remote Link with Highlight Effect</h2>
	<p>
	    A Remote Link that highlight the target.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
    
	<s:url id="ajax" value="/ajax1.action"/>
	
	<sj:a id="ajaxlink" href="%{ajax}" targets="result" effect="highlight" effectOptions="color : '#222222'" effectDuration="2200">
	  Run AJAX Action
	</sj:a>
    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="ajax1.action"/&gt;
    
    &lt;sj:a id="ajaxlink" href="%{ajax}" targets="result" <strong>effect="highlight" effectOptions="color : '#222222'" effectDuration="2200"</strong>&gt;
      Run AJAX Action
    &lt;/sj:a&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
