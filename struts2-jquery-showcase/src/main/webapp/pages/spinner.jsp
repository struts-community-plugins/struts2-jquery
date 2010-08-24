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
    <h2>Spinner</h2>
    <p class="text">
        A Spinner Widget.
    </p>
    <h3>A simple Spinner</h3>
    <sj:spinner name="spinner1" id="spinner1"/>
    <br/>
    <br/>
    <h3>A Spinner max=50 and step=2</h3>
    <sj:spinner 
    	name="spinner2" 
    	id="spinner2" 
    	min="5" 
    	max="50" 
    	step="2" 
    	value="25"/>
    <br/>
    <br/>
    <h3>A Spinner with currency format and mouse wheel support</h3>
    <sj:spinner 
    	name="spinner3" 
    	id="spinner3" 
    	min="0.00" 
    	max="5.00" 
    	step="0.15" 
    	value="2.50" 
    	suffix="$" 
    	mouseWheel="true"/>
    <br/>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;h3&gt;A simple Spinner&lt;/h3&gt;
    &lt;sj:spinner name=&quot;spinner1&quot; id=&quot;spinner1&quot;/&gt;
    &lt;br/&gt;
    &lt;br/&gt;
    &lt;h3&gt;A Spinner max=50 and step=2&lt;/h3&gt;
    &lt;sj:spinner 
    	name=&quot;spinner2&quot; 
    	id=&quot;spinner2&quot; 
    	min=&quot;5&quot; 
    	max=&quot;50&quot; 
    	step=&quot;2&quot; 
    	value=&quot;25&quot;/&gt;
    &lt;br/&gt;
    &lt;br/&gt;
    &lt;h3&gt;A Spinner with currency format and mouse wheel support&lt;/h3&gt;
    &lt;sj:spinner 
    	name=&quot;spinner3&quot; 
    	id=&quot;spinner3&quot; 
    	min=&quot;0.00&quot; 
    	max=&quot;5.00&quot; 
    	step=&quot;0.15&quot; 
    	value=&quot;2.50&quot; 
    	suffix=&quot;$&quot; 
    	mouseWheel=&quot;true&quot;/&gt;
    &lt;br/&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
