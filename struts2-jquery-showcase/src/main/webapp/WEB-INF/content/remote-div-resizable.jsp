<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url var="urlremotediv" action="remote-div"/><sj:a id="remotedivlink" href="%{urlremotediv}" targets="main">Remote Div</sj:a></li>
      <li><s:url var="urlremotedivpulasate" action="remote-div-pulsate"/><sj:a id="remotedivpulsatelink" href="%{urlremotedivpulasate}" targets="main">Remote Div Pulsate Effect</sj:a></li>
      <li><s:url var="urlremotedivresize" action="remote-div-resizable"/><sj:a id="remotedivresizelink" href="%{urlremotedivresize}" targets="main">Remote Div - Resizable</sj:a></li>
      <li><s:url var="urlremotedivevent" action="remote-div-event"/><sj:a id="remotediveventlink" href="%{urlremotedivevent}" targets="main">Remote Div - Event</sj:a></li>
      <li><s:url var="urlremotedivreload" action="remote-div-reload"/><sj:a id="remotedivreloadlink" href="%{urlremotedivreload}" targets="main">Remote Div - Reload</sj:a></li>
      <li><s:url var="urlremotedivlisten" action="remote-div-listen"/><sj:a id="remotedivlistenlink" href="%{urlremotedivlisten}" targets="main">Remote Div - Listen Topics</sj:a></li>
      <li><s:url var="urleffectdivdragdrop" action="effect-div-dragdrop"/><sj:a id="remotedivdragdroplink" href="%{urleffectdivdragdrop}" targets="main">Drag and Drop</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>A resizeable Remote Div</h2>
	<p class="text">
	    A Remote Div that load AJAX content and is resizeable.
	</p>
    <strong>Remote Div :</strong>
    <s:url var="ajax" value="/ajax3.action"/>
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
