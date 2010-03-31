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
	<h2>Selectable</h2>
	<p>
	    Selectable with Effect Div.
	</p>
    <script type="text/javascript">
	$.subscribe('onstop', function(event,data) {
        var result = $("#selectresult").empty();
        $(".ui-selected").each(function(){
            result.append($(this).html()+' ');
        });
	});
    </script>  
    You've selected:  <span id="selectresult"></span>. <br/>     
     <strong>Selectable Divs :</strong><br/>
    <sj:div id="selectabledivs" selectableOnStopTopics="onstop" selectable="true" cssStyle="width: 400px; loat: left; border-right: 1px dotted #FECA40">
        <div id="one" class="selectable ui-corner-all">One</div>
        <div id="two" class="selectable ui-corner-all">Two</div>
        <div id="three" class="selectable ui-corner-all">Three</div>
        <div id="four" class="selectable ui-corner-all">Four</div>
        <div id="five" class="selectable ui-corner-all">Five</div>
        <div id="six" class="selectable ui-corner-all">Six</div>
    </sj:div>
     <sj:div id="selectablelist" selectableOnStopTopics="onstop" selectable="true" selectableFilter="li" cssStyle="margin-left: 410px; width: 200px;">
        <strong>Selectable Listitems :</strong><br/>
        <ul>
        <li id="seven" class="selectablelist ui-corner-all">Seven</li>
        <li id="eight" class="selectablelist ui-corner-all">Eight</li>
        <li id="nine" class="selectablelist ui-corner-all">Nine</li>
        <li id="ten" class="selectablelist ui-corner-all">Ten</li>
        <li id="eleven" class="selectablelist ui-corner-all">Eleven</li>
        <li id="twelve" class="selectablelist ui-corner-all">Twelve</li>
        </ul>
    </sj:div>
        
	<div class="code ui-widget-content ui-corner-all" style="clear: left;">
      <strong>Styles:</strong>
      <pre>
.selectable {
border:1px solid #000;
float:left;
height:80px;
margin:5px;
padding:20px;
width:80px;
}

.selectablelist {
border:1px solid #000;
height:25px;
margin:5px;
padding:10px;
list-style-type: none;
}

.ui-selected {
background:#F39814;
color:#FFF;
}

.ui-selecting {
background:#FECA40;
}
      </pre>
      <strong>JavaScript:</strong>
      <pre>
    &lt;script type="text/javascript"&gt;
	$.subscribe('onstop', function(event,data) {
        var result = $("#selectresult").empty();
        $(".ui-selected").each(function(){
            result.append($(this).html()+' ');
        });
	});
    &lt;/script&gt;  
      </pre>
	  <strong>Code:</strong>
	  <pre>
    You've selected:  &lt;span id="selectresult"&gt;&lt;/span&gt;. &lt;br/&gt;     
     &lt;strong&gt;Selectable Divs :&lt;/strong&gt;&lt;br/&gt;
    &lt;sj:div id=&quot;selectabledivs&quot; <strong>selectableOnStopTopics=&quot;onstop&quot; selectable=&quot;true&quot;</strong> cssStyle=&quot;width: 400px; loat: left; border-right: 1px dotted #FECA40&quot;&gt;
        &lt;div id=&quot;one&quot; class=&quot;selectable ui-corner-all&quot;&gt;One&lt;/div&gt;
        &lt;div id=&quot;two&quot; class=&quot;selectable ui-corner-all&quot;&gt;Two&lt;/div&gt;
        &lt;div id=&quot;three&quot; class=&quot;selectable ui-corner-all&quot;&gt;Three&lt;/div&gt;
        &lt;div id=&quot;four&quot; class=&quot;selectable ui-corner-all&quot;&gt;Four&lt;/div&gt;
        &lt;div id=&quot;five&quot; class=&quot;selectable ui-corner-all&quot;&gt;Five&lt;/div&gt;
        &lt;div id=&quot;six&quot; class=&quot;selectable ui-corner-all&quot;&gt;Six&lt;/div&gt;
    &lt;/sj:div&gt;
     &lt;sj:div id=&quot;selectablelist&quot; <strong>selectableOnStopTopics=&quot;onstop&quot; selectable=&quot;true&quot; selectableFilter=&quot;li&quot;</strong> cssStyle=&quot;margin-left: 410px; width: 200px;&quot;&gt;
        &lt;strong&gt;Selectable Listitems :&lt;/strong&gt;&lt;br/&gt;
        &lt;ul&gt;
        &lt;li id=&quot;seven&quot; class=&quot;selectablelist ui-corner-all&quot;&gt;Seven&lt;/li&gt;
        &lt;li id=&quot;eight&quot; class=&quot;selectablelist ui-corner-all&quot;&gt;Eight&lt;/li&gt;
        &lt;li id=&quot;nine&quot; class=&quot;selectablelist ui-corner-all&quot;&gt;Nine&lt;/li&gt;
        &lt;li id=&quot;ten&quot; class=&quot;selectablelist ui-corner-all&quot;&gt;Ten&lt;/li&gt;
        &lt;li id=&quot;eleven&quot; class=&quot;selectablelist ui-corner-all&quot;&gt;Eleven&lt;/li&gt;
        &lt;li id=&quot;twelve&quot; class=&quot;selectablelist ui-corner-all&quot;&gt;Twelve&lt;/li&gt;
        &lt;/ul&gt;
    &lt;/sj:div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
