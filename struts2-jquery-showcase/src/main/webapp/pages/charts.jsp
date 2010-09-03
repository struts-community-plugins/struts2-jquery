<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
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
      <li><s:url id="urlcharts" action="charts"/><sj:a id="chartslink" href="%{urlcharts}" targets="main">Charts</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Charts</h2>


	<h3>Chart with values from a List or a Map</h3>
    <sjc:chart id="chartPoints" cssStyle="width: 600px; height: 400px;">
    	<sjc:chartData
    		label="List -Points-"
    		list="points"
    		points="{ show: true }"
    		lines="{ show: true }"
    	/>
    	<sjc:chartData
    		label="List -Points with Null Value-"
    		list="pointsWithNull"
    	/>
    	<sjc:chartData
    		label="Map -Integer, Integer-"
    		list="pointsFromMap"
    	/>
    </sjc:chart>

    <br/>

	<h3>Chart with values from a List with Objects</h3>
    <sjc:chart id="chartObjects" cssStyle="width: 600px; height: 400px;">
    	<sjc:chartData
    		label="List with Objects"
    		list="objList"
    		listKey="myKey"
    		listValue="myValue"
    		points="{ show: true }"
    		lines="{ show: true }"
    		clickable="true"
    		hoverable="true"
    	/>
    </sjc:chart>

    <br/>

	<h3>Chart with Date Values</h3>
    <sjc:chart
    	id="chartDate"
    	xaxisMode="time"
    	xaxisTimeformat="%0m.%y"
    	xaxisMin="%{minTime}"
    	xaxisMax="%{maxTime}"
    	xaxisColor="#666"
    	xaxisTickSize="[2, 'month']"
    	xaxisTickColor="#aaa"
    	xaxisPosition="top"
    	yaxisPosition="right"
    	yaxisTickSize="10"
    	cssStyle="width: 600px; height: 400px;"
    >
    	<sjc:chartData
    		label="Map -Date, Integer-"
    		list="dateFromMap"
    		color="#990066"
    		bars="{ show: true }"
    	/>
    </sjc:chart>

    <br/>

	<h3>Chart with AJAX Data</h3>
	<s:url id="chartDataUrl" action="json-chart-data"/>
    <sjc:chart
    	id="chartAjax"
    	legendLabelBoxBorderColor="#990033"
    	legendPosition="ne"
    	legendShow="#ccc"
    	cssStyle="width: 600px; height: 400px;"
    >
    	<sjc:chartData
    		label="Map -Double, Double-"
    		href="%{chartDataUrl}"
    		list="doubleMap"
    	/>
    	<sjc:chartData
    		label="List -ListValue-"
    		href="%{chartDataUrl}"
    		list="objList"
    		listKey="myKey"
    		listValue="myValue"
    	/>
    </sjc:chart>
  </div>

  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
