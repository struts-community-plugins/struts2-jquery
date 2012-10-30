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
<sj:div id="foldeffect" events="click" onBeforeTopics="before" onCompleteTopics="after" effect="fold"
        effectDuration="1600" cssClass="result ui-widget-content ui-corner-all">
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
