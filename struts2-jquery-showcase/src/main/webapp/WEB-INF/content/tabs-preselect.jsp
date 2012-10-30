<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<h2>Remote Tabs with preselected Tab</h2>

<p class="text">
	A Remote TabbedPanel with preselected Tab, Animation, Collapsible and sortable Tabs.
</p>

<s:form id="echoForm">
	<s:textfield name="echo" value="Hello World!" label="Echo for Echo Tab"/>
</s:form>

<s:url var="remoteurl1" action="ajax1"/>
<s:url var="remoteurl2" action="ajax2"/>
<s:url var="remoteurl3" action="ajax3"/>
<s:url var="remoteurl4" action="ajax4"/>
<s:url var="remoteurl5" action="echo"/>
<sj:tabbedpanel id="remotetabs" selectedTab="2" show="true" hide="'fade'" collapsible="true" sortable="true">
	<sj:tab id="tab1" href="%{remoteurl1}" label="Remote Tab One"/>
	<sj:tab id="tab2" href="%{remoteurl2}" label="Remote Tab Two"/>
	<sj:tab id="tab3" href="%{remoteurl3}" label="Remote Tab Three" closable="true"/>
	<sj:tab id="tab4" href="%{remoteurl4}" label="Remote Tab Four" closable="true"/>
	<sj:tab id="tab5" formIds="echoForm" href="%{remoteurl5}" label="Echo Tab"/>
</sj:tabbedpanel>

<div class="code ui-widget-content ui-corner-all">
	<strong>Code:</strong>
    <pre>
    &lt;s:form id=&quot;echoForm&quot;&gt;
    	&lt;s:textfield name=&quot;echo&quot; value=&quot;Hello World!&quot; label=&quot;Echo for Echo Tab&quot;/&gt;
    &lt;/s:form&gt;

    &lt;s:url var=&quot;remoteurl1&quot; action=&quot;ajax1&quot;/&gt;
    &lt;s:url var=&quot;remoteurl2&quot; action=&quot;ajax2&quot;/&gt;
    &lt;s:url var=&quot;remoteurl3&quot; action=&quot;ajax3&quot;/&gt;
    &lt;s:url var=&quot;remoteurl4&quot; action=&quot;ajax4&quot;/&gt;
    &lt;s:url var=&quot;remoteurl5&quot; action=&quot;echo&quot;/&gt;
    &lt;sj:tabbedpanel id=&quot;remotetabs&quot;  selectedTab=&quot;2&quot; show=&quot;true&quot; hide=&quot;'fade'&quot; collapsible=&quot;true&quot; sortable=&quot;true&quot;&gt;
      &lt;sj:tab id=&quot;tab1&quot; href=&quot;%{remoteurl1}&quot; label=&quot;Remote Tab One&quot;/&gt;
      &lt;sj:tab id=&quot;tab2&quot; href=&quot;%{remoteurl2}&quot; label=&quot;Remote Tab Two&quot;/&gt;
      &lt;sj:tab id=&quot;tab3&quot; href=&quot;%{remoteurl3}&quot; label=&quot;Remote Tab Three&quot; closable=&quot;true&quot;/&gt;
      &lt;sj:tab id=&quot;tab4&quot; href=&quot;%{remoteurl4}&quot; label=&quot;Remote Tab Four&quot; closable=&quot;true&quot;/&gt;
      &lt;sj:tab id=&quot;tab5&quot; formIds=&quot;echoForm&quot; href=&quot;%{remoteurl5}&quot; label=&quot;Echo Tab&quot;/&gt;
    &lt;/sj:tabbedpanel&gt;
    </pre>
</div>
