<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url id="urltabs" action="tabs"/><sj:a href="%{urltabs}" targets="main">Remote Tabs</sj:a></li>
      <li><s:url id="urltabslocal" action="tabs-local"/><sj:a href="%{urltabslocal}" targets="main">Local Tabs</sj:a></li>
      <li><s:url id="urltabspreselect" action="tabs-preselect"/><sj:a href="%{urltabspreselect}" targets="main">Preselectet Tabs with Animation</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Remote Tabs</h2>
    <p>
        A simple Remote TabbedPanel
    </p>
    <s:url id="remoteurl1" action="ajax1"/>
    <s:url id="remoteurl2" action="ajax2"/>
    <s:url id="remoteurl3" action="ajax3"/>
    <s:url id="remoteurl4" action="ajax4"/>
    <sj:tabbedpanel id="remotetabs" spinner="Please wait ...">
      <sj:tab id="tab1" href="%{remoteurl1}" label="Remote Tab One" />
      <sj:tab id="tab2" href="%{remoteurl2}" label="Remote Tab Two"/>
      <sj:tab id="tab3" href="%{remoteurl3}" label="Remote Tab Three"/>
      <sj:tab id="tab4" href="%{remoteurl4}" label="Remote Tab Four"/>
    </sj:tabbedpanel>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;s:url id=&quot;remoteurl1&quot; action=&quot;ajax1&quot;/&gt;
    &lt;s:url id=&quot;remoteurl2&quot; action=&quot;ajax2&quot;/&gt;
    &lt;s:url id=&quot;remoteurl3&quot; action=&quot;ajax3&quot;/&gt;
    &lt;s:url id=&quot;remoteurl4&quot; action=&quot;ajax4&quot;/&gt;
    &lt;sj:tabbedpanel id=&quot;remotetabs&quot; spinner=&quot;Please wait ...&quot;&gt;
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
