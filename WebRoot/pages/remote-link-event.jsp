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
    <script type="text/javascript">
    function before(request){
        alert('Before request ');
        $('#result').html('Loading ...');
    }
    function complete(request, status){
        if(status == "success")
        {
            $('#result').append('<br/><br/><strong>Completed request '+request.statusText+' completed with '+status+ '.</strong><br/>Status: '+request.status);
        }
    }
    function errorState(request, status, error){
        $('#result').html('<br/><br/><strong>Error request '+request.statusText+' completed with '+status+ '.</strong><br/>Status: '+request.status);
    }
    </script>        
	<h2>Remote Link with Events</h2>
	<p>
	    A Remote Link that raise Events befor and after request.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
    
	<s:url id="ajax" value="/ajax1.action"/>
	
	<sj:a id="ajaxlink" href="%{ajax}" indicator="indicator" targets="result" beforeSend="before" complete="complete" effect="pulsate" cssClass="buttonlink ui-state-default ui-corner-all"><span class="ui-icon ui-icon-refresh"></span>
	  Run AJAX Action
	</sj:a>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
    <br/>
    <br/>
    <sj:a id="ajaxlink2" href="file-does-not-exist.html" indicator="indicator2" targets="result" beforeSend="before" complete="complete" error="errorState" effect="pulsate" cssClass="buttonlink ui-state-default ui-corner-all"><span class="ui-icon ui-icon-refresh"></span>
      Run AJAX Error Action
    </sj:a>
    <img id="indicator2" src="images/indicator.gif" alt="Loading..." style="display:none"/>    

	<div class="code ui-widget-content ui-corner-all">
      <strong>JavaScript functions:</strong>
      <pre>
    function before(request){
        alert('Before request ');
        $('#result').html('Loading ...');
    }
    function complete(request, status){
        if(status == &quot;success&quot;)
        {
            $('#result').append('&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;Completed request '+request.statusText+' completed with '+status+ '.&lt;/strong&gt;&lt;br/&gt;Status: '+request.status);
        }
    }
    function errorState(request, status, error){
        $('#result').html('&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;Error request '+request.statusText+' completed with '+status+ '.&lt;/strong&gt;&lt;br/&gt;Status: '+request.status);
    }
      </pre>
	  <strong>Code:</strong>
	  <pre>
    &lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the link bellow.&lt;/div&gt;
    
    &lt;s:url id=&quot;ajax&quot; value=&quot;/ajax1.action&quot;/&gt;
    
    &lt;sj:a id=&quot;ajaxlink&quot; href=&quot;%{ajax}&quot; indicator=&quot;indicator&quot; targets=&quot;result&quot; beforeSend=&quot;before&quot; complete=&quot;complete&quot; effect=&quot;pulsate&quot; cssClass=&quot;buttonlink ui-state-default ui-corner-all&quot;&gt;&lt;span class=&quot;ui-icon ui-icon-refresh&quot;&gt;&lt;/span&gt;
      Run AJAX Action
    &lt;/sj:a&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
    &lt;br/&gt;
    &lt;br/&gt;
    &lt;sj:a id=&quot;ajaxlink2&quot; href=&quot;file-does-not-exist.html&quot; indicator=&quot;indicator2&quot; targets=&quot;result&quot; beforeSend=&quot;before&quot; complete=&quot;complete&quot; error=&quot;errorState&quot; effect=&quot;pulsate&quot; cssClass=&quot;buttonlink ui-state-default ui-corner-all&quot;&gt;&lt;span class=&quot;ui-icon ui-icon-refresh&quot;&gt;&lt;/span&gt;
      Run AJAX Error Action
    &lt;/sj:a&gt;
    &lt;img id=&quot;indicator2&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
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
