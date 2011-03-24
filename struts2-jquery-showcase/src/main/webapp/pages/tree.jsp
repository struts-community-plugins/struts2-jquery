<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjt" uri="/struts-jquery-tree-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlslider" action="slider"/><sj:a id="slidersimplelink" href="%{urlslider}" targets="main">Slider</sj:a></li>
      <li><s:url id="urlsliderform" action="slider-form"/><sj:a id="sliderformlink"  href="%{urlsliderform}" targets="main">Slider in a Form</sj:a></li>
      <li><s:url id="urlsliderrange" action="slider-range"/><sj:a id="sliderrangelink"  href="%{urlsliderrange}" targets="main">Slider with Range and Events</sj:a></li>
      <li><s:url id="urlprogressbar" action="progressbar"/><sj:a id="progressbarsimplelink" href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url id="urlprogressbarchange" action="progressbar-change"/><sj:a id="progressbarchangelink" href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url id="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
      <li><s:url id="urlspinner" action="spinner"/><sj:a id="spinnerlink" href="%{urlspinner}" targets="main">Spinner</sj:a></li>
      <li><s:url id="urlrichtexttinymce" action="richtext-tinymce"/><sj:a id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="main">Richtext - Tinymce</sj:a></li>
      <li><s:url id="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/><sj:a id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="main">Richtext - Tinymce (Advanced)</sj:a></li>
      <li><s:url id="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext - Ckeditor</sj:a></li>
      <li><s:url id="urlrichtextcustome" action="richtext-custome"/><sj:a id="richtextcustomelink" href="%{urlrichtextcustome}" targets="main">Richtext - Ckeditor (Custome Toolbar)</sj:a></li>
      <li><s:url id="urlmessages" action="messages"/><sj:a id="messageslink" href="%{urlmessages}" targets="main">Action Errors/Messages</sj:a></li>
      <li><s:url id="urlcharts" action="charts"/><sj:a id="chartslink" href="%{urlcharts}" targets="main">Charts</sj:a></li>
      <li><s:url id="urltree" action="tree"/><sj:a id="treelink" href="%{urltree}" targets="main">Tree</sj:a></li>
      <li><s:url id="urltreejson" action="tree-json"/><sj:a id="treejsonlink" href="%{urltreejson}" targets="main">Tree (JSON Data)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Static Tree</h2>
    <p class="text">
        A simple static Tree Component.
    </p>
    	<sjt:tree id="treeStatic" jstreetheme="default">
    		<sjt:treeItem title="Struts2">
	    		<sjt:treeItem title="General">
		    		<sjt:treeItem title="Struts2" href="http://struts.apache.org/2.x/index.html"/>
		    		<sjt:treeItem title="Struts2 @ Facebook" href="http://www.facebook.com/pages/Struts2-Users/103890046351798"/>
    			</sjt:treeItem>
	    		<sjt:treeItem title="Plugins">
		    		<sjt:treeItem title="Struts2 Plugins" href="https://cwiki.apache.org/S2PLUGINS/home.html"/>
		    		<sjt:treeItem title="Struts2 jQuery Plugin" href="http://code.google.com/p/struts2-jquery/"/>
		    		<sjt:treeItem title="Struts2 Full Hibernate Plugin" href="http://code.google.com/p/full-hibernate-plugin-for-struts2/"/>
    			</sjt:treeItem>
	    		<sjt:treeItem title="Blogs">
		    		<sjt:treeItem title="Struts2 jQuery News" href="http://www.jgeppert.com/category/java/struts2-jquery/"/>
    			</sjt:treeItem>
	    		<sjt:treeItem title="AJAX Links">
					<s:url id="ajax1" value="/ajax1.action"/>
		    		<sjt:treeItem title="Ajax 1" href="%{ajax1}" targets="result"/>
					<s:url id="ajax2" value="/ajax2.action"/>
		    		<sjt:treeItem title="Ajax 2" href="%{ajax2}" targets="result" effect="highlight" effectDuration="2500"/>
					<s:url id="ajax3" value="/ajax3.action"/>
		    		<sjt:treeItem title="Ajax 3" href="%{ajax3}" targets="result" onBeforeTopics="beforeLink" onCompleteTopics="completeLink"/>
					<s:url id="ajax4" value="/ajax4.action"/>
		    		<sjt:treeItem title="Ajax 4" href="%{ajax4}" targets="result" effect="bounce" effectDuration="1000"/>
    			</sjt:treeItem>
    		</sjt:treeItem>
    	</sjt:tree>
  
  <strong>Result Div :</strong>
  <div id="result" class="result ui-widget-content ui-corner-all">Click on the AJAX Links above.</div>

    <h2>Dynamic Tree</h2>
    <p class="text">
        A Tree Component rendered on the server.
    </p>

		<s:url id="echo" value="/echo.action"/>
    	<sjt:tree 
    		id="treeDynamic" 
    		jstreetheme="default"
    		rootNode="nodes"
    		childCollectionProperty="children"
    		nodeTitleProperty="title"
    		nodeIdProperty="id"
    		nodeHref="%{echo}"
    		nodeHrefParamName="echo"
    	/>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    	&lt;sjt:tree id=&quot;tree&quot; jstreetheme=&quot;default&quot;&gt;
    		&lt;sjt:treeItem title=&quot;Struts2&quot;&gt;
	    		&lt;sjt:treeItem title=&quot;General&quot;&gt;
		    		&lt;sjt:treeItem title=&quot;Struts2&quot; href=&quot;http://struts.apache.org/2.x/index.html&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Struts2 @ Facebook&quot; href=&quot;http://www.facebook.com/pages/Struts2-Users/103890046351798&quot;/&gt;
    			&lt;/sjt:treeItem&gt;
	    		&lt;sjt:treeItem title=&quot;Plugins&quot;&gt;
		    		&lt;sjt:treeItem title=&quot;Struts2 Plugins&quot; href=&quot;https://cwiki.apache.org/S2PLUGINS/home.html&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Struts2 jQuery Plugin&quot; href=&quot;http://code.google.com/p/struts2-jquery/&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Struts2 Full Hibernate Plugin&quot; href=&quot;http://code.google.com/p/full-hibernate-plugin-for-struts2/&quot;/&gt;
    			&lt;/sjt:treeItem&gt;
	    		&lt;sjt:treeItem title=&quot;Blogs&quot;&gt;
		    		&lt;sjt:treeItem title=&quot;Struts2 jQuery News&quot; href=&quot;http://www.jgeppert.com/category/java/struts2-jquery/&quot;/&gt;
    			&lt;/sjt:treeItem&gt;
	    		&lt;sjt:treeItem title=&quot;AJAX Links&quot;&gt;
					&lt;s:url id=&quot;ajax1&quot; value=&quot;/ajax1.action&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Ajax 1&quot; href=&quot;%{ajax1}&quot; targets=&quot;result&quot;/&gt;
					&lt;s:url id=&quot;ajax2&quot; value=&quot;/ajax2.action&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Ajax 2&quot; href=&quot;%{ajax2}&quot; targets=&quot;result&quot; effect=&quot;highlight&quot; effectDuration=&quot;2500&quot;/&gt;
					&lt;s:url id=&quot;ajax3&quot; value=&quot;/ajax3.action&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Ajax 3&quot; href=&quot;%{ajax3}&quot; targets=&quot;result&quot; onBeforeTopics=&quot;beforeLink&quot; onCompleteTopics=&quot;completeLink&quot;/&gt;
					&lt;s:url id=&quot;ajax4&quot; value=&quot;/ajax4.action&quot;/&gt;
		    		&lt;sjt:treeItem title=&quot;Ajax 4&quot; href=&quot;%{ajax4}&quot; targets=&quot;result&quot; effect=&quot;bounce&quot; effectDuration=&quot;1000&quot;/&gt;
    			&lt;/sjt:treeItem&gt;
    		&lt;/sjt:treeItem&gt;
    	&lt;/sjt:tree&gt;
  &lt;/div&gt;
  
  &lt;strong&gt;Result Div :&lt;/strong&gt;
  &lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
