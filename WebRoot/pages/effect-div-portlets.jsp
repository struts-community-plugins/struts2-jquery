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
    <script type="text/javascript">
    $(function() {
        $(".column div div .ui-icon").click(function() {
            $(this).toggleClass("ui-icon-minusthick");
            $(this).parents(".column div").find(".portlet-content").toggle();
        });
    });
	$.subscribe('onupdate', function(event,data) {
        var result = $("#sortableresult").empty();
        result.append("You move "+$(event.originalEvent.ui.item).find('.ui-widget-header > .title').html());
        result.append(' from '+$(event.originalEvent.ui.sender).attr('id'));
        result.append(' to '+$(event.originalEvent.ui.item).parent().attr('id'));
	});
    </script>  
	<h2>Portlets with sortable</h2>
	<p>
	    How to make portlet styled divs with the sortable interaction.
	</p>
    <strong>Message :</strong><span id="sortableresult">Use the title from each portlet as handle.</span><br/>
<sj:div id="column1" cssClass="column" sortable="true" sortableConnectWith=".column" sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true" sortableHandle="div.ui-widget-header" sortableCursor="crosshair" sortableOnUpdateTopics="onupdate">

    <div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
        <div class="ui-widget-header ui-corner-all"><span class="title">Feeds</span><span class="ui-icon ui-icon-plusthick"></span></div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>
    
    <div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
        <div class="ui-widget-header ui-corner-all"><span class="title">News</span><span class="ui-icon ui-icon-plusthick"></span></div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>

</sj:div>

<sj:div id="column2" cssClass="column" sortable="true" sortableConnectWith=".column" sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true" sortableHandle="div.ui-widget-header" sortableCursor="crosshair" sortableOnUpdateTopics="onupdate">

    <div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
        <div class="ui-widget-header ui-corner-all"><span class="title">Shopping</span><span class="ui-icon ui-icon-plusthick"></span></div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>

</sj:div>

<sj:div id="column3" cssClass="column" sortable="true" sortableConnectWith=".column" sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true" sortableHandle="div.ui-widget-header" sortableCursor="crosshair" sortableOnUpdateTopics="onupdate">

    <div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
        <div class="ui-widget-header ui-corner-all"><span class="title">Links</span><span class="ui-icon ui-icon-plusthick"></span></div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>
    
    <div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
        <div class="ui-widget-header ui-corner-all"><span class="title">Images</span><span class="ui-icon ui-icon-plusthick"></span></div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>

</sj:div>
        
	<div class="code ui-widget-content ui-corner-all" style="clear: left;">
      <strong>Styles:</strong>
      <pre>
	.column { 
	width: 170px;
	float: left;
	padding-bottom: 100px;
	}
	
	.column div { 
	margin:5px;
	}
	
	.column div div .ui-icon { 
	float: right;
	}
      </pre>
      <strong>JavaScript:</strong>
      <pre>
    &lt;script type="text/javascript"&gt;
    $(function() {
        $(".column div div .ui-icon").click(function() {
            $(this).toggleClass("ui-icon-minusthick");
            $(this).parents(".column div").find(".portlet-content").toggle();
        });
    });
	$.subscribe('onupdate', function(event,data) {
        var result = $("#sortableresult").empty();
        result.append("You move "+$(event.originalEvent.ui.item).find('.ui-widget-header > .title').html());
        result.append(' from '+$(event.originalEvent.ui.sender).attr('id'));
        result.append(' to '+$(event.originalEvent.ui.item).parent().attr('id'));
	});
    &lt;/script&gt;  
      </pre>
	  <strong>Code:</strong>
	  <pre>
&lt;sj:div id=&quot;column1&quot; cssClass=&quot;column&quot; <strong>sortable=&quot;true&quot; sortableConnectWith=&quot;.column&quot; sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot; sortableHandle=&quot;div.ui-widget-header&quot; sortableCursor=&quot;crosshair&quot; sortableOnUpdateTopics=&quot;onupdate&quot;</strong>&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Feeds&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;
    
    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;News&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

&lt;/sj:div&gt;

&lt;sj:div id=&quot;column2&quot; cssClass=&quot;column&quot; <strong>sortable=&quot;true&quot; sortableConnectWith=&quot;.column&quot; sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot; sortableHandle=&quot;div.ui-widget-header&quot; sortableCursor=&quot;crosshair&quot; sortableOnUpdateTopics=&quot;onupdate&quot;</strong>&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Shopping&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

&lt;/sj:div&gt;

&lt;sj:div id=&quot;column3&quot; cssClass=&quot;column&quot; <strong>sortable=&quot;true&quot; sortableConnectWith=&quot;.column&quot; sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot; sortableHandle=&quot;div.ui-widget-header&quot; sortableCursor=&quot;crosshair&quot; sortableOnUpdateTopics=&quot;onupdate&quot;</strong>&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Links&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;
    
    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Images&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

&lt;/sj:div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
