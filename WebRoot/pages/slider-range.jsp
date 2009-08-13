<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlslider" action="slider"/><sj:a href="%{urlslider}" targets="main">Slider</sj:a></li>
      <li><s:url id="urlsliderform" action="slider-form"/><sj:a href="%{urlsliderform}" targets="main">Slider in a Form</sj:a></li>
      <li><s:url id="urlsliderrange" action="slider-range"/><sj:a href="%{urlsliderrange}" targets="main">Slider with Range and Events</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <script type="text/javascript">
     function stop(event, ui){
         alert('Slider stop with value : '+ui.value);
     }
    </script>        
	<h2>Sliders with min and max Range and Events</h2>
	<p>
	    Slider with min and max Range in a form with AJAX submit.<br/>
	    The slider raise an event when slide is stoping.
	</p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="form1" action="echo" theme="xhtml" cssStyle="width: 400px; margin: 10px;">
         <sj:slider id="echo1" name="echo" label="Echo" value="70" stop="stop" range="min" min="20" max="200" step="5" cssStyle="width: 300px; margin: 10px;"/>
         <sj:submit id="slidersubmit1" targets="result" value="AJAX Submit" indicator="indicator_slider_range"/> <img id="indicator_slider_range" src="images/indicator.gif" alt="Loading..." style="display:none"/> 
    </s:form>
    <s:form id="form2" action="echo" theme="xhtml" cssStyle="width: 400px; margin: 10px;">
         <sj:slider id="echo2" name="echo" label="Echo" value="120" orientation="vertical" stop="stop" range="max" min="20" max="200" step="5" cssStyle="height: 200px; margin: 10px;"/>
         <sj:submit id="slidersubmit2" targets="result" value="AJAX Submit" indicator="indicator_slider_range"/> <img id="indicator_slider_range" src="images/indicator.gif" alt="Loading..." style="display:none"/> 
    </s:form>

	<div class="code ui-widget-content ui-corner-all">
	  <strong>Code:</strong>
	  <pre>
	    &lt;script type="text/javascript"&gt;
	     function stop(event, ui){
	         alert('Slider stop with value : '+ui.value);
	     }
	    &lt;/script&gt;        

        &lt;sj:slider id="echo1" name="echo" label="Echo" value="70" stop="stop" range="min" min="20" max="200" step="5" cssStyle="width: 300px; margin: 10px;"&gt;
        
        and
        
        &lt;sj:slider id="echo2" name="echo" label="Echo" value="120" orientation="vertical" stop="stop" range="max" min="20" max="200" step="5" cssStyle="height: 200px; margin: 10px;"&gt;
	  </pre>
	</div>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
