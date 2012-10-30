<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Modal Dialog</h2>
    <p class="text">
        A modal Dialog with remote content.
    </p>
    <s:url var="ajax" value="/ajax2.action"/>
    <sj:dialog 
    	id="mymodaldialog" 
    	href="%{ajax}" 
    	modal="true" 
    	overlayColor="#903" 
    	overlayOpacity="0.8" 
    	title="Modal Dialog"
    	position="['right','top']"
    >
        <img id="indicator" src="images/indicator.gif" alt="Loading..."/>
    </sj:dialog>

  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;sj:dialog 
    	id=&quot;mymodaldialog&quot; 
    	href=&quot;%{ajax}&quot; 
    	modal=&quot;true&quot; 
    	overlayColor=&quot;#903&quot; 
    	overlayOpacity=&quot;0.8&quot; 
    	title=&quot;Modal Dialog&quot;
    	position=&quot;['right','top']&quot;
    &gt;
        &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot;/&gt;
    &lt;/sj:dialog&gt;
    </pre>
  </div>
