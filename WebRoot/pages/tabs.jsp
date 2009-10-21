<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urltabslocal" action="tabs-local"/><sj:a id="tabslocallink" href="%{urltabslocal}" targets="main">Local Tabs</sj:a></li>
      <li><s:url id="urltabs" action="tabs"/><sj:a id="tabslocalremote" href="%{urltabs}" targets="main">Remote Tabs</sj:a></li>
      <li><s:url id="urltabspreselect" action="tabs-preselect"/><sj:a id="tabspreselectedlink" href="%{urltabspreselect}" targets="main">Preselectet Tabs with Animation</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Remote Tabs</h2>
    <p>
        A simple TabbedPanel with AJAX Content with two disabled Tabs
    </p>
    <s:url id="remoteurl1" action="ajax1"/>
    <s:url id="remoteurl2" action="ajax2"/>
    <s:url id="remoteurl3" action="ajax3"/>
    <s:url id="remoteurl4" action="ajax4"/>
    <sj:tabbedpanel id="remotetabs" spinner="Please wait ..." disabledTabs="[3,4]">
      <sj:tab id="tab1" href="%{remoteurl1}" label="Tab One" />
      <sj:tab id="tab2" href="%{remoteurl2}" label="Tab Two"/>
      <sj:tab id="tab3" href="%{remoteurl3}" label="Tab Three"/>
      <sj:tab id="tab4" href="%{remoteurl4}" label="Tab Four"/>
      <sj:tab id="tab5" href="%{remoteurl4}" label="Tab Five"/>
    </sj:tabbedpanel>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;s:url id=&quot;remoteurl1&quot; action=&quot;ajax1&quot;/&gt;
    &lt;s:url id=&quot;remoteurl2&quot; action=&quot;ajax2&quot;/&gt;
    &lt;s:url id=&quot;remoteurl3&quot; action=&quot;ajax3&quot;/&gt;
    &lt;s:url id=&quot;remoteurl4&quot; action=&quot;ajax4&quot;/&gt;
    &lt;sj:tabbedpanel id=&quot;remotetabs&quot; spinner=&quot;Please wait ...&quot; disabledTabs=&quot;[3,4]&quot;&gt;
      &lt;sj:tab id=&quot;tab1&quot; href=&quot;%{remoteurl1}&quot; label=&quot;Remote Tab One&quot; /&gt;
      &lt;sj:tab id=&quot;tab2&quot; href=&quot;%{remoteurl2}&quot; label=&quot;Remote Tab Two&quot;/&gt;
      &lt;sj:tab id=&quot;tab3&quot; href=&quot;%{remoteurl3}&quot; label=&quot;Remote Tab Three&quot;/&gt;
      &lt;sj:tab id=&quot;tab4&quot; href=&quot;%{remoteurl4}&quot; label=&quot;Remote Tab Four&quot;/&gt;
    &lt;/sj:tabbedpanel&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
