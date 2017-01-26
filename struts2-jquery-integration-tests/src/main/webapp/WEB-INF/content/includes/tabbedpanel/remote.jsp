<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url var="simpleTextAjaxUrl" namespace="/ajax" action="simple-text"/>
<s:url action="echo" namespace="/" var="echoUrl">
  <s:param name="echo">something to echo</s:param>
</s:url>

<sj:tabbedpanel id="myTabbedPanel">
  <sj:tab id="tab1" href="%{simpleTextAjaxUrl}" label="tab 1"/>
  <sj:tab id="tab2" href="%{echoUrl}" label="tab 2"/>
</sj:tabbedpanel>
