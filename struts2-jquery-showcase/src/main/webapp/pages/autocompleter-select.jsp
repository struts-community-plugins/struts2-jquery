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
    <h2>Autocompleter</h2>
    <p class="text">
        A Autocompleter that handle a List from Action as Select Box.
    </p>
    <strong>Result Div :</strong>
	<div id="formResult" class="result ui-widget-content ui-corner-all">Submit form bellow.</div>
    
    <s:form id="form" action="echo" theme="simple" cssClass="yform">
        <fieldset>
            <legend>Form with Autocompleter</legend>
	        <div class="type-select">
	            <label for="echo">Echo: </label>
    			<sj:autocompleter 
    				id="customers" 
    				name="echo" 
    				list="%{customers}" 
    				listValue="name" 
    				listKey="id" 
    				selectBox="true"
    			/>
	        </div>
	        <div>
	            <sj:submit 
	            	targets="formResult" 
	            	value="AJAX Submit" 
	            	indicator="indicator"
	            	button="true"
	            	/>
   				<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>    
	        </div>
        </fieldset>
    </s:form>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code in JSP:</strong>
    <pre>
    &lt;strong&gt;Result Div :&lt;/strong&gt;
	&lt;div id=&quot;formResult&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
    
    &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;simple&quot; cssClass=&quot;yform&quot;&gt;
        &lt;fieldset&gt;
            &lt;legend&gt;Form with Autocompleter&lt;/legend&gt;
	        &lt;div class=&quot;type-select&quot;&gt;
	            &lt;label for=&quot;echo&quot;&gt;Echo: &lt;/label&gt;
    			&lt;sj:autocompleter 
    				id=&quot;customers&quot; 
    				name=&quot;echo&quot; 
    				list=&quot;%{customers}&quot; 
    				listValue=&quot;name&quot; 
    				listKey=&quot;id&quot; 
    				selectBox=&quot;true&quot;
    			/&gt;
	        &lt;/div&gt;
	        &lt;div&gt;
	            &lt;sj:submit 
	            	targets=&quot;formResult&quot; 
	            	value=&quot;AJAX Submit&quot; 
	            	indicator=&quot;indicator&quot;
	            	button=&quot;true&quot;
	            	/&gt;
   				&lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;    
	        &lt;/div&gt;
        &lt;/fieldset&gt;
    &lt;/s:form&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
