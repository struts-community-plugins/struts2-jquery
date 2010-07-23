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
    <h2>Autocompleter with JSON Result</h2>
    <p>
        A Autocompleter that handle a JSON Result with keys and values.
    </p>
    <strong>Result Div :</strong>
	<div id="result" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="formAutocompleteJsonSelect" action="echo" theme="simple">
		<s:url id="remoteurl" action="jsoncustomers"/> 
	    <sj:autocompleter 
	    	id="languages" 
	    	name="echo"
	    	href="%{remoteurl}" 
	    	list="customers"
    		listValue="name" 
    		listKey="id" 
	    	delay="50" 
	    	loadMinimumCount="2"
	    />
		<br/>
    	<sj:submit
    		id="submitFormAutocompleteJsonSelect" 
    		targets="result" 
    		button="true" 
    		value="Submit" 
    		indicator="indicator"
    		/>
    </s:form>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    

  </div>
  <br/>
    <sj:tabbedpanel id="localtabs" cssClass="list">
      <sj:tab id="tab1" target="jsp" label="JSP Code"/>
      <div id="jsp">
	  <pre>
    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
    
    &lt;s:form id=&quot;formAutocompleteJsonSelect&quot; action=&quot;echo&quot; theme=&quot;simple&quot;&gt;
		&lt;s:url id=&quot;remoteurl&quot; action=&quot;jsoncustomers&quot;/&gt; 
	    &lt;sj:autocompleter 
	    	id=&quot;languages&quot; 
	    	name=&quot;echo&quot;
	    	href=&quot;%{remoteurl}&quot; 
	    	list=&quot;customers&quot;
    		listValue=&quot;name&quot; 
    		listKey=&quot;id&quot; 
	    	delay=&quot;50&quot; 
	    	loadMinimumCount=&quot;2&quot;
	    /&gt;
		&lt;br/&gt;
    	&lt;sj:submit
    		id=&quot;submitFormAutocompleteJsonSelect&quot; 
    		targets=&quot;result&quot; 
    		button=&quot;true&quot; 
    		value=&quot;Submit&quot; 
    		indicator=&quot;indicator&quot;
    		/&gt;
    &lt;/s:form&gt;
    &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	  </pre>
	  </div>
 	</sj:tabbedpanel>
  
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
