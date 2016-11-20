<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<script type="text/javascript">
	$(function () {
		$(".column div div .ui-icon").click(function () {
			$(this).toggleClass("ui-icon-minusthick");
			$(this).parents(".column div").find(".portlet-content").toggle();
		});
	});
	$.subscribe('onupdate', function (event, data) {
		var result = $("#sortableresult").empty();
		result.append("You move " + $(event.originalEvent.ui.item).find('.ui-widget-header > .title').html());
		result.append(' from ' + $(event.originalEvent.ui.sender).attr('id'));
		result.append(' to ' + $(event.originalEvent.ui.item).parent().attr('id'));
	});
</script>
<h2>Portlets with sortable</h2>

<p class="text">
	How to make portlet styled divs with the sortable interaction.
</p>
<strong>Message :</strong><span id="sortableresult">Use the title from each portlet as handle.</span><br/>
<div class="ym-grid">
	<div class="ym-g33 ym-gl">
<sj:div id="column1" cssClass="column ym-gbox" sortable="true" sortableConnectWith=".column"
        sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true"
        sortableHandle="div.ui-widget-header" sortableCursor="crosshair" sortableOnUpdateTopics="onupdate">

	<div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
		<div class="ui-widget-header ui-corner-all"><span class="title">Feeds</span><span
				class="ui-icon ui-icon-plusthick"></span></div>
		<div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
	</div>

	<div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
		<div class="ui-widget-header ui-corner-all"><span class="title">News</span><span
				class="ui-icon ui-icon-plusthick"></span></div>
		<div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
	</div>

</sj:div>
	</div>
	<div class="ym-g33 ym-gl">
<sj:div id="column2" cssClass="column ym-gbox" sortable="true" sortableConnectWith=".column"
        sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true"
        sortableHandle="div.ui-widget-header" sortableCursor="crosshair" sortableOnUpdateTopics="onupdate">

	<div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
		<div class="ui-widget-header ui-corner-all"><span class="title">Shopping</span><span
				class="ui-icon ui-icon-plusthick"></span></div>
		<div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
	</div>

</sj:div>
	</div>
	<div class="ym-g33 ym-gl">
<sj:div id="column3" cssClass="column ym-gbox" sortable="true" sortableConnectWith=".column"
        sortablePlaceholder="ui-state-highlight" sortableForcePlaceholderSize="true"
        sortableHandle="div.ui-widget-header" sortableCursor="crosshair" sortableOnUpdateTopics="onupdate">

	<div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
		<div class="ui-widget-header ui-corner-all"><span class="title">Links</span><span
				class="ui-icon ui-icon-plusthick"></span></div>
		<div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
	</div>

	<div class="ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
		<div class="ui-widget-header ui-corner-all"><span class="title">Images</span><span
				class="ui-icon ui-icon-plusthick"></span></div>
		<div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
	</div>

</sj:div>
	</div>
</div>
<h4 style="clear: both;">Source Code</h4>

<sj:tabbedpanel id="sourcecode">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript"/>
	<sj:tab id="tab3" target="stylesheet" label="Styles"/>
	<div id="jsp">
	    <pre>
            <code class="html">
&lt;sj:div id=&quot;column1&quot; cssClass=&quot;column&quot; sortable=&quot;true&quot; sortableConnectWith=&quot;.column&quot;
sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot;
sortableHandle=&quot;div.ui-widget-header&quot; sortableCursor=&quot;crosshair&quot; sortableOnUpdateTopics=&quot;onupdate&quot;&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Feeds&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;News&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

&lt;/sj:div&gt;

&lt;sj:div id=&quot;column2&quot; cssClass=&quot;column&quot; sortable=&quot;true&quot; sortableConnectWith=&quot;.column&quot;
sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot;
sortableHandle=&quot;div.ui-widget-header&quot; sortableCursor=&quot;crosshair&quot; sortableOnUpdateTopics=&quot;onupdate&quot;&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Shopping&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

&lt;/sj:div&gt;

&lt;sj:div id=&quot;column3&quot; cssClass=&quot;column&quot; sortable=&quot;true&quot; sortableConnectWith=&quot;.column&quot;
sortablePlaceholder=&quot;ui-state-highlight&quot; sortableForcePlaceholderSize=&quot;true&quot;
sortableHandle=&quot;div.ui-widget-header&quot; sortableCursor=&quot;crosshair&quot; sortableOnUpdateTopics=&quot;onupdate&quot;&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Links&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

    &lt;div class=&quot;ui-widget ui-widget-content ui-helper-clearfix ui-corner-all&quot;&gt;
        &lt;div class=&quot;ui-widget-header ui-corner-all&quot;&gt;&lt;span class=&quot;title&quot;&gt;Images&lt;/span&gt;&lt;span class=&quot;ui-icon ui-icon-plusthick&quot;&gt;&lt;/span&gt;&lt;/div&gt;
        &lt;div class=&quot;portlet-content&quot;&gt;Lorem ipsum dolor sit amet, consectetuer adipiscing elit&lt;/div&gt;
    &lt;/div&gt;

&lt;/sj:div&gt;
            </code>
	    </pre>
	</div>
	<div id="javascript">
	    <pre>
          <code class="javascript">
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
		  </code>
	    </pre>
	</div>
	<div id="stylesheet">
	    <pre>
          <code class="stylesheet">
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

		  </code>
	    </pre>
	</div>
</sj:tabbedpanel>
