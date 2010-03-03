<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urldialog" action="dialog"/><sj:a href="%{urldialog}" targets="main">Dialog</sj:a></li>
      <li><s:url id="urldialogclick" action="dialog-click"/><sj:a href="%{urldialogclick}" targets="main">Dialog open on Click</sj:a></li>
      <li><s:url id="urldialogremote" action="dialog-remote"/><sj:a href="%{urldialogremote}" targets="main">Remote Dialog</sj:a></li>
      <li><s:url id="urldialogmodal" action="dialog-modal"/><sj:a href="%{urldialogmodal}" targets="main">Modal Dialog</sj:a></li>
      <li><s:url id="urldialogbuttons" action="dialog-buttons"/><sj:a href="%{urldialogbuttons}" targets="main">Dialog with Buttons</sj:a></li>
      <li><s:url id="urldialogeffect" action="dialog-effect"/><sj:a href="%{urldialogeffect}" targets="main">Dialog with Effect</sj:a></li>
      <li><s:url id="urldialogtopics" action="dialog-topics"/><sj:a href="%{urldialogtopics}" targets="main">Dialog with Topics</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Remote Dialog</h2>
    <p>
        A Dialog with remote content.
    </p>
    <s:url id="ajax" value="/ajax1.action"/>
    <sj:dialog id="myremotedialog" href="%{ajax}" title="Dialog with remote content">
        <img id="indicator" src="images/indicator.gif" alt="Loading..."/>
    </sj:dialog>
    
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;s:url id="ajax" value="/ajax1.action"/&gt;
    &lt;sj:dialog id="myremotedialog" href="%{ajax}" title="Dialog with remote content"&gt;
        &lt;img id="indicator" src="images/indicator.gif" alt="Loading..."/&gt;
    &lt;/sj:dialog&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
