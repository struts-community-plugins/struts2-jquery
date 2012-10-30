<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <h2>Dialog with Topics</h2>
    <p class="text">
        A modal Dialog with different topics.
    </p>
    <sj:dialog 
    	id="mytopicdialog" 
    	openTopics="openTopicDialog"
    	onOpenTopics="dialogopentopic" 
    	onCloseTopics="dialogclosetopic" 
    	onBeforeCloseTopics="dialogbeforeclosetopic" 
    	autoOpen="false" 
    	modal="true" 
    	title="Topics Dialog">
    	Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </sj:dialog>
    <sj:a id="opentopicdialoglink"
    	onClickTopics="openTopicDialog" 
    	cssClass="buttonlink ui-state-default ui-corner-all"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open modal dialog
    </sj:a>
  <br/><br/>
    <sj:tabbedpanel id="showdialogcode">
      <sj:tab id="tab1" target="jsp" label="JSP Code"/>
      <sj:tab id="tab2" target="javascript" label="JavaScript Code"/>
      <div id="jsp">
	  <pre>
    &lt;sj:dialog 
    	id=&quot;mytopicdialog&quot; 
    	openTopics=&quot;openTopicDialog&quot;
    	onOpenTopics=&quot;dialogopentopic&quot; 
    	onCloseTopics=&quot;dialogclosetopic&quot; 
    	onBeforeCloseTopics=&quot;dialogbeforeclosetopic&quot; 
    	autoOpen=&quot;false&quot; 
    	modal=&quot;true&quot; 
    	title=&quot;Topics Dialog&quot;&gt;
    	Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    &lt;/sj:dialog&gt;
    &lt;sj:a id=&quot;opentopicdialoglink&quot;
    	onClickTopics=&quot;openTopicDialog&quot; 
    	cssClass=&quot;buttonlink ui-state-default ui-corner-all&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open modal dialog
    &lt;/sj:a&gt;
    	  </pre>
	  </div>
      <div id="javascript">
	  <pre>
    &lt;script type=&quot;text/javascript&quot;&gt;
    $(document).ready(function() {
		$.subscribe('dialogopentopic', function(event,ui) {
	        alert('run topic on dialog open');
		});
		$.subscribe('dialogclosetopic', function(event,ui) {
	        alert('run topic on dialog close');
		});
		$.subscribe('dialogbeforeclosetopic', function(event,ui) {
	        alert('run topic before dialog close');
		});
    });
    &lt;/script&gt;        
	  </pre>
	  </div>
    </sj:tabbedpanel>
