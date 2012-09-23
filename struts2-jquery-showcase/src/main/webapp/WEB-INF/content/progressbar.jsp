<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
    <h2>Progressbar</h2>
    <p class="text">
        A simple Progressbar
    </p>
    <sj:progressbar id="progressbar" value="%{random}"/>

	<br/><br/>
	
    <h2>Progressbar with Execute And Wait Interceptor</h2>
    <p class="text">
        A Progressbar in Combination with the Execute And Wait Interceptor.
    </p>
    
    <img id="indicator" 
       	src="images/indicator.gif" 
       	alt="Loading..." 
       	style="display:none"/>
    <s:url var="longRunningProcessUrl" value="/long-running-process.action"/>
    <sj:div id="divWithLongRunningProcess" 
    		href="%{longRunningProcessUrl}" 
    		indicator="indicator" 
    		reloadTopics="reloadWithLongRunningProcess"
    		listenTopics="startLongRunningProcess" 
    		effect="highlight" 
    		cssClass="result ui-widget-content ui-corner-all">
    </sj:div>
    <sj:a 	
    	id="startProcessLink" 
    	onClickTopics="startLongRunningProcess" 
		button="true" 
		buttonIcon="ui-icon-refresh"
    >
    	Refresh Process Status
    </sj:a>

  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
     &lt;h2&gt;Progressbar&lt;/h2&gt;
    &lt;p class=&quot;text&quot;&gt;
        A simple Progressbar
    &lt;/p&gt;
    &lt;sj:progressbar id=&quot;progressbar&quot; value=&quot;%{random}&quot;/&gt;

	&lt;br/&gt;&lt;br/&gt;
	
    &lt;h2&gt;Progressbar with Execute And Wait Interceptor&lt;/h2&gt;
    &lt;p class=&quot;text&quot;&gt;
        A Progressbar in Combination with the Execute And Wait Interceptor.
    &lt;/p&gt;
    
    &lt;img id=&quot;indicator&quot; 
       	src=&quot;images/indicator.gif&quot; 
       	alt=&quot;Loading...&quot; 
       	style=&quot;display:none&quot;/&gt;
    &lt;s:url id=&quot;longRunningProcessUrl&quot; value=&quot;/long-running-process.action&quot;/&gt;
    &lt;sj:div id=&quot;divWithLongRunningProcess&quot; 
    		href=&quot;%{longRunningProcessUrl}&quot; 
    		indicator=&quot;indicator&quot; 
    		reloadTopics=&quot;reloadWithLongRunningProcess&quot;
    		listenTopics=&quot;startLongRunningProcess&quot; 
    		effect=&quot;highlight&quot; 
    		cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
    &lt;/sj:div&gt;
    &lt;sj:a 	
    	id=&quot;startProcessLink&quot; 
    	onClickTopics=&quot;startLongRunningProcess&quot; 
		button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-refresh&quot;
    &gt;
    	Refresh Process Status
    &lt;/sj:a&gt;
   </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
