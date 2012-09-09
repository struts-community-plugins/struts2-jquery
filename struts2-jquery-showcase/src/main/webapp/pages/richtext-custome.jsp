<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url var="urlslider" action="slider"/><sj:a id="slidersimplelink" href="%{urlslider}" targets="main">Slider</sj:a></li>
      <li><s:url var="urlsliderform" action="slider-form"/><sj:a id="sliderformlink"  href="%{urlsliderform}" targets="main">Slider in a Form</sj:a></li>
      <li><s:url var="urlsliderrange" action="slider-range"/><sj:a id="sliderrangelink"  href="%{urlsliderrange}" targets="main">Slider with Range and Events</sj:a></li>
      <li><s:url var="urlprogressbar" action="progressbar"/><sj:a id="progressbarsimplelink" href="%{urlprogressbar}" targets="main">Progressbar</sj:a></li>
      <li><s:url var="urlprogressbarchange" action="progressbar-change"/><sj:a id="progressbarchangelink" href="%{urlprogressbarchange}" targets="main">Progressbar with change event</sj:a></li>
      <li><s:url var="urlprogressbarresizeable" action="progressbar-resizeable"/><sj:a id="progressbarresizeablelink" href="%{urlprogressbarresizeable}" targets="main">Resizeable progressbar</sj:a></li>
      <li><s:url var="urlspinner" action="spinner"/><sj:a id="spinnerlink" href="%{urlspinner}" targets="main">Spinner</sj:a></li>
      <li><s:url var="urlrichtexttinymce" action="richtext-tinymce"/><sj:a id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="main">Richtext - Tinymce</sj:a></li>
      <li><s:url var="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/><sj:a id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="main">Richtext - Tinymce (Advanced)</sj:a></li>
      <li><s:url var="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext - Ckeditor</sj:a></li>
      <li><s:url var="urlrichtextcustome" action="richtext-custome"/><sj:a id="richtextcustomelink" href="%{urlrichtextcustome}" targets="main">Richtext - Ckeditor (Custome Toolbar)</sj:a></li>
      <li><s:url var="urlmessages" action="messages"/><sj:a id="messageslink" href="%{urlmessages}" targets="main">Action Errors/Messages</sj:a></li>
      <li><s:url var="urlcharts" action="charts"/><sj:a id="chartslink" href="%{urlcharts}" targets="main">Charts</sj:a></li>
      <li><s:url var="urltree" action="tree"/><sj:a id="treelink" href="%{urltree}" targets="main">Tree</sj:a></li>
      <li><s:url var="urltreejson" action="tree-json"/><sj:a id="treejsonlink" href="%{urltreejson}" targets="main">Tree (JSON Data)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Richtext - Custome Toolbar</h2>
	<p class="text">
	    This Richtext Editor use a custome config file to define a custome toolbar. 
	    Also it loads the initial content via an AJAX request and the editor local is that to french.
	</p>
	<s:url var="remoteurl" action="ajax1"/>
	<s:set id="contextPath"  value="#request.get('javax.servlet.forward.context_path')" />
    <s:form id="formRichtextCustome" action="simpleecho" theme="xhtml">
	    <s:hidden name="escape" value="false"/>
		<sjr:ckeditor 
			label="Your Text"
			href="%{remoteurl}" 
			id="richtextCustomeEditor" 
			name="echo" 
			rows="10" 
			cols="80" 
			loadingText="Loading content of textarea ..."
			width="600"
			toolbar="MyToolbar"
			skin="v2"
			editorLocal="fr"
			customConfig="%{contextPath}/js/ckeditor.config.js"
		/>
		<sj:submit 
			targets="result" 
			value="AJAX Submit" 
			indicator="indicator" 
			button="true"
		/>
		<img id="indicator" 
			src="images/indicator.gif" 
			alt="Loading..." 
			style="display:none"/>
    </s:form>
<br/>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
<br/>
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
	&lt;s:url id=&quot;remoteurl&quot; action=&quot;ajax1&quot;/&gt;
	&lt;s:set id=&quot;contextPath&quot;  value=&quot;#request.get('javax.servlet.forward.context_path')&quot; /&gt;
    &lt;s:form id=&quot;formRichtextCustome&quot; action=&quot;simpleecho&quot; theme=&quot;xhtml&quot;&gt;
	    &lt;s:hidden name=&quot;escape&quot; value=&quot;false&quot;/&gt;
	    <strong>
		&lt;sjr:ckeditor 
			label=&quot;Your Text&quot;
			href=&quot;%{remoteurl}&quot; 
			id=&quot;richtextCustomeEditor&quot; 
			name=&quot;echo&quot; 
			rows=&quot;10&quot; 
			cols=&quot;80&quot; 
			loadingText=&quot;Loading content of textarea ...&quot;
			width=&quot;600&quot;
			toolbar=&quot;MyToolbar&quot;
			skin=&quot;fr&quot;
			editorLocal=&quot;v2&quot;
			customConfig=&quot;%{contextPath}/js/ckeditor.config.js&quot;
		/&gt;
	    </strong>
		&lt;sj:submit 
			targets=&quot;result&quot; 
			value=&quot;AJAX Submit&quot; 
			indicator=&quot;indicator&quot; 
			button=&quot;true&quot;
		/&gt;
		&lt;img id=&quot;indicator&quot; 
			src=&quot;images/indicator.gif&quot; 
			alt=&quot;Loading...&quot; 
			style=&quot;display:none&quot;/&gt;
    &lt;/s:form&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
