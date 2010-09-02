<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">

	<h2>Messages</h2>
	<p class="text">
	    A sample for jQuery UI styled Action Errors and Messages. The Style is dependend from your Theme.
	</p>
		<h3>Action Error</h3>
		<s:actionerror theme="jquery"/>
		<br/>
		<h3>Action Message</h3>
		<s:actionmessage theme="jquery"/>
		<br/>
		<h3>Field Errors</h3>
		<s:fielderror theme="jquery"/>
		<br/>
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
		&lt;h3&gt;Action Error&lt;/h3&gt;
		&lt;s:actionerror theme=&quot;jquery&quot;/&gt;
		
		&lt;h3&gt;Action Message&lt;/h3&gt;
		&lt;s:actionmessage theme=&quot;jquery&quot;/&gt;
		
		&lt;h3&gt;Field Errors&lt;/h3&gt;
		&lt;s:fielderror theme=&quot;jquery&quot;/&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
		