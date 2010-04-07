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
      <li><s:url id="urlrichtext" action="richtext"/><sj:a id="richtextlink" href="%{urlrichtext}" targets="main">Richtext</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
	<h2>Richtext</h2>
	<p>
	    A Textarea with remote content.
	</p>
    <s:form id="formTextarea" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            <label for="echo">Echo: </label>
				<s:url id="remoteurl" action="ajax1"/>
				<sjr:ckeditor 
					href="%{remoteurl}" 
					id="echo" 
					name="echo" 
					rows="10" 
					cols="80" 
					effect="highlight" 
					effectDuration="1500" 
					loadingText="Loading content of textarea ..."
					width="700"
				/>
	        </div>
	        <div class="type-button">
				<sj:submit 
					targets="result" 
					effect="slide" 
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
    &lt;s:form id=&quot;formTextarea&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;ajax1&quot;/&gt;
				&lt;sj:textarea 
					href=&quot;%{remoteurl}&quot; 
					id=&quot;echo&quot; 
					name=&quot;echo&quot; 
					rows=&quot;10&quot; 
					cols=&quot;80&quot; 
					effect=&quot;highlight&quot; 
					effectDuration=&quot;1500&quot; 
					loadingText=&quot;Loading content of textarea ...&quot;
				/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit 
					targets=&quot;result&quot; 
					effect=&quot;slide&quot; 
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
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
