<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Size Effect</h2>

<p class="text">
	A Div with Size Effect bind on a link.
</p>
<strong>Div :</strong>
<sj:div
		id="sizediv"
		bindOn="startlink"
		events="click"
		effect="scale"
		effectOptions="{ percent: 200, direction: 'horizontal' }"
		effectDuration="1000"
		cssClass="result ui-widget-content ui-corner-all"
		cssStyle="width: 200px; height: 200px; background: blue; color: yellow;"
		>
	Do you love Struts2 with jQuery?
</sj:div>
<sj:a
		id="startlink"
		href="#"
		button="true"
		buttonIconSecondary="ui-icon-arrow-2-se-nw"
		>
	Size Div
</sj:a>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
    &lt;sj:div 
    	bindOn=&quot;startlink&quot; 
    	events=&quot;click&quot; 
    	effect=&quot;scale&quot; 
    	effectOptions=&quot;{ percent: 200, direction: 'horizontal' }&quot; 
    	effectDuration=&quot;1000&quot; 
    	cssClass=&quot;result ui-widget-content ui-corner-all&quot; 
    	cssStyle=&quot;width: 200px; height: 200px; background: blue; color: yellow;&quot;
    &gt;
        Do you love Struts2 with jQuery?
    &lt;/sj:div&gt;
    &lt;sj:a 
    	id=&quot;startlink&quot; 
    	href=&quot;#&quot; 
    	button=&quot;true&quot; 
    	buttonIconSecondary=&quot;ui-icon-arrow-2-se-nw&quot;
    &gt;
    	Size Div
    &lt;/sj:a&gt;
	  </pre>
</div>
