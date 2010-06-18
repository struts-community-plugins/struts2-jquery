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
    <h2>Dialog with Buttons</h2>
    <p>
        A modal Dialog Dialog with Buttons.
    </p>
    <script type="text/javascript">
      function okButton() {
       alert('OK Button pressed!');
      }
     function cancelButton() {
      alert('Cancel Button pressed!');
      $('#mybuttondialog').dialog('close');
     }
    </script>        
    <sj:dialog 
    	id="mybuttondialog" 
    	buttons="{ 
    		'OK':function() { okButton(); },
    		'Cancel':function() { cancelButton(); } 
    		}" 
    	autoOpen="false" 
    	modal="true" 
    	title="Dialog with Buttons"
    >
     Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
    </sj:dialog>
    <sj:submit 
    	openDialog="mybuttondialog" 
    	value="Open modal dialog with Buttons" 
    	button="true"
    />
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
      <strong>JavaScript functions:</strong>
      <pre>
      function okButton(){
       alert('OK Button pressed!');
     };
     function cancelButton(){
      alert('Cancel Button pressed!');
      $('#mybuttondialog').dialog('close');
     };
      </pre>
    <strong>Code:</strong>
    <pre>
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
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
