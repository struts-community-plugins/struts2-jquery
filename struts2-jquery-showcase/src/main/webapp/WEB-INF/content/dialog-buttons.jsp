<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <h2>Dialog with Buttons</h2>
    <p class="text">
        A modal Dialog Dialog with Buttons.
    </p>
    <script type="text/javascript">
        function okButton() {
            alert('OK Button pressed!');
        }
        function cancelButton() {
            alert('Cancel Button pressed!');
            $.publish('closeButtonDialog');
        }
    </script>        
    <sj:dialog 
    	id="mybuttondialog" 
    	buttons="{ 
    		'OK':function() { okButton(); },
    		'Cancel':function() { cancelButton(); } 
    	}"
        closeTopics="closeButtonDialog"
    	autoOpen="false" 
    	modal="true" 
    	title="Dialog with Buttons"
    >
     Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </sj:dialog>
    <sj:a
        id="openButtonDialogLink"
    	openDialog="mybuttondialog"
    	button="true"
    >Open modal dialog with Buttons</sj:a>

<h4>Source Code</h4>

<sj:tabbedpanel id="sourcecode">
    <sj:tab id="tab1" target="jsp" label="JSP Code"/>
    <sj:tab id="tab2" target="javascript" label="JavaScript"/>
    <div id="jsp">
	    <pre>
            <code class="html">
&lt;sj:dialog
    id=&quot;mybuttondialog&quot;
    buttons=&quot;{
        'OK':function() { okButton(); },
        'Cancel':function() { cancelButton(); }
    }&quot;
    autoOpen=&quot;false&quot;
    modal=&quot;true&quot;
    title=&quot;Dialog with Buttons&quot;
&gt;
    Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
&lt;/sj:dialog&gt;
&lt;sj:submit
    openDialog=&quot;mybuttondialog&quot;
    value=&quot;Open modal dialog with Buttons&quot;
    button=&quot;true&quot;
/&gt;
            </code>
	    </pre>
    </div>
    <div id="javascript">
	    <pre>
          <code class="javascript">
function okButton(){
    alert('OK Button pressed!');
};
function cancelButton(){
    alert('Cancel Button pressed!');
    $('#mybuttondialog').dialog('close');
};
          </code>
	    </pre>
    </div>
</sj:tabbedpanel>
