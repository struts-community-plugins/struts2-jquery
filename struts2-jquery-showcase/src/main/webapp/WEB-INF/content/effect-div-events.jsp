<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<script type="text/javascript">
	$.subscribe('before', function (event, data) {
		alert('before effect');
	});
	$.subscribe('after', function (event, data) {
		setTimeout(function () {
			$("#foldeffect").fadeIn();
		}, 2000);
	});
</script>
<h2>Fold Effect with Events</h2>

<p class="text">
	A Div with Fold Effect on click with events befor and after effect..
</p>
<strong>Div :</strong>
<sj:div
		id="foldeffect"
		events="click"
		onBeforeTopics="before"
		onCompleteTopics="after"
		effect="fold"
        effectDuration="1600"
		cssClass="result ui-widget-content ui-corner-all"
>
	Click me!<br/>
	Click me!<br/>
	Click me!<br/>
</sj:div>

<h4>Source Code</h4>

<sj:tabbedpanel id="sourcecode">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript"/>
	<div id="jsp">
	    <pre>
            <code class="html">
&lt;sj:div
		id=&quot;foldeffect&quot;
		events=&quot;click&quot;
		onBeforeTopics=&quot;before&quot;
		onCompleteTopics=&quot;after&quot;
		effect=&quot;fold&quot;
		effectDuration=&quot;1600&quot;
		cssClass=&quot;result ui-widget-content ui-corner-all&quot;
&gt;
	Click me!&lt;br/&gt;
	Click me!&lt;br/&gt;
	Click me!&lt;br/&gt;
&lt;/sj:div&gt;
			</code>
	    </pre>
	</div>
	<div id="javascript">
	    <pre>
          <code class="javascript">
$.subscribe('before', function(event,data) {
	alert('before effect');
});
$.subscribe('after', function(event,data) {
	setTimeout(function(){ $("#foldeffect").fadeIn(); }, 2000);
});
		  </code>
	    </pre>
	</div>
</sj:tabbedpanel>
