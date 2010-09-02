<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
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
	<h2>Richtext</h2>
	<p class="text">
	    A simple Richtext Editor with default values. The Richtext Editor is based on <a href="http://ckeditor.com/">CKEditor</a>.
	</p>
	<p>
	    To enable the Richtext Editor in your Project you need to copy the separate <strong>struts2-jquery-richtext-plugin.jar</strong> into your WEB-INF/lib path.
	</p>
    <s:form id="formRichtext" action="simpleecho" theme="simple" cssClass="yform">
    <s:hidden name="escape" value="false"/>
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="echo">Echo: </label>
				<sjr:ckeditor 
					id="richtextEditor" 
					name="echo" 
					rows="10" 
					cols="80" 
					width="800"
					value="Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."
				/>
	        </div>
	        <div class="type-button">
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
	        </div>
        </fieldset>
    </s:form>

    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    

    
	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
	&lt;%@ taglib prefix=&quot;sj&quot; uri=&quot;/struts-jquery-tags&quot;%&gt;
	<strong>
	&lt;%@ taglib prefix=&quot;sjr&quot; uri=&quot;/struts-jquery-richtext-tags&quot;%&gt;
	</strong>

    &lt;s:form id=&quot;formRichtext&quot; action=&quot;simpleecho&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
    &lt;s:hidden name=&quot;escape&quot; value=&quot;false&quot;/&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
	            <strong>
				&lt;sjr:ckeditor 
					id=&quot;richtextEditor&quot; 
					name=&quot;echo&quot; 
					rows=&quot;10&quot; 
					cols=&quot;80&quot; 
					width=&quot;800&quot;
					value=&quot;Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.&quot;
				&gt;
				&lt;/sjr:ckeditor&gt;
				</strong>
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
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
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;

    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
