<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Buttonset / CheckboxList</h2>

<p class="text">
	Create a Buttonset from Checkbox List.
</p>
<strong>Result Div :</strong>

<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>

<strong>Buttonset that was populated from a List with String values.</strong>
<s:form id="form" action="echo" theme="xhtml">
	<sj:checkboxlist
			id="checkboxbuttonset"
			tooltip="Choose your Friends"
			label="Friends"
			list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
			name="echo"/>
	<sj:submit
			targets="formResult"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			/>
</s:form>
<br/>
<strong>Buttonset that was populated from AJAX JSON Result.</strong>
<s:form id="form2" action="echo" theme="xhtml">
	<s:url var="remoteurl" action="jsonsample"/>
	<sj:checkboxlist
			href="%{remoteurl}"
			id="remoteCheckboxlist"
			name="echo"
			list="languageList"
			label="Language"
			/>
	<sj:submit
			targets="formResult"
			value="AJAX Submit"
			indicator="indicator"
			button="true"
			/>
</s:form>

<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    <strong>Buttonset that was populated from a List with String values.</strong>
    &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
			    &lt;sj:checkboxlist
			    		id=&quot;checkboxbuttonset&quot;
			            tooltip=&quot;Choose your Friends&quot;
			            label=&quot;Friends&quot;
			            list=&quot;{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}&quot;
			            name=&quot;echo&quot;/&gt;
	            &lt;sj:submit 
	            	targets=&quot;formResult&quot; 
	            	value=&quot;AJAX Submit&quot; 
	            	indicator=&quot;indicator&quot;
	            	button=&quot;true&quot;
	            	/&gt;
    &lt;/s:form&gt;
    &lt;br/&gt;
    <strong>Buttonset that was populated from AJAX JSON Result.</strong>
    &lt;s:form id=&quot;form2&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
				&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonsample&quot;/&gt; 
				&lt;sj:checkboxlist
					href=&quot;%{remoteurl}&quot; 
					id=&quot;remoteCheckboxlist&quot; 
					name=&quot;echo&quot; 
					list=&quot;languageList&quot; 
					label=&quot;Language&quot;
				/&gt;
	            &lt;sj:submit 
	            	targets=&quot;formResult&quot; 
	            	value=&quot;AJAX Submit&quot; 
	            	indicator=&quot;indicator&quot;
	            	button=&quot;true&quot;
	            	/&gt;
   &lt;/s:form&gt;

    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
</div>
