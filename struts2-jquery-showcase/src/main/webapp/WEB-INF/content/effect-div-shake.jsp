<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Shake Effect</h2>

<p class="text">
	A Div with Shake Effect on mouse over.
</p>
<strong>Div :</strong>
<sj:div events="mouseover" effect="shake" effectDuration="600" cssClass="result ui-widget-content ui-corner-all">
	Hover me!<br/>
	Hover me!<br/>
	Hover me!<br/>
</sj:div>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;sj:div <strong>events=&quot;mouseover&quot; effect=&quot;shake&quot; effectDuration=&quot;600&quot;</strong> cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
        Hover me!&lt;br/&gt;
        Hover me!&lt;br/&gt;
        Hover me!&lt;br/&gt;
    &lt;/sj:div&gt;
	  </pre>
</div>

