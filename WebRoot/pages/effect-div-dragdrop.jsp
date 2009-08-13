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
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Drag and Drop</h2>
	<p>
	    Drag and Drop with Remote and Effect Div's.
	</p>
    <strong>Div :</strong>
    <script type="text/javascript">
     function onDrop(event, ui, droppable){
         droppable.addClass('ui-state-highlight').find('p').html($(ui.draggable).attr('id')+' dropped!');
         $(ui.draggable).find('p').html('I was dragged!');
     }
    </script>        
    <div class="draganddrop" style="width: 100%; height: 250px;">
	    <sj:effectDiv id="draggablenonvalid" draggable="true" cssClass="noaccept ui-widget-content ui-corner-all" cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;">
	        I'm draggable but can't be dropped
	    </sj:effectDiv>
	    
	    <sj:effectDiv id="draggable"  draggable="true" draggableHandle="h3" draggableRevert="invalid" cssClass="accept ui-widget-content ui-corner-all" cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;">
	        <h3 class="ui-widget-header">Drag me to my target</h3>
	        <p></p>
	    </sj:effectDiv>
	    
	    <s:url id="urlecho" action="echo"><s:param name="echo">I'm a remote div, drag me!</s:param></s:url>
	    <sj:div href="%{urlecho}" id="draggableremote"  draggable="true" indicator="indicator" cssClass="accept ui-widget-content ui-corner-all" cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;" >
            <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
        </sj:div>
	    
	    <sj:effectDiv droppableDrop="onDrop" droppableActiveClass="ui-state-hover" droppableHoverClass="ui-state-active" droppable="true" droppableAccept=".accept" cssClass="ui-widget-content ui-corner-all" cssStyle="width: 220px; height: 220px; padding: 0.5em; float: left; margin: 10px;">
	        <p>Drop here</p>
	    </sj:effectDiv>
    </div>
        
	<div class="code ui-widget-content ui-corner-all" style="clear: left;">
      <strong>JavaScript:</strong>
      <pre>
        &lt;script type="text/javascript"&gt;
	     function onDrop(event, ui, droppable){
	         droppable.addClass('ui-state-highlight').find('p').html($(ui.draggable).attr('id')+' dropped!');
	         $(ui.draggable).find('p').html('I was dragged!');
	     }
        &lt;/script&gt;        
      </pre>
	  <strong>Code:</strong>
	  <pre>
        &lt;sj:effectDiv id="draggablenonvalid" <strong>draggable="true"</strong> cssClass="<strong>noaccept</strong> ui-widget-content ui-corner-all" cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;"&gt;
            I'm draggable but can't be dropped
        &lt;/sj:effectDiv&gt;
        
        &lt;sj:effectDiv <strong>id="draggable"  draggable="true" draggableHandle="h3" draggableRevert="invalid"</strong> cssClass="<strong>accept</strong> ui-widget-content ui-corner-all" cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;"&gt;
            &lt;h3 class="ui-widget-header"&gt;Drag me to my target&lt;/h3&gt;
            &lt;p&gt;&lt;/p&gt;
        &lt;/sj:effectDiv&gt;
        
        &lt;s:url id="urlecho" action="echo">&lt;s:param name="echo"&gt;I'm a remote div, drag me!&lt;/s:param&gt;&lt;/s:url&gt;
        &lt;sj:div href="%{urlecho}" id="draggableremote"  <strong>draggable="true"</strong> indicator="indicator" cssClass="<strong>accept</strong> ui-widget-content ui-corner-all" &gt;
            &lt;img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/&gt;
        &lt;/sj:div&gt;
        
        &lt;sj:effectDiv <strong>droppableDrop="onDrop" droppableActiveClass="ui-state-hover" droppableHoverClass="ui-state-active" droppable="true" droppableAccept=".accept"</strong> cssClass="ui-widget-content ui-corner-all"&gt;
            &lt;p&gt;Drop here&lt;/p&gt;
        &lt;/sj:effectDiv&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
