<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlautocompleter" action="autocompleter"/><sj:a id="autocompletersimple" href="%{urlautocompleter}" targets="main">Autocompleter</sj:a></li>
      <li><s:url id="urlautocompleterjson" action="autocompleter-json"/><sj:a id="autocompleterjson" href="%{urlautocompleterjson}" targets="main">Autocompleter JSON</sj:a></li>
      <li><s:url id="urlautocompleterselect" action="autocompleter-select"/><sj:a id="autocompleterselect" href="%{urlautocompleterselect}" targets="main">Autocompleter (Select Box)</sj:a></li>
      <li><s:url id="urlautocompleterjsonselect" action="autocompleter-json-select"/><sj:a id="autocompleterjsonselect" href="%{urlautocompleterjsonselect}" targets="main">Autocompleter JSON (Select Box)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Autocompleter</h2>
    <p>
        A Autocompleter that handle a String Array from Action.
    </p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="formAutocomplete" action="echo" theme="xhtml">
     	<sj:autocompleter 
     		id="languages" 
     		name="echo"
     		list="%{languages}"
     		label="Select Languages"
     	/>
    	<sj:submit
    		id="submitFormAutocomplete" 
    		targets="result" 
    		button="true" 
    		value="Submit" 
    		indicator="indicator"
    		/>
    </s:form>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    

    
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code in JSP:</strong>
    <pre>
    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
    
    &lt;s:form id=&quot;formAutocomplete&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
     	&lt;sj:autocompleter 
     		id=&quot;languages&quot; 
     		name=&quot;echo&quot;
     		list=&quot;%{languages}&quot;
     		label=&quot;Select Languages&quot;
     	/&gt;
    	&lt;sj:submit
    		id=&quot;submitFormAutocomplete&quot; 
    		targets=&quot;result&quot; 
    		button=&quot;true&quot; 
    		validate=&quot;true&quot; 
    		value=&quot;Submit&quot; 
    		indicator=&quot;indicator&quot;
    		/&gt;
    &lt;/s:form&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
