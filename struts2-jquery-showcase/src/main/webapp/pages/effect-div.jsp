<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urleffectdiv" action="effect-div"/><sj:a href="%{urleffectdiv}" targets="main">Highlight Effect / Click</sj:a></li>
      <li><s:url id="urleffectdivshake" action="effect-div-shake"/><sj:a href="%{urleffectdivshake}" targets="main">Shake Effect / MouseOver</sj:a></li>
      <li><s:url id="urleffectdivsize" action="effect-div-size"/><sj:a href="%{urleffectdivsize}" targets="main">Size Effect / Bind on Link</sj:a></li>
      <li><s:url id="urleffectdivevents" action="effect-div-events"/><sj:a href="%{urleffectdivevents}" targets="main">Fold Effect with Events</sj:a></li>
      <li><s:url id="urleffectdivresize" action="effect-div-resizeable"/><sj:a href="%{urleffectdivresize}" targets="main">A Resizeable Div</sj:a></li>
      <li><s:url id="urleffectdivdragdrop" action="effect-div-dragdrop"/><sj:a href="%{urleffectdivdragdrop}" targets="main">Drag and Drop</sj:a></li>
      <li><s:url id="urleffectdivselectable" action="effect-div-selectable"/><sj:a href="%{urleffectdivselectable}" targets="main">Selectable</sj:a></li>
      <li><s:url id="urleffectdivsortable" action="effect-div-sortable"/><sj:a href="%{urleffectdivsortable}" targets="main">Sortable</sj:a></li>
      <li><s:url id="urleffectdivportlets" action="effect-div-portlets"/><sj:a href="%{urleffectdivportlets}" targets="main">Sortable (Portlets)</sj:a></li>
      <li><s:url id="urleffectdivextend" action="effect-div-extend"/><sj:a href="%{urleffectdivextend}" targets="main">Extend this Plugin</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Highlight Effect</h2>
	<p>
	    A Div with Highlight Effect on click.
	</p>
    <strong>Div :</strong>
    <sj:div id="withclick" events="click" effect="highlight" effectDuration="4000" effectOptions="{ color: '#000000', mode: 'show' }" cssClass="result ui-widget-content ui-corner-all">
        Click me!<br/>
        Click me!<br/>
        Click me!<br/>
    </sj:div>
        
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
    &lt;sj:div id=&quot;withclick&quot; <strong>events=&quot;click&quot; effect=&quot;highlight&quot; effectDuration=&quot;4000&quot; effectOptions=&quot;{ color: '#000000', mode: 'show' }&quot;</strong> cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
        Click me!&lt;br/&gt;
        Click me!&lt;br/&gt;
        Click me!&lt;br/&gt;
    &lt;/sj:div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
