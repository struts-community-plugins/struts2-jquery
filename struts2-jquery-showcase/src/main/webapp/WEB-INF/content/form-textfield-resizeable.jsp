<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Textfield with AJAX Content / Resizable</h2>

<p class="text">
	A resizable Textfield with remote content.
</p>
<s:form id="formTextfieldResize" action="echo" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<s:url var="urlsimpleecho" action="simpleecho">
				<s:param name="echo">remote content for textfield!</s:param>
			</s:url>
			<sj:textfield
					href="%{urlsimpleecho}"
					resizable="true"
					resizableGhost="true"
					resizableHelper="ui-state-highlight"
					resizableMaxHeight="30"
					effect="blind"
					effectDuration="1500"
					effectOptions="{
						mode: 'show'
					}"
					id="echo"
					name="echo"
					onChangeTopics="changeTextfield"
					loadingText="Loading content of textfield ..."
					/>
		</div>
		<div class="type-button">
			<sj:submit
					targets="result"
					effect="highlight"
					effectDuration="1500"
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
    &lt;s:form id=&quot;formTextfieldResize&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
	    		&lt;s:url id=&quot;urlsimpleecho&quot; action=&quot;simpleecho&quot;&gt;
	    			&lt;s:param name=&quot;echo&quot;&gt;remote content for textfield!&lt;/s:param&gt;
	    		&lt;/s:url&gt;
				&lt;sj:textfield 
					href=&quot;%{urlsimpleecho}&quot; 
					resizable=&quot;true&quot; 
					resizableGhost=&quot;true&quot; 
					resizableHelper=&quot;ui-state-highlight&quot; 
					resizableMaxHeight=&quot;30&quot; 
					effect=&quot;blind&quot; 
					effectDuration=&quot;1500&quot;
					effectOptions=&quot;{
						mode: 'show'
					}&quot;
					id=&quot;echo&quot; 
					name=&quot;echo&quot;
					loadingText=&quot;Loading content of textfield ...&quot;
				/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit 
					targets=&quot;result&quot; 
					effect=&quot;highlight&quot; 
					effectDuration=&quot;1500&quot; 
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
