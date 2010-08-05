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
      <li><s:url id="urlrichtexttinymce" action="richtext-tinymce"/><sj:a id="richtexttinymcelink" href="%{urlrichtexttinymce}" targets="main">Richtext - Tinymce</sj:a></li>
      <li><s:url id="urlrichtexttinymceadvanced" action="richtext-tinymce-advanced"/><sj:a id="richtexttinymcelinkadvanced" href="%{urlrichtexttinymceadvanced}" targets="main">Richtext - Tinymce (Advanced)</sj:a></li>
      <li><s:url id="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext - Ckeditor</sj:a></li>
      <li><s:url id="urlrichtextcustome" action="richtext-custome"/><sj:a id="richtextcustomelink" href="%{urlrichtextcustome}" targets="main">Richtext - Ckeditor (Custome Toolbar)</sj:a></li>
      <li><s:url id="urlmessages" action="messages"/><sj:a id="messageslink" href="%{urlmessages}" targets="main">Action Errors/Messages</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Slider</h2>
    <p class="text">
        A simple Slider
    </p>
    <sj:slider id="simpleslider"/>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;sj:slider id=&quot;simpleslider&quot;/&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
