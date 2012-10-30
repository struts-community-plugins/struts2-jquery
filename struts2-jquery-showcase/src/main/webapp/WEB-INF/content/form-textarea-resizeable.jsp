<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Textarea / Resizable</h2>

<p class="text">
	A resizable Textarea with an onChangeTopic.
</p>
<s:form id="formTextareaResize" action="simpleecho" theme="simple" cssClass="yform">
	<fieldset>
		<legend>AJAX Form</legend>
		<div class="type-text">
			<label for="echo">Echo: </label>
			<sj:textarea
					resizable="true"
					resizableGhost="true"
					resizableHelper="ui-state-highlight"
					id="echo"
					name="echo"
					rows="4"
					cols="80"
					onChangeTopics="submitThisForm"
					/>
		</div>
		<div class="type-button">
			<sj:submit
					targets="result"
					value="AJAX Submit"
					indicator="indicator"
					button="true"
					listenTopics="submitThisForm"
					/>
			<img id="indicator"
			     src="images/indicator.gif"
			     alt="Loading..." style="display:none"/>
		</div>
	</fieldset>
</s:form>

<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all">Enter some text in the Textarea above.</div>


<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
     &lt;s:form id=&quot;formTextareaResize&quot; action=&quot;simpleecho&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;AJAX Form&lt;/legend&gt;
	        &lt;div class=&quot;type-text&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
				&lt;sj:textarea
					resizable=&quot;true&quot;
					resizableGhost=&quot;true&quot;
					resizableHelper=&quot;ui-state-highlight&quot;
					id=&quot;echo&quot;
					name=&quot;echo&quot;
					rows=&quot;4&quot;
					cols=&quot;80&quot;
					onChangeTopics=&quot;submitThisForm&quot;
				/&gt;
	        &lt;/div&gt;
	        &lt;div class=&quot;type-button&quot;&gt;
				&lt;sj:submit
					targets=&quot;result&quot;
					value=&quot;AJAX Submit&quot;
					indicator=&quot;indicator&quot;
					button=&quot;true&quot;
					listenTopics=&quot;submitThisForm&quot;
				/&gt;
				&lt;img id=&quot;indicator&quot;
					src=&quot;images/indicator.gif&quot;
					alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;

    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;
		Enter some text in the Textarea above.
	&lt;/div&gt;
	  </pre>
</div>
