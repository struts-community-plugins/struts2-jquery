<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Dialog with Effect</h2>
    <p class="text">
        A modal Dialog with Effect.
    </p>
    <sj:dialog 
    	id="myeffectdialog" 
    	showEffect="slide" 
    	hideEffect="explode" 
    	autoOpen="false" 
    	modal="true" 
    	title="Dialog with Effect"
    	openTopics="openEffectDialog"
    	closeTopics="closeEffectDialog"
    >
	    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
	    <hr />
	    <sj:a 
	    	id="closeEffectDialogLink"
	    	onClickTopics="closeEffectDialog"
	    	button="true"
	    	buttonIcon="ui-icon-close"
	    >
	    	Close effect dialog
	    </sj:a>
    </sj:dialog>
    <sj:a 
 	    id="openEffectDialogLink"
    	onClickTopics="openEffectDialog"
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open effect dialog
    </sj:a>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;sj:dialog 
    	id=&quot;myeffectdialog&quot; 
    	showEffect=&quot;slide&quot; 
    	hideEffect=&quot;explode&quot; 
    	autoOpen=&quot;false&quot; 
    	modal=&quot;true&quot; 
    	title=&quot;Dialog with Effect&quot;
    	openTopics=&quot;openEffectDialog&quot;
    	closeTopics=&quot;closeEffectDialog&quot;
    &gt;
	    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
	    &lt;hr /&gt;
	    &lt;sj:a 
	    	onClickTopics=&quot;closeEffectDialog&quot;
	    	button=&quot;true&quot;
	    	buttonIcon=&quot;ui-icon-newwin&quot;
	    &gt;
	    	Close effect dialog
	    &lt;/sj:a&gt;
    &lt;/sj:dialog&gt;
    &lt;sj:a 
    	onClickTopics=&quot;openEffectDialog&quot;
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open effect dialog
    &lt;/sj:a&gt;
    </pre>
  </div>
