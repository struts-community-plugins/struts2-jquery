<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h2>Messages</h2>

<p class="text">
	A sample for jQuery UI styled Action Errors and Messages. The Style is dependend from your Theme.
</p>
<div class="messagesexamples">
	<h3>Action Error</h3>
	<s:actionerror theme="jquery"/>
	<br/>

	<h3>Action Message</h3>
	<s:actionmessage theme="jquery"/>
	<br/>

	<h3>Field Errors</h3>
	<s:fielderror theme="jquery"/>
	<br/>
</div>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
	  <pre>
		&lt;h3&gt;Action Error&lt;/h3&gt;
		&lt;s:actionerror theme=&quot;jquery&quot;/&gt;
		
		&lt;h3&gt;Action Message&lt;/h3&gt;
		&lt;s:actionmessage theme=&quot;jquery&quot;/&gt;
		
		&lt;h3&gt;Field Errors&lt;/h3&gt;
		&lt;s:fielderror theme=&quot;jquery&quot;/&gt;
	  </pre>
</div>
