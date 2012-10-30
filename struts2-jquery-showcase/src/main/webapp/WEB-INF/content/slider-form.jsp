<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
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
