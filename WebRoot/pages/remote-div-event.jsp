<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlremotediv" action="remote-div"/><sj:a href="%{urlremotediv}" targets="main">Remote Div</sj:a></li>
      <li><s:url id="urlremotedivpulasate" action="remote-div-pulsate"/><sj:a href="%{urlremotedivpulasate}" targets="main">Remote Div Pulsate Effect</sj:a></li>
      <li><s:url id="urlremotedivresize" action="remote-div-resizable"/><sj:a href="%{urlremotedivresize}" targets="main">Remote Div - Resizable</sj:a></li>
      <li><s:url id="urlremotedivevent" action="remote-div-event"/><sj:a href="%{urlremotedivevent}" targets="main">Remote Div - Event</sj:a></li>
      <li><s:url id="urleffectdivdragdrop" action="effect-div-dragdrop"/><sj:a href="%{urleffectdivdragdrop}" targets="main">Drag and Drop</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
    function before(request){
        alert('Before request ');
    }
    function complete(request, status){
        if(status == "success")
        {
            $('#resultnormal').append('<br/><br/><strong>Completed request '+request.statusText+' completed with '+status+ '.</strong><br/>Status: '+request.status);
        }
    }
    function errorState(request, status, error){
        $('#resulterror').html('<br/><br/><strong>Error request '+request.statusText+' completed with '+status+ '.</strong><br/>Status: '+request.status);
    }
    </script>        
	<h2>Remote Div</h2>
	<p>
	    A simple Remote Div that load AJAX content.
	</p>
    <strong>Div with valid URL:</strong>
    <s:url id="ajax" value="/echo.action"><s:param name="echo" value="%{'We love jQuery'}"/></s:url>
    <sj:div id="resultnormal" href="%{ajax}" indicator="indicator" beforeSend="before" complete="complete" error="errorState" cssClass="result ui-widget-content ui-corner-all">
        <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
    </sj:div>
    
    <br/><br/>
    
    <strong>Div with invalid URL:</strong>
    <sj:div id="resulterror" href="not_exist.html" indicator="indicator" complete="complete" error="errorState" cssClass="result ui-widget-content ui-corner-all">
        <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
    </sj:div>
        
	<div class="code ui-widget-content ui-corner-all">
      <strong>JavaScript functions:</strong>
      <pre>
    function before(request){
        alert('Before request ');
    }
    function complete(request, status){
        if(status == &quot;success&quot;)
        {
            $('#resultnormal').append('&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;Completed request '+request.statusText+' completed with '+status+ '.&lt;/strong&gt;&lt;br/&gt;Status: '+request.status);
        }
    }
    function errorState(request, status, error){
        $('#resulterror').html('&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;Error request '+request.statusText+' completed with '+status+ '.&lt;/strong&gt;&lt;br/&gt;Status: '+request.status);
    }
      </pre>
	  <strong>Code:</strong>
	  <pre>
    &lt;s:url id=&quot;ajax&quot; value=&quot;/echo.action&quot;&gt;&lt;s:param name=&quot;echo&quot; value=&quot;%{'We love jQuery'}&quot;/&gt;&lt;/s:url&gt;
    &lt;sj:div id=&quot;resultnormal&quot; href=&quot;%{ajax}&quot; indicator=&quot;indicator&quot; beforeSend=&quot;before&quot; complete=&quot;complete&quot; error=&quot;errorState&quot; cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
        &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
    &lt;/sj:div&gt;
    
    &lt;br/&gt;&lt;br/&gt;
    
    &lt;strong&gt;Div with invalid URL:&lt;/strong&gt;
    &lt;sj:div id=&quot;resulterror&quot; href=&quot;not_exist.html&quot; indicator=&quot;indicator&quot; complete=&quot;complete&quot; error=&quot;errorState&quot; cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
        &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
    &lt;/sj:div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
