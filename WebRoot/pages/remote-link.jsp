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
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Remote Link</h2>
	<p>
	    A simple Remote Link with indicator.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
	<s:url id="ajax" value="/ajax1.action"/>
	
	<sj:a id="ajaxlink" href="%{ajax}" targets="result" indicator="indicator" cssClass="buttonlink ui-state-default ui-corner-all"><span class="ui-icon ui-icon-refresh"></span>
	  Run AJAX Action
	</sj:a>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="ajax1.action"/&gt;
    
    &lt;sj:a id="ajaxlink" href="%{ajax}" targets="result" indicator="indicator"&gt;
      Run AJAX Action
    &lt;/sj:a&gt;
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
