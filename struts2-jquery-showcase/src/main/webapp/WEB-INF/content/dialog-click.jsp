<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

    <h2>Dialog opened by Link</h2>
    <p class="text">
        A modal Dialog open by click on Link.
    </p>
    <sj:dialog 
    	id="myclickdialog" 
    	autoOpen="false" 
    	modal="true" 
    	title="Modal Dialog"
    >
     Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </sj:dialog>
    <sj:a 
    	openDialog="myclickdialog" 
    	button="true"
    	buttonIcon="ui-icon-newwin"
    >
    	Open modal dialog
    </sj:a>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;sj:dialog 
    	id=&quot;myclickdialog&quot; 
    	autoOpen=&quot;false&quot; 
    	modal=&quot;true&quot; 
    	title=&quot;Modal Dialog&quot;
    &gt;
     Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    &lt;/sj:dialog&gt;
    &lt;sj:a 
    	openDialog=&quot;myclickdialog&quot; 
    	button=&quot;true&quot;
    	buttonIcon=&quot;ui-icon-newwin&quot;
    &gt;
    	Open modal dialog
    &lt;/sj:a&gt;
    </pre>
  </div>
