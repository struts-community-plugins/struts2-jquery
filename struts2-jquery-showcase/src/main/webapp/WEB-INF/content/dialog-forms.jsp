<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Local Dialog and Remote Dialog with Forms</h2>
    <p class="text">
        A sample for Dialogs with Form Elements.
    </p>

	<s:url var="form1_url" action="form"/>
    <s:url var="form2_url" action="form-validation-custome"/>

    <sj:dialog 
    	id="remoteformdialog" 
    	autoOpen="false"
    	href="%{form1_url}" 
    	modal="true"
    	width="800"
    	height="600" 
    	title="Dialog with Remote Form"
    />

    <sj:dialog 
    	id="localformdialog" 
    	autoOpen="false"
    	modal="true"
    	width="800"
    	height="600" 
    	title="Dialog with Local Form"
    >
		<s:form id="formEffect" action="echo" theme="xhtml">
			<s:textfield id="echo" name="echo" label="Echo" value="Hello World!!!"/><br/>
			<sj:submit
					targets="result"
					effect="blind"
					effectMode="show"
					onEffectCompleteTopics="hideTarget"
					value="AJAX Submit"
					indicator="indicator"
					button="true"
					/>
		</s:form>
		<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
		
		<strong>Result Div :</strong>
		
		<div id="result" class="result ui-widget-content ui-corner-all" style="display: none;">Submit form bellow.</div>
    </sj:dialog>
	
    <sj:a 
    	openDialog="localformdialog"
    	openDialogTitle="Dialog with Local Form"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Dialog with Local Form
    </sj:a>
	
    <sj:a
    	href="%{form1_url}" 
    	openDialog="remoteformdialog"
    	openDialogTitle="Dialog with Remote Form"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Dialog with Remote Form
    </sj:a>
	
    <sj:a
    	href="%{form2_url}" 
    	openDialog="remoteformdialog"
    	openDialogTitle="Dialog with Remote Form (Validation)"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Dialog with Remote Form (Validation)
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
