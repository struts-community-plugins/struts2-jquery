<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urlautocompleter" action="autocompleter"/><sj:a id="autocompletersimple" href="%{urlautocompleter}" targets="main">Autocompleter</sj:a></li>
      <li><s:url id="urlautocompleterjson" action="autocompleter-json"/><sj:a id="autocompleterjson" href="%{urlautocompleterjson}" targets="main">Autocompleter JSON</sj:a></li>
      <li><s:url id="urlautocompleterselect" action="autocompleter-select"/><sj:a id="autocompleterselect" href="%{urlautocompleterselect}" targets="main">Autocompleter (Select Box)</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Autocompleter with JSON Result</h2>
    <p>
        A Autocompleter that handle a JSON Result.
    </p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="formAutocompleteJson" action="echo" theme="simple">
		<s:url id="remoteurl" action="jsonlanguages"/> 
	    <sj:autocompleter 
	    	id="languages" 
	    	name="echo"
	    	href="%{remoteurl}" 
	    	delay="50" 
	    	loadMinimumCount="2"
	    />
		<br/>
    	<sj:submit
    		id="submitFormAutocompleteJson" 
    		targets="result" 
    		button="true" 
    		validate="true" 
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
    
    &lt;s:form id=&quot;formAutocompleteJson&quot; action=&quot;echo&quot; theme=&quot;simple&quot;&gt;
		&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonlanguages&quot;/&gt; 
	    &lt;sj:autocompleter 
	    	id=&quot;languages&quot; 
	    	name=&quot;echo&quot;
	    	href=&quot;%{remoteurl}&quot; 
	    	delay=&quot;50&quot; 
	    	loadMinimumCount=&quot;2&quot;
	    /&gt;
		&lt;br/&gt;
    	&lt;sj:submit
    		id=&quot;submitFormAutocompleteJson&quot; 
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
