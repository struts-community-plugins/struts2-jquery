<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Buttonset / Radio Buttons</h2>

<p class="text">
	Create a Buttonset from Radio Buttons Map.
</p>
<strong>Result Div :</strong>

<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<strong>Buttonset that was populated from a List with String values.</strong>
<s:form id="form" action="echo" theme="simple">
	<label for="echo">Choose your Friend: </label>
	<sj:radio
			id="radiobuttonset"
			list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
			name="echo"
			onChangeTopics="submitForm1"
			/>
	<br/>
	<sj:submit
			targets="formResult"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			listenTopics="submitForm1"
			cssStyle="display:none;"
			/>
</s:form>
<br/>
<strong>Buttonset that was populated from AJAX JSON Result with onChangeTopic.</strong>
<s:form id="form2" action="echo" theme="xhtml">
	<s:url var="remoteurl" action="jsonsample"/>
	<sj:radio
			href="%{remoteurl}"
			id="remoteRadiobuttons"
			name="echo"
			list="languageMap"
			label="Language"
			onChangeTopics="submitForm2"
			/>
	<sj:submit
			id="form2button"
			targets="formResult"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			listenTopics="submitForm2"
			cssStyle="display:none;"
			/>
</s:form>

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;formResult&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
    
    &lt;strong&gt;Buttonset that was populated from a List with String values.&lt;/strong&gt;
    &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;simple&quot;&gt;
            &lt;label for=&quot;echo&quot;&gt;Choose your Friend: &lt;/label&gt;
		    &lt;sj:radio
		    		id=&quot;radiobuttonset&quot;
		            list=&quot;{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}&quot;
		            name=&quot;echo&quot;
					onChangeTopics=&quot;submitForm1&quot;
		    /&gt;
		    &lt;br/&gt;
            &lt;sj:submit 
	           	targets=&quot;formResult&quot; 
	           	value=&quot;AJAX Submit&quot; 
	           	indicator=&quot;indicator&quot;
	           	button=&quot;true&quot;
	            listenTopics=&quot;submitForm1&quot;
            	cssStyle=&quot;display:none;&quot;
           	/&gt;
    &lt;/s:form&gt;
	&lt;br/&gt;
    &lt;strong&gt;Buttonset that was populated from AJAX JSON Result with onChangeTopic.&lt;/strong&gt;
    &lt;s:form id=&quot;form2&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:radio
					href=&quot;%{remoteurl}&quot; 
					id=&quot;remoteRadiobuttons&quot; 
					name=&quot;echo&quot; 
					list=&quot;languageMap&quot; 
					label=&quot;Language&quot;
					onChangeTopics=&quot;submitForm2&quot;
				/&gt;
	            &lt;sj:submit 
	            	id=&quot;form2button&quot;
	            	targets=&quot;formResult&quot; 
	            	value=&quot;AJAX Submit&quot; 
	            	indicator=&quot;indicator&quot;
	            	button=&quot;true&quot;
	            	listenTopics=&quot;submitForm2&quot;
	            	cssStyle=&quot;display:none;&quot;
	            	/&gt;
   &lt;/s:form&gt;

   &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
</div>
