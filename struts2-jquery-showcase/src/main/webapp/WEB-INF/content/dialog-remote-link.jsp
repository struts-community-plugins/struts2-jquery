<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Dialog opened by different Links</h2>
    <p class="text">
        A modal Dialog open by click on Link and loads the result as dialog content.
    </p>
    <sj:dialog 
    	id="myremotelinkdialog" 
    	autoOpen="false" 
    	modal="true" 
    	title="Dialog with different Content"
    	openTopics="openRemoteDialog"
    />
    
	<s:url var="remoteurl1" action="ajax1"/>
    <s:url var="remoteurl2" action="ajax2"/>
    <s:url var="remoteurl3" action="ajax3"/>
    <s:url var="remoteurl4" action="ajax4"/>
	
    <sj:a 
    	openDialog="myremotelinkdialog"
    	openDialogTitle="Dialog One"
    	href="%{remoteurl1}"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open Dialog One
    </sj:a>
    <sj:a 
    	onClickTopics="openRemoteDialog"
    	openDialogTitle="Dialog Two"
    	href="%{remoteurl2}"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open Dialog Two
    </sj:a>
    <sj:a 
    	onClickTopics="openRemoteDialog"
     	openDialogTitle="Dialog Three"
    	href="%{remoteurl3}"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open Dialog Three
    </sj:a>
    <sj:a 
    	openDialog="myremotelinkdialog"
    	openDialogTitle="Dialog Four"
    	href="%{remoteurl4}"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open Dialog Four
    </sj:a>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;sj:dialog 
    	id=&quot;myremotelinkdialog&quot; 
    	autoOpen=&quot;false&quot; 
    	modal=&quot;true&quot; 
    	title=&quot;Dialog with different Content&quot;
    	openTopics=&quot;openRemoteDialog&quot;
    /&gt;
    
	&lt;s:url id=&quot;remoteurl1&quot; action=&quot;ajax1&quot;/&gt;
    &lt;s:url id=&quot;remoteurl2&quot; action=&quot;ajax2&quot;/&gt;
    &lt;s:url id=&quot;remoteurl3&quot; action=&quot;ajax3&quot;/&gt;
    &lt;s:url id=&quot;remoteurl4&quot; action=&quot;ajax4&quot;/&gt;
	
    &lt;sj:a 
    	openDialog=&quot;myremotelinkdialog&quot;
    	href=&quot;%{remoteurl2}&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open Dialog One
    &lt;/sj:a&gt;
    &lt;sj:a 
    	onClickTopics=&quot;openRemoteDialog&quot;
    	href=&quot;%{remoteurl1}&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open Dialog Two
    &lt;/sj:a&gt;
    &lt;sj:a 
    	onClickTopics=&quot;openRemoteDialog&quot;
    	href=&quot;%{remoteurl3}&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open Dialog Three
    &lt;/sj:a&gt;
    &lt;sj:a 
    	openDialog=&quot;myremotelinkdialog&quot;
    	href=&quot;%{remoteurl4}&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open Dialog Four
    &lt;/sj:a&gt;
    </pre>
  </div>
