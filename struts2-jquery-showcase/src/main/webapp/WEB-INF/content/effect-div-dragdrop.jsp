<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Drag and Drop</h2>

<p class="text">
	Drag and Drop with Remote and Effect Div's.
</p>
<strong>Div :</strong>

<div class="draganddrop" style="width: 100%; height: 250px;">
	<sj:div id="draggablenonvalid" draggable="true" cssClass="noaccept ui-widget-content ui-corner-all"
	        cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;">
		I'm draggable but can't be dropped
	</sj:div>

	<sj:div id="draggable" draggable="true" draggableHandle="h3" draggableRevert="invalid"
	        cssClass="accept ui-widget-content ui-corner-all"
	        cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;">
		<h3 class="ui-widget-header">Drag me to my target</h3>

		<p></p>
	</sj:div>

	<s:url var="urlecho" action="echo"><s:param name="echo">I'm a remote div, drag me!</s:param></s:url>
	<sj:div href="%{urlecho}" id="draggableremote" draggable="true" indicator="indicator"
	        cssClass="accept ui-widget-content ui-corner-all"
	        cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;">
		<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
	</sj:div>

	<sj:div id="droptarget" droppable="true" droppableOnDropTopics="ondrop" droppableActiveClass="ui-state-hover"
	        droppableHoverClass="ui-state-active" droppableAccept=".accept" cssClass="ui-widget-content ui-corner-all"
	        cssStyle="width: 220px; height: 220px; padding: 0.5em; float: left; margin: 10px;">
		<p>Drop here</p>
	</sj:div>
</div>

<div class="code ui-widget-content ui-corner-all" style="clear: left;">
	<strong>JavaScript:</strong>
      <pre>
        &lt;script type="text/javascript"&gt;
		$.subscribe('ondrop', function(event,data) {
	        $(data).addClass('ui-state-highlight').find('p').html($(event.originalEvent.ui.draggable).attr('id')+' dropped!');
	        $(event.originalEvent.ui.draggable).find('p').html('I was dragged!');
		});
        &lt;/script&gt;        
      </pre>
	<strong>Code:</strong>
	  <pre>
    &lt;div class=&quot;draganddrop&quot; style=&quot;width: 100%; height: 250px;&quot;&gt;
	    &lt;sj:div id=&quot;draggablenonvalid&quot; <strong>draggable=&quot;true&quot;</strong> cssClass=&quot;noaccept ui-widget-content ui-corner-all&quot; cssStyle=&quot;width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;&quot;&gt;
	        I'm draggable but can't be dropped
	    &lt;/sj:div&gt;

	    &lt;sj:div id=&quot;draggable&quot;  <strong>draggable=&quot;true&quot; draggableHandle=&quot;h3&quot;
		  draggableRevert=&quot;invalid&quot;</strong> cssClass=&quot;accept ui-widget-content ui-corner-all&quot; cssStyle=&quot;width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;&quot;&gt;
	        &lt;h3 class=&quot;ui-widget-header&quot;&gt;Drag me to my target&lt;/h3&gt;
	        &lt;p&gt;&lt;/p&gt;
	    &lt;/sj:div&gt;

	    &lt;s:url id=&quot;urlecho&quot; action=&quot;echo&quot;&gt;&lt;s:param name=&quot;echo&quot;&gt;I'm a remote div, drag me!&lt;/s:param&gt;&lt;/s:url&gt;
	    &lt;sj:div href=&quot;%{urlecho}&quot; id=&quot;draggableremote&quot;  <strong>draggable=&quot;true&quot;</strong> indicator=&quot;indicator&quot; cssClass=&quot;accept ui-widget-content ui-corner-all&quot; cssStyle=&quot;width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;&quot; &gt;
            &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
        &lt;/sj:div&gt;

	    &lt;sj:div id=&quot;droptarget&quot; <strong>droppable=&quot;true&quot; droppableOnDropTopics=&quot;ondrop&quot;
		  droppableActiveClass=&quot;ui-state-hover&quot; droppableHoverClass=&quot;ui-state-active&quot;
		  droppableAccept=&quot;.accept&quot;</strong> cssClass=&quot;ui-widget-content ui-corner-all&quot; cssStyle=&quot;width: 220px; height: 220px; padding: 0.5em; float: left; margin: 10px;&quot;&gt;
	        &lt;p&gt;Drop here&lt;/p&gt;
	    &lt;/sj:div&gt;
    &lt;/div&gt;
	  </pre>
</div>
