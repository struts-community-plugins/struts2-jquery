<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Progressbar</h2>

<p class="text">
	A simple Progressbar
</p>
<sj:progressbar id="progressbar" value="%{random}"/>

<br/><br/>

<h2>Progressbar with Execute And Wait Interceptor</h2>

<p class="text">
	A Progressbar in Combination with the Execute And Wait Interceptor.
</p>

<img id="indicator"
     src="images/indicator.gif"
     alt="Loading..."
     style="display:none"/>
<s:url var="longRunningProcessUrl" value="/long-running-process.action"/>
<sj:div id="divWithLongRunningProcess"
        href="%{longRunningProcessUrl}"
        indicator="indicator"
        reloadTopics="reloadWithLongRunningProcess"
        listenTopics="startLongRunningProcess"
        effect="highlight"
        cssClass="result ui-widget-content ui-corner-all">
</sj:div>
<sj:a
		id="startProcessLink"
		onClickTopics="startLongRunningProcess"
		button="true"
		buttonIcon="ui-icon-refresh"
		>
	Refresh Process Status
</sj:a>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
    <pre>
     &lt;h2&gt;Progressbar&lt;/h2&gt;
    &lt;p class=&quot;text&quot;&gt;
        A simple Progressbar
    &lt;/p&gt;
    &lt;sj:progressbar id=&quot;progressbar&quot; value=&quot;%{random}&quot;/&gt;

	&lt;br/&gt;&lt;br/&gt;
	
    &lt;h2&gt;Progressbar with Execute And Wait Interceptor&lt;/h2&gt;
    &lt;p class=&quot;text&quot;&gt;
        A Progressbar in Combination with the Execute And Wait Interceptor.
    &lt;/p&gt;
    
    &lt;img id=&quot;indicator&quot; 
       	src=&quot;images/indicator.gif&quot; 
       	alt=&quot;Loading...&quot; 
       	style=&quot;display:none&quot;/&gt;
    &lt;s:url id=&quot;longRunningProcessUrl&quot; value=&quot;/long-running-process.action&quot;/&gt;
    &lt;sj:div id=&quot;divWithLongRunningProcess&quot; 
    		href=&quot;%{longRunningProcessUrl}&quot; 
    		indicator=&quot;indicator&quot; 
    		reloadTopics=&quot;reloadWithLongRunningProcess&quot;
    		listenTopics=&quot;startLongRunningProcess&quot; 
    		effect=&quot;highlight&quot; 
    		cssClass=&quot;result ui-widget-content ui-corner-all&quot;&gt;
    &lt;/sj:div&gt;
    &lt;sj:a 	
    	id=&quot;startProcessLink&quot; 
    	onClickTopics=&quot;startLongRunningProcess&quot; 
		button=&quot;true&quot; 
		buttonIcon=&quot;ui-icon-refresh&quot;
    &gt;
    	Refresh Process Status
    &lt;/sj:a&gt;
   </pre>
</div>
