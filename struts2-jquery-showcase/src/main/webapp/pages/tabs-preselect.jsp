<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urltabslocal" action="tabs-local"/><sj:a id="tabslocallink" href="%{urltabslocal}" targets="main">Local Tabs</sj:a></li>
      <li><s:url id="urltabs" action="tabs"/><sj:a id="tabslocalremote" href="%{urltabs}" targets="main">Remote Tabs with Topics</sj:a></li>
      <li><s:url id="urltabspreselect" action="tabs-preselect"/><sj:a id="tabspreselectedlink" href="%{urltabspreselect}" targets="main">Preselectet Tabs with Animation</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Remote Tabs with preselected Tab</h2>
    <p class="text">
        A Remote TabbedPanel with preselected Tab,Animation and Collapsible.
    </p>
    <s:url id="remoteurl1" action="ajax1"/>
    <s:url id="remoteurl2" action="ajax2"/>
    <s:url id="remoteurl3" action="ajax3"/>
    <s:url id="remoteurl4" action="ajax4"/>
    <sj:tabbedpanel id="remotetabs" selectedTab="2" animate="true" collapsible="true">
      <sj:tab id="tab1" href="%{remoteurl1}" label="Remote Tab One"/>
      <sj:tab id="tab2" href="%{remoteurl2}" label="Remote Tab Two"/>
      <sj:tab id="tab3" href="%{remoteurl3}" label="Remote Tab Three" closable="true"/>
      <sj:tab id="tab4" href="%{remoteurl4}" label="Remote Tab Four" closable="true"/>
    </sj:tabbedpanel>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;s:url id="remoteurl1" action="ajax1"/&gt;
    &lt;s:url id="remoteurl2" action="ajax2"/&gt;
    &lt;s:url id="remoteurl3" action="ajax3"/&gt;
    &lt;s:url id="remoteurl4" action="ajax4"/&gt;
    &lt;sj:tabbedpanel id="remotetabs" <strong>selectedTab="2" animate="true" collapsible="true"</strong>&gt;
      &lt;sj:tab id="tab1" href="%{remoteurl1}" label="Remote Tab One"/&gt;
      &lt;sj:tab id="tab2" href="%{remoteurl2}" label="Remote Tab Two"/&gt;
      &lt;sj:tab id="tab3" href="%{remoteurl3}" label="Remote Tab Three"/&gt;
      &lt;sj:tab id="tab4" href="%{remoteurl4}" label="Remote Tab Four"/&gt;
    &lt;/sj:tabbedpanel&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
