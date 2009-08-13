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
	<h2>A resizeable Remote Div</h2>
	<p>
	    A Remote Div that load AJAX content and is resizeable.
	</p>
    <strong>Remote Div :</strong>
    <s:url id="ajax" value="/ajax3.action"/>
    <sj:div href="%{ajax}" indicator="indicator" resizable="true" resizableAnimate="true" resizableGhost="true" resizableHelper="ui-state-highlight" resizableAspectRatio="true" cssStyle="width: 250px; height: 180px;" cssClass="ui-widget-content ui-corner-all">
        <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
    </sj:div>
        
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;s:url id="ajax" value="/ajax3.action"/&gt;
    &lt;sj:div href="%{ajax}" indicator="indicator" <strong>resizable="true" resizableAnimate="true" resizableGhost="true" resizableHelper="ui-state-highlight" resizableAspectRatio="true"</strong> cssStyle="width: 250px; height: 180px;" cssClass="ui-widget-content ui-corner-all"&gt;
        &lt;img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/&gt;
    &lt;/sj:div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
