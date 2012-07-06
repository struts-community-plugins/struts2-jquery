<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlremotediv" action="remote-div"/><sj:a id="remotedivlink" href="%{urlremotediv}" targets="main">Remote Div</sj:a></li>
      <li><s:url id="urlremotedivpulasate" action="remote-div-pulsate"/><sj:a id="remotedivpulsatelink" href="%{urlremotedivpulasate}" targets="main">Remote Div Pulsate Effect</sj:a></li>
      <li><s:url id="urlremotedivresize" action="remote-div-resizable"/><sj:a id="remotedivresizelink" href="%{urlremotedivresize}" targets="main">Remote Div - Resizable</sj:a></li>
      <li><s:url id="urlremotedivevent" action="remote-div-event"/><sj:a id="remotediveventlink" href="%{urlremotedivevent}" targets="main">Remote Div - Event</sj:a></li>
      <li><s:url id="urlremotedivreload" action="remote-div-reload"/><sj:a id="remotedivreloadlink" href="%{urlremotedivreload}" targets="main">Remote Div - Reload</sj:a></li>
      <li><s:url id="urlremotedivlisten" action="remote-div-listen"/><sj:a id="remotedivlistenlink" href="%{urlremotedivlisten}" targets="main">Remote Div - Listen Topics</sj:a></li>
      <li><s:url id="urleffectdivdragdrop" action="effect-div-dragdrop"/><sj:a id="remotedivdragdroplink" href="%{urleffectdivdragdrop}" targets="main">Drag and Drop</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Remote Div with Pulsate Effect</h2>
	<p class="text">
	    A Remote Div that load AJAX content after an delay of 3000 milliseconds. After loading the Pulsate effect is executed.
	</p>
    <strong>Remote Div :</strong>
    <s:url id="ajax" value="/ajax1.action"/>
    <sj:div
    	id="pulsatingdiv"
    	delay="3000" 
    	href="%{ajax}" 
    	indicator="indicatorpuls" 
    	effect="pulsate" 
    	effectDuration="1500" 
    	cssClass="result ui-widget-content ui-corner-all"
    >
        <img id="indicatorpuls" src="images/indicator.gif" alt="Loading..."/>
    </sj:div>
        
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="/ajax1.action"/&gt;
    &lt;sj:div
    	id=&quot;pulsatingdiv&quot;
    	delay=&quot;3000&quot; 
    	href=&quot;%{ajax}&quot; 
    	indicator=&quot;indicatorpuls&quot; 
    	effect=&quot;pulsate&quot; 
    	effectDuration=&quot;1500&quot; 
    	cssClass=&quot;result ui-widget-content ui-corner-all&quot;
    &gt;
        &lt;img id=&quot;indicatorpuls&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot;/&gt;
    &lt;/sj:div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
