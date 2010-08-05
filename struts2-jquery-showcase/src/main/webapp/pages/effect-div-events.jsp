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
    <script type="text/javascript">
	$.subscribe('before', function(event,data) {
        alert('before effect');
	});
	$.subscribe('after', function(event,data) {
   	 setTimeout(function(){ $("#foldeffect").fadeIn(); }, 2000);
	});
    </script>        
	<h2>Fold Effect with Events</h2>
	<p class="text">
	    A Div with Fold Effect on click with events befor and after effect..
	</p>
    <strong>Div :</strong>
    <sj:div id="foldeffect" events="click" onBeforeTopics="before" onCompleteTopics="after" effect="fold" effectDuration="1600"  cssClass="result ui-widget-content ui-corner-all">
        Click me!<br/>
        Click me!<br/>
        Click me!<br/>
    </sj:div>
        
	<div class="code ui-widget-content ui-corner-all">
      <strong>JavaScript functions:</strong>
      <pre>
	   &lt;script type="text/javascript"&gt;
	$.subscribe('before', function(event,data) {
        alert('befor effect');
	});
	$.subscribe('after', function(event,data) {
   	 setTimeout(function(){ $("#foldeffect").fadeIn(); }, 2000);
	});
	   &lt;/script&gt;        
      </pre>
	  <strong>Code:</strong>
	  <pre>
    &lt;sj:div id=&quot;foldeffect&quot; events=&quot;click&quot; onBeforeTopics=&quot;before&quot; onCompleteTopics=&quot;after&quot; effect=&quot;fold&quot; effectDuration=&quot;1600&quot;  cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
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
