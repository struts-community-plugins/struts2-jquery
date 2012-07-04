<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urldialog" action="dialog"/><sj:a href="%{urldialog}" targets="main">Dialog</sj:a></li>
      <li><s:url id="urldialogclick" action="dialog-click"/><sj:a href="%{urldialogclick}" targets="main">Dialog open on Click</sj:a></li>
      <li><s:url id="urldialogremote" action="dialog-remote"/><sj:a href="%{urldialogremote}" targets="main">Remote Dialog</sj:a></li>
      <li><s:url id="urldialogremotelink" action="dialog-remote-link"/><sj:a href="%{urldialogremotelink}" targets="main">Remote Dialogs</sj:a></li>
      <li><s:url id="urldialogmodal" action="dialog-modal"/><sj:a href="%{urldialogmodal}" targets="main">Modal Dialog</sj:a></li>
      <li><s:url id="urldialogbuttons" action="dialog-buttons"/><sj:a href="%{urldialogbuttons}" targets="main">Dialog with Buttons</sj:a></li>
      <li><s:url id="urldialogeffect" action="dialog-effect"/><sj:a href="%{urldialogeffect}" targets="main">Dialog with Effect</sj:a></li>
      <li><s:url id="urldialogtopics" action="dialog-topics"/><sj:a href="%{urldialogtopics}" targets="main">Dialog with Topics</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
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
    
	<s:url id="remoteurl1" action="ajax1"/>
    <s:url id="remoteurl2" action="ajax2"/>
    <s:url id="remoteurl3" action="ajax3"/>
    <s:url id="remoteurl4" action="ajax4"/>
	
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
  </div>
  
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
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
