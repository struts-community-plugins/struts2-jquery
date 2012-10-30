<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Extend the Struts2 jQuery Plugin</h2>

<p class="text">
	An example to show how you can easy extend the plugin with new functionality.
</p>

<textarea name="richtextarea" id="richtextarea" rows="15" cols="80">
	Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel,
	gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio.
	Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
</textarea>
<script type='text/javascript'>
	// See js/extendplugin.js to see how to extend the jquery plugin
	$(document).ready(function () {

		var myrichtextoptions = {};
		myrichtextoptions.jqueryaction = "myrichtextextend";
		myrichtextoptions.id = "richtextarea";
		myrichtextoptions.wysiwygoptions = {};
		myrichtextoptions.wysiwygoptions.resizeOptions = {};
		$.mys2jextend.bind($('#richtextarea'), myrichtextoptions);
	});
</script>

<br/>
<br/>
<sj:tabbedpanel id="showextendcode">
	<sj:tab id="tab1" target="jsp" label="JSP Code"/>
	<sj:tab id="tab2" target="javascript" label="JavaScript Code"/>
	<div id="jsp">
	  <pre>
    &lt;textarea name=&quot;richtextarea&quot; id=&quot;richtextarea&quot; rows=&quot;15&quot; cols=&quot;80&quot;&gt;
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    &lt;/textarea&gt;
 &lt;script type='text/javascript'&gt;
	 // See js/extendplugin.js to see how to extend the jquery plugin
	$(document).ready(function () { 
		
		var myrichtextoptions = {};
		myrichtextoptions.jqueryaction = &quot;myrichtextextend&quot;;
		myrichtextoptions.id = &quot;richtextarea&quot;;
		myrichtextoptions.wysiwygoptions = {};
		myrichtextoptions.wysiwygoptions.resizeOptions = {};
		$.mys2jextend.bind($('#richtextarea'),myrichtextoptions);
	 });  
&lt;/script&gt;	
	  </pre>
	</div>
	<div id="javascript">
	  <pre>
( function($) {
	$.mys2jextend = {
			myrichtextextend : function($elem, options) {
				s2jlog('richtext for : '+options.id);
				$.requireCss(&quot;jquery.wysiwyg.css&quot;, &quot;js/jwysiwyg/&quot;);
				$.require(&quot;jquery.wysiwyg.js&quot;, null, &quot;js/jwysiwyg/&quot;);
				$elem.wysiwyg(options.wysiwygoptions);
				$(document).wysiwyg();
			}
	};

	$.extend($.mys2jextend, $.struts2_jquery);

})(jQuery);	  </pre>
	</div>
</sj:tabbedpanel>
