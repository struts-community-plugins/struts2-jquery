<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Highlight Effect</h2>

<p class="text">
	A Div with Highlight Effect on click.
</p>
<strong>Div :</strong>
<sj:div id="withclick" events="click" effect="highlight" effectDuration="4000"
        effectOptions="{ color: '#000000' }" cssClass="result ui-widget-content ui-corner-all">
	Click me!<br/>
	Click me!<br/>
	Click me!<br/>
</sj:div>

<h4>Source Code</h4>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    	<code class="html">
&lt;sj:div id=&quot;withclick&quot; events=&quot;click&quot; effect=&quot;highlight&quot; effectDuration=&quot;4000&quot;
	  effectOptions=&quot;{ color: '#000000', mode: 'show' }&quot; cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
	Click me!&lt;br/&gt;
	Click me!&lt;br/&gt;
	Click me!&lt;br/&gt;
&lt;/sj:div&gt;
		</code>
	  </pre>
</div>
