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

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;sj:div id=&quot;withclick&quot; <strong>events=&quot;click&quot; effect=&quot;highlight&quot; effectDuration=&quot;4000&quot;
		  effectOptions=&quot;{ color: '#000000', mode: 'show' }&quot;</strong> cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
        Click me!&lt;br/&gt;
        Click me!&lt;br/&gt;
        Click me!&lt;br/&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>
