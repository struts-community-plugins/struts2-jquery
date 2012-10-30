<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Spinner</h2>

<p class="text">
	A Spinner Widget.
</p>

<h3>A simple Spinner</h3>
<sj:spinner name="spinner1" id="spinner1"/>
<br/>
<br/>

<h3>A Spinner max=50 and step=2</h3>
<sj:spinner
		name="spinner2"
		id="spinner2"
		min="5"
		max="50"
		step="2"
		value="25"/>
<br/>
<br/>

<h3>A Spinner with currency format and mouse wheel support</h3>
<sj:spinner
		name="spinner3"
		id="spinner3"
		min="0.00"
		max="5.00"
		step="0.15"
		value="2.50"
		suffix="$"
		mouseWheel="true"/>
<br/>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
    <pre>
    &lt;h3&gt;A simple Spinner&lt;/h3&gt;
    &lt;sj:spinner name=&quot;spinner1&quot; id=&quot;spinner1&quot;/&gt;
    &lt;br/&gt;
    &lt;br/&gt;
    &lt;h3&gt;A Spinner max=50 and step=2&lt;/h3&gt;
    &lt;sj:spinner 
    	name=&quot;spinner2&quot; 
    	id=&quot;spinner2&quot; 
    	min=&quot;5&quot; 
    	max=&quot;50&quot; 
    	step=&quot;2&quot; 
    	value=&quot;25&quot;/&gt;
    &lt;br/&gt;
    &lt;br/&gt;
    &lt;h3&gt;A Spinner with currency format and mouse wheel support&lt;/h3&gt;
    &lt;sj:spinner 
    	name=&quot;spinner3&quot; 
    	id=&quot;spinner3&quot; 
    	min=&quot;0.00&quot; 
    	max=&quot;5.00&quot; 
    	step=&quot;0.15&quot; 
    	value=&quot;2.50&quot; 
    	suffix=&quot;$&quot; 
    	mouseWheel=&quot;true&quot;/&gt;
    &lt;br/&gt;
    </pre>
</div>
