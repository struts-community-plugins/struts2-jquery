<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div id="col1">
  <div id="col1_content" class="clearfix">
    <ul>
      <li><s:url var="urltabslocal" action="tabs-local"/><sj:a id="tabslocallink" href="%{urltabslocal}" targets="main">Local Tabs</sj:a></li>
      <li><s:url var="urltabs" action="tabs"/><sj:a id="tabslocalremote" href="%{urltabs}" targets="main">Remote Tabs with Topics</sj:a></li>
      <li><s:url var="urltabspreselect" action="tabs-preselect"/><sj:a id="tabspreselectedlink" href="%{urltabspreselect}" targets="main">Preselectet Tabs with Animation</sj:a></li>
    </ul>
  </div>
</div>
<div id="col3">
  <div id="col3_content" class="clearfix">
    <h2>Remote Tabs with preselected Tab</h2>
    <p class="text">
        A Remote TabbedPanel with preselected Tab, Animation, Collapsible and sortable Tabs.
    </p>
    
    <s:form id="echoForm">
    	<s:textfield name="echo" value="Hello" label="Echo for Echo Tab"/>
    </s:form>
    
    <s:url var="remoteurl1" action="ajax1"/>
    <s:url var="remoteurl2" action="ajax2"/>
    <s:url var="remoteurl3" action="ajax3"/>
    <s:url var="remoteurl4" action="ajax4"/>
    <s:url var="remoteurl5" action="echo"/>
    <sj:tabbedpanel id="remotetabs"  selectedTab="2" animate="true" collapsible="true" sortable="true" onRemoveTopics="removeTabEvent">
      <sj:tab id="tab1" href="%{remoteurl1}" label="Remote Tab One"/>
      <sj:tab id="tab2" href="%{remoteurl2}" label="Remote Tab Two"/>
      <sj:tab id="tab3" href="%{remoteurl3}" label="Remote Tab Three" closable="true"/>
      <sj:tab id="tab4" href="%{remoteurl4}" label="Remote Tab Four" closable="true"/>
      <sj:tab id="tab5" formIds="echoForm" href="%{remoteurl5}" label="Echo Tab"/>
    </sj:tabbedpanel>
  </div>
  
  <div class="code ui-widget-content ui-corner-all">
    <strong>Code:</strong>
    <pre>
    &lt;s:form id=&quot;echoForm&quot;&gt;
    	&lt;s:textfield name=&quot;echo&quot; value=&quot;Hello&quot; label=&quot;Echo for Echo Tab&quot;/&gt;
    &lt;/s:form&gt;
    
    &lt;s:url id=&quot;remoteurl1&quot; action=&quot;ajax1&quot;/&gt;
    &lt;s:url id=&quot;remoteurl2&quot; action=&quot;ajax2&quot;/&gt;
    &lt;s:url id=&quot;remoteurl3&quot; action=&quot;ajax3&quot;/&gt;
    &lt;s:url id=&quot;remoteurl4&quot; action=&quot;ajax4&quot;/&gt;
    &lt;s:url id=&quot;remoteurl5&quot; action=&quot;echo&quot;/&gt;
    &lt;sj:tabbedpanel id=&quot;remotetabs&quot;  selectedTab=&quot;2&quot; animate=&quot;true&quot; collapsible=&quot;true&quot; sortable=&quot;true&quot;&gt;
      &lt;sj:tab id=&quot;tab1&quot; href=&quot;%{remoteurl1}&quot; label=&quot;Remote Tab One&quot;/&gt;
      &lt;sj:tab id=&quot;tab2&quot; href=&quot;%{remoteurl2}&quot; label=&quot;Remote Tab Two&quot;/&gt;
      &lt;sj:tab id=&quot;tab3&quot; href=&quot;%{remoteurl3}&quot; label=&quot;Remote Tab Three&quot; closable=&quot;true&quot;/&gt;
      &lt;sj:tab id=&quot;tab4&quot; href=&quot;%{remoteurl4}&quot; label=&quot;Remote Tab Four&quot; closable=&quot;true&quot;/&gt;
      &lt;sj:tab id=&quot;tab5&quot; formIds=&quot;echoForm&quot; href=&quot;%{remoteurl5}&quot; label=&quot;Echo Tab&quot;/&gt;
    &lt;/sj:tabbedpanel&gt;
    </pre>
  </div>
  <!-- IE Column Clearing -->
  <div id="ie_clearing"> &#160; </div>
</div>
