<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Form submission with AJAX with Effect</h2>

<p class="text">
	Submit a form with AJAX and run a slide effect.
</p>
<s:form id="formEffect" action="echo" theme="xhtml">
	<s:textfield id="echo" name="echo" label="Echo" value="Hello World!!!"/><br/>
	<sj:submit
			targets="result"
			effect="blind"
			effectMode="show"
			onEffectCompleteTopics="hideTarget"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			/>
</s:form>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<strong>Result Div :</strong>

<div id="result" class="result ui-widget-content ui-corner-all" style="display: none;">Submit form bellow.</div>


<div class="code ui-widget-content ui-corner-all">
	<strong>JavaScript Code:</strong>
	  <pre>
	$.subscribe('hideTarget', function(event, data) {
		$('#'+event.originalEvent.targets).delay(2000).hide("blind", 2500);
	});
	  </pre>

	<strong>JSP Code:</strong>
	  <pre>
    &lt;s:form id=&quot;formEffect&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
                &lt;s:textfield id=&quot;echo&quot; name=&quot;echo&quot; label=&quot;Echo&quot; value=&quot;Hello World!!!&quot;/&gt;&lt;br/&gt;
                &lt;sj:submit 
                	targets=&quot;result&quot; 
                	effect=&quot;slide&quot; 
                	effectMode=&quot;blind&quot;
                	onEffectCompleteTopics=&quot;hideTarget&quot;
                	value=&quot;AJAX Submit&quot; 
                	indicator=&quot;indicator&quot; 
                	button=&quot;true&quot;
                /&gt;
    &lt;/s:form&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
</div>
