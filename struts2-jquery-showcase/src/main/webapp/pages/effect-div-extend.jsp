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
	<h2>Extend the Struts2 jQuery Plugin</h2>
	<p>
	    An example to show how you can easy extend the plugin with new functionality.
	</p>
    
    <textarea name="richtextarea" id="richtextarea" rows="15" cols="70">
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </textarea>
 <script type='text/javascript'>
	 // See js/extendplugin.js to see how to extend the jquery plugin
	$(document).ready(function () { 
		
		var myrichtextoptions = {};
		myrichtextoptions.jqueryaction = "myrichtextextend";
		myrichtextoptions.id = "richtextarea";
		myrichtextoptions.wysiwygoptions = {};
		myextend.bind($('#richtextarea'),myrichtextoptions);
	 });  
</script>	

<br/>
<br/>
    <sj:tabbedpanel id="showextendcode">
      <sj:tab id="tab1" target="jsp" label="JSP Code"/>
      <sj:tab id="tab2" target="javascript" label="JavaScript Code"/>
      <div id="jsp">
	  <pre>
    &lt;textarea name=&quot;richtextarea&quot; id=&quot;richtextarea&quot; rows=&quot;15&quot; cols=&quot;70&quot;&gt;
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    &lt;/textarea&gt;
 &lt;script type='text/javascript'&gt;
	 // See js/extendplugin.js to see how to extend the jquery plugin
	$(document).ready(function () { 
		
		var myrichtextoptions = {};
		myrichtextoptions.jqueryaction = &quot;myrichtextextend&quot;;
		myrichtextoptions.id = &quot;richtextarea&quot;;
		myrichtextoptions.wysiwygoptions = {};
		myextend.bind($('#richtextarea'),myrichtextoptions);
	 });  
&lt;/script&gt;	
	  </pre>
	  </div>
      <div id="javascript">
	  <pre>
	var myextend = {
			myrichtextextend : function($elem, options) {
				s2jlog('richtext for : '+options.id);
				$.requireCss(&quot;jquery.wysiwyg.css&quot;, &quot;js/jwysiwyg/&quot;);
				$.require(&quot;jquery.wysiwyg.js&quot;, null, &quot;js/jwysiwyg/&quot;);
				$elem.wysiwyg(options.wysiwygoptions);
				$(document).wysiwyg();
			}
	};

	$.extend(myextend, $.struts2_jquery);
	  </pre>
	  </div>
    </sj:tabbedpanel>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
