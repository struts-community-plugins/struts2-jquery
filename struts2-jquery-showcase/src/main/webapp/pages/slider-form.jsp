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
	<h2>Slider with Form</h2>
	<p class="text">
	    Slider in a form with AJAX submit.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="sliderForm" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="echo">Echo: <span id="displayvaluespan">40</span></label>
	            <sj:slider 
	            	id="echo" 
	            	name="echo" 
	            	value="40" 
	            	displayValueElement="displayvaluespan" 
	            	min="20" 
	            	max="200" 
	            	animate="true" 
	            	step="5" 
	            	cssStyle="margin: 10px;"
	            />
	        </div>
	        <div class="type-button">
	            <sj:a 
	            	id="submitSliderForm"
	            	formIds="sliderForm" 
	            	button="true" 
	            	buttonIcon="ui-icon-gear" 
	            	targets="result" 
	            	indicator="indicator_slider_form"
	            >
	            AJAX Submit
	            </sj:a> 
	            <img 
	            	id="indicator_slider_form" 
	            	src="images/indicator.gif" 
	            	alt="Loading..."
	            	style="display:none"
	            /> 
	        </div>
        </fieldset>
    </s:form>

	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
&lt;s:form id=&quot;sliderForm&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
	&lt;fieldset&gt;
		&lt;legend&gt;AJAX Form&lt;/legend&gt;
		&lt;div class=&quot;type-text&quot;&gt;
			&lt;label for=&quot;echo&quot;&gt;Echo: &lt;span id=&quot;displayvaluespan&quot;&gt;40&lt;/span&gt;&lt;/label&gt;
			&lt;sj:slider 
				id=&quot;echo&quot; 
				name=&quot;echo&quot; 
				value=&quot;40&quot; 
				displayValueElement=&quot;displayvaluespan&quot; 
				min=&quot;20&quot; 
				max=&quot;200&quot; 
				animate=&quot;true&quot; 
				step=&quot;5&quot; 
				cssStyle=&quot;margin: 10px;&quot;
			/&gt;
		&lt;/div&gt;
		&lt;div class=&quot;type-button&quot;&gt;
			&lt;sj:a 
				id=&quot;submitSliderForm&quot;
				formIds=&quot;sliderForm&quot; 
				button=&quot;true&quot; 
				buttonIcon=&quot;ui-icon-gear&quot; 
				targets=&quot;result&quot; 
				indicator=&quot;indicator_slider_form&quot;
			&gt;
			AJAX Submit
			&lt;/sj:a&gt; 
			&lt;img 
				id=&quot;indicator_slider_form&quot; 
				src=&quot;images/indicator.gif&quot; 
				alt=&quot;Loading...&quot;
				style=&quot;display:none&quot;
			/&gt; 
		&lt;/div&gt;
	&lt;/fieldset&gt;
&lt;/s:form&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
