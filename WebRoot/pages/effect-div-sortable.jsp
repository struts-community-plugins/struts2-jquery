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
	<h2>Sortable</h2>
	<p>
	    A simple sortable div list
	</p>
    <strong>Div :</strong><br/>
    <script type="text/javascript">
     function onStop(event, ui){
         var result = $("#selectresult").empty();
         $(".ui-selected").each(function(){
             result.append($(this).html()+' ');
         });
     }
    </script>  
    <sj:effectDiv id="sortable" sortable="true" sortableOpacity="0.8" sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true" cssStyle="width: 300px;">
        <div id="one" class="sortable ui-widget-content ui-corner-all">One</div>
        <div id="two" class="sortable ui-widget-content ui-corner-all">Two</div>
        <div id="three" class="sortable ui-widget-content ui-corner-all">Three</div>
        <div id="four" class="sortable ui-widget-content ui-corner-all">Four</div>
        <div id="five" class="sortable ui-widget-content ui-corner-all">Five</div>
        <div id="six" class="sortable ui-widget-content ui-corner-all">Six</div>
        <div id="seven" class="sortable ui-widget-content ui-corner-all">Seven</div>
    </sj:effectDiv>
        
	<div class="code ui-widget-content ui-corner-all" style="clear: left;">
      <strong>Styles:</strong>
      <pre>
.sortable {
border:1px solid #000;
height:20px;
margin:5px;
padding:10px;
text-align: center;
}
      </pre>
	  <strong>Code:</strong>
	  <pre>
    &lt;sj:effectDiv id="sortable" <strong>sortable="true" sortableOpacity="0.8" sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true"</strong> cssStyle="width: 300px;"&gt;
        &lt;div id="one" class="sortable ui-widget-content ui-corner-all"&gt;One&lt;/div&gt;
        &lt;div id="two" class="sortable ui-widget-content ui-corner-all"&gt;Two&lt;/div&gt;
        &lt;div id="three" class="sortable ui-widget-content ui-corner-all"&gt;Three&lt;/div&gt;
        &lt;div id="four" class="sortable ui-widget-content ui-corner-all"&gt;Four&lt;/div&gt;
        &lt;div id="five" class="sortable ui-widget-content ui-corner-all"&gt;Five&lt;/div&gt;
        &lt;div id="six" class="sortable ui-widget-content ui-corner-all"&gt;Six&lt;/div&gt;
        &lt;div id="seven" class="sortable ui-widget-content ui-corner-all"&gt;Seven&lt;/div&gt;
    &lt;/sj:effectDiv&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
